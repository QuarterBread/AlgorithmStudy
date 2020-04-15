import java.util.*;

public class FindPrimeNo {
    public static void main(String[] args) {
        System.out.println("answer =" + new Solution().solution("011"));
    }

    static class Solution {
        HashSet<Integer> set = new HashSet<>();

        public int solution(String numbers) {
            int answer = 0;
            Permutation p[] = new Permutation[numbers.length()];
            int[] temp = new int[numbers.length()];

            String numbersArr[] = new String[numbers.length()];
            for (int i = 0; i < numbersArr.length; i++) {
                temp[i] = Integer.parseInt(numbers.substring(i, i + 1));
            }


            for (int i = 0; i < numbers.length(); i++) {
                p[i] = new Permutation(temp.length, i + 1);
                p[i].perm(temp, 0);
            }
            answer = set.size();
            return answer;
        }

        class Permutation {

            private int n; // nPr의 n
            private int r; // nPr의 r
            private int[] res;

            // 초기화
            public Permutation(int n, int r) {
                this.n = n;
                this.r = r;
                res = new int[r];
            }

            public void swap(int[] arr, int i, int j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

            public boolean isPrime(int n) {
                int i = 2;
                if (n >= 2) {
                    while (true) {
                        if (i <= Math.sqrt((double) n)) {
                            if (n % i == 0)
                                return false;
                            else
                                i++;
                        } else {
                            return true;
                        }
                    }
                } else return false;

            }

            public void perm(int[] arr, int depth) {
                String str = "";
                // depth가 0부터 시작했을 경우 depth == r에서 리턴
                if (depth == r) {
                    if (res.length > 1) {
                        for (int i = 0; i < res.length; i++) { 
                            str += res[i];
                        }
                        System.out.println("str = " + str);
                        if (isPrime(Integer.parseInt(str))) {
                            set.add(Integer.parseInt(str));
                        }
                    } else {
                        if (isPrime(res[0])) {
                            set.add(res[0]);
                        }
                    }

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


}
