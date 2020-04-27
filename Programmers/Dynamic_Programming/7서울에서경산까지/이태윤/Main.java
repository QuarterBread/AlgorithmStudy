import java.util.*;

public class Main {

    // test case
    static int K = 1650;
    static int[][] travel = {{500, 200, 200, 100}, {800, 370, 300, 120}, {700, 250, 300, 90}};
//    static int K = 100;
//    static int[][] travel = {{1, 1, 1, 1}, {99, 1000, 1, 1}, {1, 1, 1, 1}};

    // algorithm solution
    static class Solution {
        static int[] fund;
        static int[] time;
        static int answer;
        public int solution(int K, int[][] travel) {
            answer = 0;
//            fund = new int[travel.length][];
//            time = new int[travel.length][];
            fund = new int[(int)(Math.pow(2, travel.length+1))];
            time = new int[(int)(Math.pow(2, travel.length+1))];

//            fund[0] = new int[2];
//            time[0] = new int[2];
//            time[0][0] = travel[0][0];
//            fund[0][0] = travel[0][1];
//            time[0][1] = travel[0][2];
//            fund[0][1] = travel[0][3];
//
//            // i = depth
//            for(int i=1; i<travel.length; i++){
//                fund[i] = new int[(int)Math.pow(2,i+1)];
//                time[i] = new int[(int)Math.pow(2,i+1)];
//                for(int j=0; j<Math.pow(2,i+1); j++){
//                    if(time[i-1][j/2] > K)
//                        continue;
//                    // 현재 = 상위 인덱스 + 경로
//                    time[i][j] = (time[i - 1][j / 2] + travel[i][0]);
//                    fund[i][j] = (fund[i - 1][j / 2] + travel[i][1]);
//                    if(time[i][j] > K)
//                        fund[i][j] = -100000000;
//                    j++;
//                    if(time[i-1][j/2] > K)
//                        continue;
//                    time[i][j] = (time[i - 1][j / 2] + travel[i][2]);
//                    fund[i][j] = (fund[i - 1][j / 2] + travel[i][3]);
//                    if(time[i][j] > K)
//                        fund[i][j] = -100000000;
//                }
//            }
//            for(int i=0; i<fund[travel.length-1].length; i++){
//                if(answer < fund[travel.length-1][i])
//                    answer = fund[travel.length-1][i];
//            }
            dp(0, travel, K, 1);
            return answer;
        }

        public void dp(int depth, int[][] travel, int K, int i){
            if(depth > travel.length || i == fund.length)
                return;
            if(time[i/2] >= K)
                return;
            if(i!=1) {
                if (i % 2 == 0) {
                    time[i] = time[i / 2] + travel[depth-1][0];
                    fund[i] = fund[i / 2] + travel[depth-1][1];
                } else {
                    time[i] = time[i / 2] + travel[depth-1][2];
                    fund[i] = fund[i / 2] + travel[depth-1][3];
                }
                if (time[i] > K) {
                    fund[i] = -1;
                    return;
                }
            }
            if(i >= (int)Math.pow(2, travel.length) && answer < fund[i])
                answer = fund[i];
            //System.out.println("i : " + i + ", fund : " + fund[i] + ", " + "time : " + time[i] + ", depth : " + depth);
            dp(depth+1, travel, K, (i*2)); //left
            dp(depth+1, travel, K, (i*2)+1); //right
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(K, travel);
        System.out.println(answer);
    }
}