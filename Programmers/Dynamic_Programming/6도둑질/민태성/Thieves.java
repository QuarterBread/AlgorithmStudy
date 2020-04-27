import java.util.LinkedList;
import java.util.Queue;

public class Thieves {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] money = {1, 3,1 , 3, 2, 5, 7};
        // 1 , 2, 2
        // 1, 2,5
        // 1,3, 5
        // 3 3 5
        // 3 2 7
        // 3 3 7
        System.out.println(s.solution(money));
    }

    static class Solution {


        public int solution(int[] money) {
            int max = 0;
            int answer = 0;

            int[] memo1 = new int[money.length-1];
            int[] memo2 = new int[money.length];

            memo1[0] = money[0];
            memo1[1] = money[0];

            for (int i = 2; i < money.length-1; i++) {
                memo1[i] = Math.max(memo1[i-2]+ money[i] , memo1[i-1]);
            }

            memo2[0] = 0;
            memo2[1] = money[1];

            for(int i = 2; i < money.length; i++){
                memo2[i] = Math.max(memo2[i-2]+ money[i],memo2[i-1]);
            }

            answer= Math.max((memo1[money.length-2]) , memo2[money.length-1]);


            return answer;
        }




    }
}
