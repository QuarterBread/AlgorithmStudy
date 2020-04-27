
public class Triangle {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] arr = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(s.solution(arr));
    }

    static class Solution {
        public int solution(int[][] triangle) {
            int answer = 0;
            int memo[][] = new int[triangle.length][];

            for (int i = 0; i < triangle.length; i++) {
                memo[i] = new int[triangle[i].length];
                System.arraycopy(triangle[i], 0,memo[i],0,triangle[i].length);
            }

            memo[1][0] = triangle[0][0] + triangle[1][0];
            memo[1][1] = triangle[0][0] + triangle[1][1];
     /*
        i=0               0,0                            7                    7
        i=1           1,0     1,1                       3 8                 10 15
        i=2       2,0,    2,1    2,2                   8 1 0               18 11 15
        i=3    3,0    3,1    3,2    3,3               2 7 4 4
         */

            for (int i = 1; i < triangle.length-1; i++) { //i= 높이
                for (int j = 0; j < triangle[i].length; j++) {
                    for (int k = j; k < j + 2; k++) {
                        if (memo[i + 1][k] < triangle[i + 1][k] + memo[i][j])
                            memo[i + 1][k] = triangle[i + 1][k] + memo[i][j];
                    }
                }
            }

            int max = 0;
            for(int i = 0 ; i < memo[memo.length-1].length ; i++){
                if(max < memo[memo.length-1][i])
                    max = memo[memo.length-1][i];
            }
            return max;
        }
    }
}
