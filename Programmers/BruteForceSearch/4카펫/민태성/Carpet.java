import java.util.ArrayList;

public class Carpet {
    public static void main(String[] args) {
        Solution s = new Solution();
        int answer[] = s.solution(5000 , 4);
        for (int i = 0; i < answer.length; i++)
            System.out.println(answer[i]);
    }

    static class Solution {
        public int[] solution(int brown, int red) {
            int[] answer = new int[2];
            if (isPrime(red)) {
                answer[0] = red + 2;
                answer[1] =  (brown + red) /answer[0] + brown;
                return answer;
            } else {
                int sum = brown + red;
                if (isSquare(sum)) {
                    answer[0] = (int) Math.sqrt((double) sum);
                    answer[1] = (int) Math.sqrt((double) sum);
                    return answer;
                }

                int i = 4;
                int min = sum;
                while (i != sum) {
                    if (sum % i == 0) {
                        int a = sum / i;
                        int b = i;

                        if (a > b && b >= 4 && a - b < min) {
                            min = a - b;
                            answer[0] = a;
                            answer[1] = b;
                        }
                    }
                    i++;
                }
                return answer;
            }
        }

        public boolean isSquare(long n) {
            if (n < 0) return false;

            long tmp = (long) (Math.sqrt(n) + 0.5);
            return tmp * tmp == n;
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
    }
}
