class Solution {
    String call(String ans, List<String> a, int k, int fact, int n) {
        while (n > 0) {
            int index = k / fact;
            // System.out.println(at + " " + index + " " + k + " " + n);
            ans += a.get(index);
            a.remove(index);
            k %= fact;
            n = n - 1;
            if (n > 0)
                fact /= n;
        }
        return ans;
    }

    public String getPermutation(int n, int k) {
        int fact = 1;
        List<String> a = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            a.add(Integer.toString(i));
            fact *= i;
        }
        a.add(Integer.toString(n));
        String ans = "";
        ans = call(ans, a, k - 1, fact, n);
        return ans;
    }
}