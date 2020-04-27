class Solution {
    public int solution(int K, int[][] travel) {

        int answer = 0;
        int[][] memo = new int[travel.length][K + 1];

        memo[0][travel[0][0]] = travel[0][1]; // 도보 시간
        memo[0][travel[0][2]] = travel[0][3]; // 자전거 시간

        for (int i = 1; i < travel.length; i++) {
            for (int k = 0; k <= K; k++) {
                if (memo[i - 1][k] == 0) { // 0으로 초기화된 배열에서 0일 때 검사할 필요가 없지 ㅎ
                    continue;
                }

                // 시간을 계속 더한다. 도보가 금액이 크다면
                if (k + travel[i][0] <= K) {
                    memo[i][k + travel[i][0]] = Math.max(memo[i][k + travel[i][0]], memo[i - 1][k] + travel[i][1]);
                    answer = Math.max(answer, memo[i][k + travel[i][0]]);
                }

                // 시간을 계속 더한다. 자전거가 금액이 크다면
                if (k + travel[i][2] <= K) {
                    memo[i][k + travel[i][2]] = Math.max(memo[i][k + travel[i][2]], memo[i - 1][k] + travel[i][3]);
                    answer = Math.max(answer, memo[i][k + travel[i][2]]);
                }
            }
        }

        // System.out.println(answer);
        return answer;
    }
}