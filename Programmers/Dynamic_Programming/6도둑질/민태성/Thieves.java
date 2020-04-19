import java.util.LinkedList;
import java.util.Queue;

public class Thieves {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] money = {1, 3, 2, 3, 2, 5, 7};
        // 1 , 2, 2
        // 1, 2,5
        // 1,3, 5
        // 3 3 5
        // 3 2 7
        // 3 3 7
        System.out.println(s.solution(money));
    }

    static class Solution {
        int answer = 0;
        int max = 0;

        public int solution(int[] money) {
            int max = 0;
            int arr[] = new int[money.length];
            int firstStart = 0;
            int secondStart = 1;

            int[] memo = new int[money.length];
            boolean visited[] = new boolean[money.length];

            memo[0] = money[0];
            visited[0] = true;


            for (int i = 2; i < money.length; i++) {
                int preIdx = (i + money.length - 1) % money.length;
                int postIdx = (i + money.length + 1) % money.length;

                if (!visited[i] && !visited[preIdx] && !visited[postIdx]) {
                   
                }

            }

            return answer;
        }




    }
}
