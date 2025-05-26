class Twitter {
    ArrayList<HashSet<Integer>> flist = new ArrayList<>();
    ArrayList<ArrayList<int[]>> tlist = new ArrayList<>();
    int count = 0;

    public Twitter() {
        for (int i = 0; i <= 500; i++) {
            flist.add(new HashSet<>());
            tlist.add(new ArrayList<>());
        }
    }

    public void postTweet(int userId, int tweetId) {
        tlist.get(userId).add(new int[] { tweetId, count });
        count++;
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<>() {
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < tlist.get(userId).size(); i++) {
            q.add(new int[] { tlist.get(userId).get(i)[0], tlist.get(userId).get(i)[1] });
        }
        for (Integer i : flist.get(userId)) {
            for (int j = 0; j < tlist.get(i).size(); j++) {
                q.add(new int[] { tlist.get(i).get(j)[0], tlist.get(i).get(j)[1] });
            }
        }
        int count = 0;

        while (q.size() > 0 && count < 10) {
            int[] a = q.poll();
            // if (a[0] == userId || arr.get(userId).contains(a[0])) {
            ans.add(a[0]);
            count++;
            // }
        }
        // while (b.size() > 0) {
        //     q.add(b.poll());
        // }
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        flist.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        flist.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */