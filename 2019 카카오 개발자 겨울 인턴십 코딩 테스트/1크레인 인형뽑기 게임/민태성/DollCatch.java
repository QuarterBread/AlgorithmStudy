package Kakao2019Winter;

import java.util.ArrayList;

public class DollCatch {
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}};

        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        //분홍 초록 파랑 파랑 초록 노랑 분홍
        //4 3
        System.out.println(new Solution().solution(board, moves));
    }

    static class Solution {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;
            ArrayList<Doll> list = new ArrayList<>();

            for (int i = 0; i < moves.length; i++) {
                int idx = moves[i] - 1;
                System.out.println(idx + "번째 줄에서 인형 뽑음");
                for (int j = 0; j < board.length; j++) {
                    if (board[j][idx] == 0) continue;
                    Doll doll = new Doll(board[j][idx]);
                    list.add(doll);
                    System.out.println("인형 뽁고 바구니ㅣ행  " + doll.value);
                    while (list.size() > 1) {
                        Doll a = list.get(list.size() - 1);
                        Doll b = list.get(list.size() - 2);
                        if (a.value == b.value) {
                            System.out.println(a.value + " , " +b.value);
                            list.remove(a);
                            list.remove(b);
                            answer += 2;
                        } else
                            break;
                    }
                    board[j][idx] = 0;
                    break;
                }

            }

            return answer;
        }

        public class Doll {
            int value;

            public Doll(int value) {
                this.value = value;
            }
        }
    }
}
