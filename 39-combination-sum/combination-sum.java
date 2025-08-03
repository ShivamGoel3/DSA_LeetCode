class Solution {
    void call(int[] candidates, int target, List<List<Integer>> ans,
            List<Integer> t, int sum, int index) {
        if (sum >= target || index == candidates.length) {
            if (sum == target)
                ans.add(new ArrayList<>(t));
            return;
        }
        // for (int i = index; i < candidates.length; i++) {
        call(candidates, target, ans, t, sum, index + 1);
        t.add(candidates[index]);
        call(candidates, target, ans, t, sum + candidates[index], index);
        t.remove(t.size() - 1);
        // }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        call(candidates, target, ans, t, 0, 0);
        return ans;
    }
}