class Solution {
    int find(ArrayList<Integer> a, int ele) {
        int start = 0;
        int end = a.size() - 1;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (a.get(mid) > ele) {
                ans = a.get(mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (s.size() > 0 && nums[s.peek()] <= nums[i % n])
                s.pop();
            ans[i % n] = s.size() == 0 ? -1 : nums[s.peek()];
            s.push(i % n);
        }
        return ans;
    }
}