class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    List<Integer> t = new ArrayList<>();
                    t.add(nums[i]);
                    t.add(nums[j]);
                    t.add(nums[k]);
                    ans.add(t);
                    j++;
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    k--;
                    while (k > j && nums[k] == nums[k + 1])
                        k--;
                }
            }
            i++;
            while (i < nums.length && nums[i] == nums[i - 1])
                i++;
        }
        return ans;
    }
}