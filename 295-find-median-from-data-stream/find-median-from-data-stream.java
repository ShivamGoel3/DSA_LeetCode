class MedianFinder {
    Queue<Integer> q = new PriorityQueue<>();
    Queue<Integer> p = new PriorityQueue<>(new Comparator<Integer>() {
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    });

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (p.size() > q.size())
            q.add(num);
        else
            p.add(num);
        if (q.size() > 0) {
            if (p.peek() > q.peek()) {
                int a = p.poll();
                int b = q.poll();
                p.add(b);
                q.add(a);
            }
        }
    }

    public double findMedian() {
        if (p.size() > q.size())
            return p.peek();
        else {
            return ((double) (p.peek() + q.peek()) * 1.0) / 2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */