import java.util.*;

public class Baseball {
    private ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

        int r = 3;
        int[][] arr = {{123, 1, 1}, {345, 1, 0}, {327, 2, 0}, {489, 0, 1}};


        Solution s = new Solution();
        System.out.println(s.solution(arr));

    }

    static class Solution {
        public int solution(int[][] baseball) {
            int answer = 0;
            int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            for (int j = 0; j < baseball.length; j++) {
                    int strike = baseball[j][1];
                    int ball = baseball[j][2];
                    int r = strike + ball;
                    Permutation p = new Permutation(arr.length, 3,strike,ball,baseball[j][0]);
                    p.perm(arr, 0);
                    System.out.println("=================================");

            }
            //3개로 만들수 있는 수중에 1 ,2 3, 이 각 2개만 들어가는 경우를 구해야함

            return answer;
        }
    }

    static class Permutation {
        private int n; // nPr의 n
        private int r; // nPr의 r
        private int[] res;
        private int strike;
        private int ball;
        private int q;
        // 초기화
        public Permutation(int n, int r, int strike, int ball,int q) {
            this.n = n;
            this.r = r;
            this.strike= strike;
            this.ball = ball;
            this.q = q;
            res = new int[r];
        }

        public void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        public void perm(int[] arr, int depth) {

            // depth가 0부터 시작했을 경우 depth == r에서 리턴
            if (depth == r) {
                System.out.println(Arrays.toString(res));
                return;
            }

            for (int i = depth; i < n; i++) {
                swap(arr, depth, i);     // 스왑
                res[depth] = arr[depth]; // 선택된 원소 저장
                perm(arr, depth + 1);     // 재귀호출
                swap(arr, depth, i);     // 복원
            }
        }
    }

}
