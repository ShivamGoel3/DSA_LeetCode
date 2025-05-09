class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<List<String>> dp = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            List<String> a = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j]) {
                    if (a.size() < dp.get(j).size())
                        a = new ArrayList<>(dp.get(j));
                }
            }
            a.add(words[i]);
            dp.add(a);
            if (a.size() > ans.size())
                ans = a;
        }
        return ans;
    }
}