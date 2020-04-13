public class Top {
    public static void main(String[] args) {
        Solution s = new Solution();
        int h[] = {3, 9, 9, 3, 5, 7, 2};
        int answer[] = s.solution(h);
        for(int i = 0 ; i < answer.length; i++)
            System.out.println(answer[i]);
    }

    static class Solution {
        public int[] solution(int[] heights) {
            int[] answer = new int[heights.length];
            for (int i = heights.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (heights[i] < heights[j])
                        answer[i] = j + 1;
                }
            }
            return answer;
        }
    }
}
