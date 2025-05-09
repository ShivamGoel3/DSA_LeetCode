class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<List<String>> dp = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            int index = 0;
            int size = 0;
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j]) {
                    if (size < dp.get(j).size()) {
                        size = dp.get(j).size();
                        index = j;
                    }
                }
            }
            // a.add(words[i]);
            if (size != 0) {
                List<String> a = new ArrayList<>(dp.get(index));
                a.add(words[i]);
                dp.add(a);
            } else {
                List<String> a = new ArrayList<>();
                a.add(words[i]);
                dp.add(a);
            }
            if (dp.get(i).size() > ans.size())
                ans = dp.get(i);
        }
        return ans;
    }
}