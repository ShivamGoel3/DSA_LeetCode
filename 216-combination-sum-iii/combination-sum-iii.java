class Solution {
    void call(List<Integer> p, List<List<Integer>> ans, int index, int k, int n) {
        if (n < 0)
            return;
        if (p.size() > k)
            return;
        if (n == 0) {
            // System.out.println(p);
            if (p.size() == k)
                ans.add(new ArrayList<>(p));
            return;
        }
        for (int j = index; j <= 9; j++) {
            p.add(j);
            call(p, ans, j + 1, k, n - j);
            p.remove(p.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> p = new ArrayList<>();
        call(p, ans, 1, k, n);
        return ans;
    }
}