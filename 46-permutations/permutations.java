class Solution {
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void call(int[] nums, List<List<Integer>> ans, List<Integer> t, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            t.add(nums[index]);
            call(nums, ans, t, index + 1);
            t.remove(t.size() - 1);
            swap(nums, i, index);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        call(nums, ans, t, 0);
        return ans;
    }
}