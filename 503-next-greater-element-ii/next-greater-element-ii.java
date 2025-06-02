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
        for (int i = n - 1; i >= 0; i--) {
            while (s.size() > 0 && s.peek() <= nums[i])
                s.pop();
            ans[i] = s.size() == 0 ? Integer.MIN_VALUE : s.peek();
            s.push(nums[i]);
        }
        int max = 0;
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (ans[i] == Integer.MIN_VALUE) {
                ans[i] = find(a, nums[i]);
            }
            if (a.size() == 0 || a.get(a.size() - 1) <= nums[i])
                a.add(nums[i]);
        }
        return ans;
    }
}