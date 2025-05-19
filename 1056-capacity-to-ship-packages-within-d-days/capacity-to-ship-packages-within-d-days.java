class Solution {
    int call(int[] weights, int weight) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < weights.length; i++) {
            if (sum + weights[i] > weight) {
                count++;
                sum = weights[i];
            } else {
                sum += weights[i];
            }
        }
        return count + 1;
    }

    public int shipWithinDays(int[] weights, int days) {
        int start = weights[0];
        int end = 0;
        for (int i = 0; i < weights.length; i++) {
            end += weights[i];
            start = Math.max(start, weights[i]);
        }
        int ans = end;
        while (start <= end) {
            int mid = (start + end) / 2;
            int time = call(weights, mid);
            if (time <= days) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}