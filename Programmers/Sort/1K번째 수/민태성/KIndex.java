import java.util.Arrays;

public class KIndex {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int commands[][] = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int answer[] = Solution.solution(array, commands);

        for (int i = 0; i < answer.length; i++)
            System.out.print(answer[i] + " ");
    }

    public static class Solution {

        public static int[] solution(int[] array, int[][] commands) {
            int[] answer = {};
            answer = new int[commands.length];
            for (int i = 0; i < commands.length; i++) {
                int len = commands[i][1] - commands[i][0] + 1;
                int arrStartP = commands[i][0] - 1;
                int tmp[] = new int[len];
                System.arraycopy(array, arrStartP, tmp, 0, len);
                Arrays.sort(tmp);
                answer[i] = tmp[commands[i][2]-1];
            }

            return answer;
        }
    }
}
