class Solution {
    HashSet<Integer> dfs(ArrayList<ArrayList<Integer>> adj, int node, int[] visited,
            HashMap<Integer, HashSet<Integer>> m) {
        visited[node] = 1;
        HashSet<Integer> t = new HashSet<>();
        for (Integer i : adj.get(node)) {
            t.add(i);
            if (visited[i] == 1) {
                t.addAll(m.get(i));
                continue;
            }
            t.addAll(dfs(adj, i, visited, m));
        }
        m.put(node, t);
        return t;
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] visited = new int[numCourses];
        HashMap<Integer, HashSet<Integer>> m = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 1)
                continue;
            dfs(adj, i, visited, m);
        }
        // System.out.println(m);
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            if (m.containsKey(a) == false)
                ans.add(false);
            else if (m.get(a).contains(b))
                ans.add(true);
            else
                ans.add(false);
        }
        return ans;
    }
}