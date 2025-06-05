class Solution {
    void call(int n, String s , List<String>ans,int open, int close){
        if(close>open)
        return;
        if(open>n || close>n)
        return;
        if(open ==n && close==n){
            ans.add(s);
            return;
        }
        call(n,s+"(",ans,open+1,close);
        call(n,s+")",ans,open,close+1);
    }
    public List<String> generateParenthesis(int n) {
        List<String>ans = new ArrayList<>();
        int open = 0;int close = 0;
        call(n,"", ans,open,close);
        return ans;
    }
}