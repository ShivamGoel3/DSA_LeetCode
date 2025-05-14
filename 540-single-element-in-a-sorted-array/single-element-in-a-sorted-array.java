class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length - 1;
        int n = nums.length;
        while (start <= end) {
            int mid = (start + end) / 2;
            if ((mid + 1 < n && nums[mid] == nums[mid + 1])) {
                if (mid % 2 == 0)
                    start = mid + 1;
                else
                    end = mid - 1;
            } else if ((mid - 1 >= 0 && nums[mid] == nums[mid - 1])) {
                if (mid % 2 == 1)
                    start = mid + 1;
                else
                    end = mid - 1;

            } else
                return nums[mid];
        }
        return -1;
    }
}