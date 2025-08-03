class Solution {
    void call(int[] nums, List<List<Integer>> ans, List<Integer> t, int index) {
        ans.add(new ArrayList<>(t));
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            //call(nums, ans, t, i + 1);
            t.add(nums[i]);
            call(nums, ans, t, i + 1);
            t.remove(t.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        call(nums, ans, t, 0);
        return ans;
    }
}