import java.util.Scanner;

public class TargetNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Solution s = new Solution();
        int arr[] = {1, 1,1,1,1};
        //                        1
        //             +1                    -1
        //      +1         -1          +1          -1
        //  +1    -1     +1   -1    +1    -1      +1    -1


        System.out.println(s.solution(arr, 3));
    }

    static class Solution {

        public int solution(int[] numbers, int num) {
            int answer = 0;
            answer= dfs(numbers,0,num,0);

            return answer;
        }

        public  int dfs(int []numbers,  int sum, int num , int idx){

            if(idx == numbers.length){
                if(sum == num)
                    return 1;
                else
                    return 0;
            }
            else{
                int plus = dfs(numbers,sum+numbers[idx],num,idx+1 );
                int minus = dfs(numbers,sum-numbers[idx],num,idx+1);
                return plus + minus;
            }
        }
    }
}
