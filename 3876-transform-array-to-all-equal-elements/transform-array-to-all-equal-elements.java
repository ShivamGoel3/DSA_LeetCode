class Solution {
    public boolean canMakeEqual(int[] nums, int k) {
        int count = 0;
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            a[i] = nums[i];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 1)
                continue;
            // System.out.print(i + " ");

            nums[i] *= -1;
            nums[i + 1] *= -1;
            count++;
        }
        if (nums[nums.length - 1] == -1)
            count = Integer.MAX_VALUE;
        // System.out.println(count);
        if (count <= k)
            return true;
        count = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == -1)
                continue;
            a[i] *= -1;
            a[i + 1] *= -1;
            count++;
            // System.out.print(i + " ");
        }
        // System.out.println(count);

        if (a[a.length - 1] == 1)
            count = Integer.MAX_VALUE;
        if (count <= k)
            return true;
        return false;
    }
}