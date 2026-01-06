class MedianFinder {
    PriorityQueue<Integer> minheap = new PriorityQueue<>();
    PriorityQueue<Integer> maxheap = new PriorityQueue<>(new Comparator<Integer>() {
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    });

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (maxheap.size() > minheap.size()) {
            minheap.add(num);
        } else {
            maxheap.add(num);
        }
        if (minheap.size() == 0)
            return;
        int a = maxheap.poll();
        int b = minheap.poll();
        if (a <= b) {
            maxheap.add(a);
            minheap.add(b);
        } else {
            maxheap.add(b);
            minheap.add(a);
        }
    }

    public double findMedian() {
        if (minheap.size() == maxheap.size()) {
            return (minheap.peek() + maxheap.peek()) * 1.0 / 2;
        } else {
            return maxheap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */