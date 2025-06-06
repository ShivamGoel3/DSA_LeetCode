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
        HashMap<Integer, String[]> mp = new HashMap<>();
        int count = 0;
        List<int[]> adj = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> a = accounts.get(i);
            for (int j = 1; j < a.size(); j++) {
                if (m.containsKey(a.get(j)) == false)
                    m.put(a.get(j), count++);
                if (mp.containsKey(m.get(a.get(j))) == false)
                    mp.put(m.get(a.get(j)), new String[] { a.get(0), a.get(j) });
                for (int k = j + 1; k < a.size(); k++) {
                    // if(parent)
                    if (m.containsKey(a.get(k)) == false)
                        m.put(a.get(k), count++);
                    if (mp.containsKey(m.get(a.get(k))) == false)
                        mp.put(m.get(a.get(k)), new String[] { a.get(0), a.get(k) });
                    adj.add(new int[] { m.get(a.get(j)), m.get(a.get(k)) });
                    adj.add(new int[] { m.get(a.get(k)), m.get(a.get(j)) });
                }
            }
        }
        // System.out.println(m);
        // // System.out.println(mp);
        // for (Integer i : mp.keySet()) {
        //     System.out.println(i + " " + mp.get(i)[0] + " " + mp.get(i)[1]);
        // }
        // for (int i = 0; i < adj.size(); i++)
        // System.out.println(adj.get(i)[0] + " " + adj.get(i)[1]);
        int[] rank = new int[count];
        int[] parent = new int[count];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < adj.size(); i++) {
            union(adj.get(i)[0], adj.get(i)[1], parent, rank);
        }
        HashMap<Integer, List<String>> ml = new HashMap<>();
        for (int i = 0; i < count; i++) {
            // System.out.println(i + " " + parent[i]);
            // if (parent[i] != i)
            //     continue;
            int parents = findparent(parent, i);
            if (ml.containsKey(parents)) {
                ml.get(parents).add(mp.get(i)[1]);
            } else {
                List<String> w = new ArrayList<>();
                ml.put(parents, w);
                ml.get(parents).add(mp.get(i)[1]);
            }
        }
        // for (int i = 0; i < count; i++) {
        //     // System.out.println(i + " " + parent[i]);
        //     // if (parent[i] != i)
        //     //     continue;
        //     int parents = findparent(parent, i);
        //     ml.get(parents).add(mp.get(i)[1]);
        //     // }
        // }
        // System.out.print(ml);
        for (Integer i : ml.keySet()) {
            Collections.sort(ml.get(i));
            List<String> r = new ArrayList<>();
            r.add(mp.get(i)[0]);
            r.addAll(ml.get(i));
            ans.add(r);
        }
        return ans;
    }
}