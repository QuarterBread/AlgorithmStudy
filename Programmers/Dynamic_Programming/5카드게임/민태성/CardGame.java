import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CardGame {
    public static void main(String[] args) {
        Solution s = new Solution();
        int left[] = {3, 2, 5};
        int right[] = {2, 4, 1};
        System.out.println(s.solution(left, right));
    }

    static class Solution {
        public int solution(int[] left, int[] right) {
            int answer = 0;
            Queue<Integer> leftDeck = new LinkedList<>();
            Queue<Integer> rightDeck = new LinkedList<>();
            for (int i = 0; i < left.length; i++) {
                leftDeck.add(left[i]);
                rightDeck.add(right[i]);
            }
            while (!rightDeck.isEmpty() && !leftDeck.isEmpty() ) {

                int lPeek = leftDeck.peek();
                int rPeek = rightDeck.peek();

                if (rPeek < lPeek) {
                    answer += rPeek;
                    rightDeck.poll();

                }else
                    leftDeck.poll();

            }


            return answer;
        }
    }
}
