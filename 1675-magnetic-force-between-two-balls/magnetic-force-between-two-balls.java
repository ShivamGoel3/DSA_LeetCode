class Solution {
    boolean call(int[] position, int dis, int m) {
        int count = 1;
        int index = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - index >= dis) {
                count++;
                index = position[i];
            }
        }
        return count >= m;
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int start = 1;
        int end = position[position.length - 1] - position[0];
        int ans = 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            boolean check = call(position, mid, m);
            if (check) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}