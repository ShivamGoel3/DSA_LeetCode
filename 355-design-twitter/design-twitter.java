class Twitter {
    ArrayList<HashSet<Integer>> arr = new ArrayList<>();
    ArrayList<int[]> q = new ArrayList<>();

    public Twitter() {
        for (int i = 0; i <= 500; i++) {
            arr.add(new HashSet<>());
        }
    }

    public void postTweet(int userId, int tweetId) {
        q.add(new int[] { userId, tweetId });
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        int count = 0;
        int i = q.size() - 1;
        while (i >= 0 && count < 10) {
            int[] a = q.get(i);
            i--;
            if (a[0] == userId || arr.get(userId).contains(a[0])) {
                ans.add(a[1]);
                count++;
            }
        }
        // while (b.size() > 0) {
        //     q.add(b.poll());
        // }
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        arr.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        arr.get(followerId).remove(followeeId);
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