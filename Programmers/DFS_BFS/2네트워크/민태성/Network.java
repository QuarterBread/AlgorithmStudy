public class Network {
    public static void main(String[] args) {
        Solution s = new Solution();
        int arr[][] = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(s.solution(3, arr));
    }

    static class Solution {
        public static int solution(int n, int[][] computers) {
            int answer = 0;
            boolean[] visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs(n, computers, visited, i);
                    answer++;
                }
            }
            return answer;
        }


        public static void dfs(int n, int[][] computers, boolean[] visited, int node) {
            if (!visited[node]) return;
            visited[node] = true;
            for (int i = 0; i < n; i++) {
                if (computers[node][i] == 1) {
                    dfs(n, computers, visited, i);
                }
            }
        }

    }
}

