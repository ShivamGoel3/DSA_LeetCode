class Solution {
    public int mySqrt(int x) {
        long start = 0, end = x;
        long ans = 0;
        while (start <= end) {
            long mid = end - (end - start) / 2;
            if (mid * mid == x)
                return (int) mid;
            if (mid * mid < x) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return (int) ans;
    }
}