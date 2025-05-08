class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int num1 = 0;
        int num2 = x;
        while (x > 0) {
            int a = x % 10;
            x /= 10;
            num1 *= 10;
            num1 += a;
        }
        return num1 == num2;
    }
}