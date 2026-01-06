class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        while (i < nums.length - 2) {
            int sum = nums[i];
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (sum + nums[j] + nums[k] == 0) {
                    List<Integer> t = new ArrayList<>();
                    t.add(nums[i]);
                    t.add(nums[j]);
                    t.add(nums[k]);
                    ans.add(t);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                } else if (sum + nums[j] + nums[k] < 0) {
                    j++;
                } else if (sum + nums[j] + nums[k] > 0) {
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