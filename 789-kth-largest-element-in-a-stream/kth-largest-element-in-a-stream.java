class KthLargest {
    int size = 0;
    Queue<Integer> q = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        size = k;
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        q.add(val);
        if (q.size() > size)
            q.poll();
        return q.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */