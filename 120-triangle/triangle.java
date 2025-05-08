class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int ans = Integer.MAX_VALUE;
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < triangle.size(); i++) {
            dp.add(new ArrayList<>());
        }
        dp.get(0).add(triangle.get(0).get(0));
        if (triangle.size() == 1)
            ans = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    int a = triangle.get(i).get(j) + dp.get(i - 1).get(0);
                    dp.get(i).add(a);
                } else if (j == triangle.get(i).size() - 1) {
                    int a = triangle.get(i).get(j) + dp.get(i - 1).get(dp.get(i - 1).size() - 1);
                    dp.get(i).add(a);
                } else {
                    int a = triangle.get(i).get(j);
                    a += Math.min(dp.get(i - 1).get(j), dp.get(i - 1).get(j - 1));
                    dp.get(i).add(a);
                }
                // System.out.println(dp.get(i));
                if (i == triangle.size() - 1)
                    ans = Math.min(ans, dp.get(i).get(j));
            }
        }
        return ans;
    }
}