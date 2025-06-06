class Solution {
    int findparent(int[] parent, int ele) {
        if (parent[ele] == ele)
            return ele;
        return findparent(parent, parent[ele]);
    }

    void union(int x, int y, int[] parent, int[] rank) {
        int parentx = findparent(parent, x);
        int parenty = findparent(parent, y);
        if (rank[parentx] >= rank[parenty]) {
            parent[parenty] = parentx;
            if (rank[parentx] == rank[parenty])
                rank[parentx]++;
        } else {
            parent[parentx] = parenty;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, Integer> m = new HashMap<>();
        int count = accounts.size();
        // List<int[]> adj = new ArrayList<>();
        int[] rank = new int[count];
        int[] parent = new int[count];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < accounts.size(); i++) {
            List<String> a = accounts.get(i);
            for (int j = 1; j < a.size(); j++) {
                if (m.containsKey(a.get(j)) == false)
                    m.put(a.get(j), i);
                else {
                    // adj.add(new int[] { , i });
                    // adj.add(new int[] { i, m.get(a.get(j)) });
                    union(m.get(a.get(j)), i, parent, rank);
                    union(i, m.get(a.get(j)), parent, rank);
                }
            }
        }
        // for (int i = 0; i < adj.size(); i++)
        //     System.out.println(adj.get(i)[0] + " " + adj.get(i)[1]);

        HashMap<Integer, TreeSet<String>> ml = new HashMap<>();
        for (int i = 0; i < count; i++) {
            int parents = findparent(parent, i);
            List<String> k = new ArrayList<>();
            k.addAll(accounts.get(i));
            k.remove(0);
            if (ml.containsKey(parents)) {
                ml.get(parents).addAll(k);
            } else {
                TreeSet<String> w = new TreeSet<>();
                ml.put(parents, w);
                ml.get(parents).addAll(k);
            }
        }
        // System.out.print(ml);
        for (Integer i : ml.keySet()) {
            List<String> r = new ArrayList<>();
            r.add(accounts.get(i).get(0));
            r.addAll(ml.get(i));
            ans.add(r);
        }
        return ans;
    }
}