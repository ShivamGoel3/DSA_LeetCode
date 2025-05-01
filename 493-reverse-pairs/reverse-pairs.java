class Solution {
    int ans = 0;

    void merge(int[] nums, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;
        int[] a1 = new int[n1];
        int[] a2 = new int[n2];
        for (int i = 0; i < n1; i++) {
            a1[i] = nums[start + i];
            // System.out.print(a1[i] + " ");
        }
        // System.out.print(" - ");
        for (int i = 0; i < n2; i++) {
            a2[i] = nums[mid + 1 + i];
            // System.out.print(a2[i] + " ");
        }
        // System.out.print(" - ");
        int w = 0;
        int q = 0;
        while (q < n1 && w < n2) {
            //w = 0;
            // if (a2[w] == Integer.MAX_VALUE)
            //     break;
            while (q < n1) {
                long b = a1[q];
                long a = b - a2[w] - a2[w];
                if (a <= 0)
                    q++;
                else
                    break;
            }
            ans += n1 - q;
            w++;
            // q++;
        }
        int i = 0, j = 0, k = start;
        while (i < a1.length && j < a2.length) {
            if (a1[i] < a2[j]) {
                nums[k] = a1[i];
                i++;
                k++;
            } else {
                nums[k] = a2[j];
                j++;
                k++;
            }
        }
        while (i < a1.length) {
            nums[k] = a1[i];
            i++;
            k++;
        }
        while (j < a2.length) {
            nums[k] = a2[j];
            j++;
            k++;
        }
        // System.out.println("");
    }

    void mergesort(int[] nums, int start, int end) {
        if (start >= end)
            return;
        int mid = (start + end) / 2;
        mergesort(nums, start, mid);
        mergesort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    public int reversePairs(int[] nums) {
        ans = 0;
        int start = 0, end = nums.length - 1;
        mergesort(nums, start, end);
        // for (int i = 0; i <= end; i++)
        //     if (nums[i] > 300)
        //         System.out.print(nums[i] + " ");
        return ans;
    }
}