class Solution {
    double call(int[] nums1, int[] nums2) {
        int low = 0, high = nums1.length;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = (nums1.length + nums2.length + 1) / 2 - mid1;

            int l1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int r1 = mid1 == nums1.length ? Integer.MAX_VALUE : nums1[mid1];
            int l2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int r2 = mid2 == nums2.length ? Integer.MAX_VALUE : nums2[mid2];
            if (l1 <= r2 && l2 <= r1) {
                if ((nums1.length + nums2.length) % 2 == 1)
                    return Math.max(l1, l2);
                else {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            }
            if (l1 > r2) {
                high = mid1 - 1;
            } else
                low = mid1 + 1;
        }
        return 0;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return call(nums2, nums1);
        else
            return call(nums1, nums2);
    }
}