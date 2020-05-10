import java.util.Comparator;
import java.util.PriorityQueue;

public class NoodleFactory {
    public static void main(String[] args) {
        Solution s = new Solution();
        int stock = 4;
        int[] dates = {4, 10, 15};
        int[] sup = {20, 5, 10};
        int k = 5;
        System.out.println(s.solution(stock, dates, sup, k));
    }

    static class Solution {
        public int solution(int stock, int[] dates, int[] supplies, int k) {
            int answer = 0;
            int idx = 0;
            PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());

            for (int i = 0; i < k; i++) {
                //공급날인지
                if (i == dates[idx] ) {
                    if(idx < dates.length){
                        q.add(supplies[idx]);
                        idx++;
                    }
                }

                if (stock == 0) {
                    stock += q.poll();
                    answer++;
                }
                stock -= 1;


            }

            return answer;
        }
    }
}
