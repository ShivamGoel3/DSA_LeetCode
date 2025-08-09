class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        while (q.size() > 0) {
            int node = q.peek();
            q.remove();
            count++;
            // System.out.println(node);
            for (Integer i : adj.get(node)) {
                if (indegree[i] > 0) {
                    indegree[i]--;
                    if (indegree[i] == 0)
                        q.add(i);
                }
            }
        }
        if (count == numCourses)
            return true;
        else
            return false;

        // 4 -> 1 -> 3
        // 4 -> 2 -> 3
    }
}