class Solution {
    public double myPow(double x, int n) {
        long val = n;
        if (val == 0)
            return 1;
        double ans = 1;
        boolean neg = false;
        if (val < 0) {
            neg = true;
            // n *= -1;
        }
        val = Math.abs(val);
        // System.out.println(val + " " + Integer.MIN_VALUE);
        while (val > 1) {
            if (val % 2 == 0) {
                x *= x;
                val /= 2;
            } else {
                ans *= x;
                val--;
            }
        }
        ans *= x;
        // System.out.println(ans);
        if (neg)
            return (1 * 1.0) / ans;
        else
            return ans;
    }
}