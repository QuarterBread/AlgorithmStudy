public class StockPrice {
    public static void main(String[] args) {
        Solution s = new Solution();
        int prices[] = {1, 2, 3, 2, 3};
        int answer[] = s.solution(prices);
        for (int i = 0; i < answer.length; i++)
            System.out.println(answer[i]);
    }

    static class Solution {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];

            for (int i = 0; i < answer.length; i++) {
                int cnt = 0;

                for (int j = i + 1; j < answer.length; j++) {
                    cnt++;
                    if (prices[i] > prices[j]) {
                        break;
                    }
                }

                answer[i] = cnt;
            }
            return answer;
        }
    }
}
