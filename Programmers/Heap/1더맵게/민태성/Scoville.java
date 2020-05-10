import java.util.*;

public class Scoville {
    public static void main(String[] args) {
        Solution s = new Solution();
        int arr[] = {1, 2, 3, 9, 10, 12};
        int arr2[] = {1, 2, 3};

        int K = 11;
        int answer = s.solution(arr2, K);
        System.out.println(answer);
    }

    /*  20
        1 5 7 9 12
        7 9 12 11
        9 12 11

     */
    static class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;

            PriorityQueue<Integer> q = new PriorityQueue<>();
            for (int i = 0; i < scoville.length; i++) {
                if (scoville[i] < K)
                    q.add(scoville[i]);
            }
            //112 k 3
            // 2 3
            if (scoville[0] > K) return 0;
            int first, second;
            while (q.peek() <= K) {
                if(q.size() ==1 ) return -1;
                first = q.poll();
                second = q.poll() * 2;
                int mixScoville = first + second;
                answer++;

                if (mixScoville == first) return -1;
                q.add(mixScoville);
            }
            return answer;
        }

    }
}
