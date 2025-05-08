public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int number = 0;
        for (int i = 0; i <= 31; i++) {
            int bit = (n >> i) & 1;
            number *= 2;
            number += bit;
        }
        return number;
    }
}