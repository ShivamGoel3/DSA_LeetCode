class Solution {
    long time(int[] piles, long speed) {
        long count = 0;
        if (speed == 0)
            return Integer.MAX_VALUE;
        for (int i = 0; i < piles.length; i++) {
            // if(speed == 0)
            // {
            //     count+=piles[i];

            // }
            if (piles[i] > speed) {
                count += piles[i] / speed;
                if (piles[i] % speed > 0)
                    count++;
            }
            // count += piles[i] / speed;
            else
                count += 1;

        }
        return count;
    }

    public int minEatingSpeed(int[] piles, int h) {

        long start = 1;
        long end = 0;
        for (int i = 0; i < piles.length; i++) {
            end = Math.max(end, piles[i]);
        }
        long ans = end;
        while (start <= end) {
            long mid = end - (end - start) / 2;
            long count = time(piles, mid);
            // System.out.println(start + " " + mid + " " + end + " " + count);
            if (count <= h) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return (int) ans;
    }
}