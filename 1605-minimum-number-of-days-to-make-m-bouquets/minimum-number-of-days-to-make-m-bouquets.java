class Solution {
    long call(int[] bloomDay, long mid, int k) {
        long sum = 0;
        long count = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= mid)
                sum++;
            else
                sum = 0;
            if (sum>0 && sum % k == 0)
                count++;
        }
        return count;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        long start = bloomDay[0];
        long end = start;
        for (int i = 0; i < bloomDay.length; i++) {
            start = Math.min(start, bloomDay[i]);
            end = Math.max(end, bloomDay[i]);
        }
        long ans = -1;
        while (start <= end) {
            long mid = end - (end - start) / 2;
            long count = call(bloomDay, mid, k);
            // System.out.println(start + " " + end + " " + mid + " " + count);
            if (count < m) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return (int) ans;
    }
}