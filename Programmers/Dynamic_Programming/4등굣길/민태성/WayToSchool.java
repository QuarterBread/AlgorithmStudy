public class WayToSchool {
    public static void main(String[] args) {
        int puddles[][] = {{2, 2}};
        int p[][] = {{1, 2}, {2, 1}, {2, 3}, {2, 4}, {3, 1}, {3, 3}, {4, 2}};
        Solution s = new Solution();
        int answer = s.solution(4, 3, puddles);
        System.out.println(" === answer ===");
        System.out.println(answer);
    }

    static class Solution {
        public int solution(int m, int n, int[][] puddles) {
            int answer = 0;

            int[][] memo = new int[n + 1][m + 1];
            memo[1][1] = 1;
            for (int i = 0; i < puddles.length; i++) {
                int p = puddles[i][1];
                int q = puddles[i][0];
                memo[p][q] = -1;
            }

            /*
              0 0  0 0 0
              0 1 -1 0 -1
              0 0  0 -1 0
              0 -1 0  0 0

             */
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    System.out.print(memo[i][j] + " ");
                }
                System.out.println("");
            }
            System.out.println("----------");
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (memo[i][j] == -1) {
                        continue;
                    }
                    if (memo[i - 1][j] >= 0 && memo[i][j] >= 0) {
                        memo[i][j] = (memo[i][j] + memo[i - 1][j]) % 1000000007;
                    }
                    if (memo[i][j - 1] >= 0 && memo[i][j] >= 0) {
                        memo[i][j] = (memo[i][j] + memo[i][j - 1]) % 1000000007;
                    }
                }
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    System.out.print(memo[i][j] + " ");
                }
                System.out.println("");
            }

            return memo[n][m] % 1000000007;
        }


    }
}


