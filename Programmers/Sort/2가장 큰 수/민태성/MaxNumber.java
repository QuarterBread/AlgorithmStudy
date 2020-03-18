
import java.util.*;

public class MaxNumber {
    public static void main(String[] args) {
        Solution s = new Solution();
        int arr[] = {3, 30, 34, 5, 9};
        System.out.println(s.solution(arr));
    }

    public static class Solution {
        private static List<String> list = new ArrayList<String>();

        public static String solution(int[] numbers) {
            String answer = "";

            int max;
            String str[] = new String[numbers.length];
            for (int i = 0; i < str.length; i++)
                str[i] = String.valueOf(numbers[i]);

            for (int i = 0; i < str.length - 1; i++) {
                max = Integer.parseInt(str[i]);
                for (int j = i + 1; j < str.length; j++) {
                    if (Integer.parseInt(String.valueOf(str[i].charAt(0))) < Integer.parseInt(String.valueOf(str[j].charAt(0)))) {
                        swap(numbers, i, j);
                    } else if (Integer.parseInt(String.valueOf(str[i].charAt(0))) == Integer.parseInt(String.valueOf(str[j].charAt(0)))) {
                        if (str[i].length() > str[j].length()) {
                                swap(numbers, i, j);
                        } else if (str[i].length() == str[j].length()) {
                            if (numbers[i] < numbers[j])
                                swap(numbers,i,j);
                        }
                    }
                }
            }
            for (int i = 0; i < numbers.length; i++)
                answer += numbers[i];


            return answer;
        }

        public static void swap(int[] numbers, int a, int b) {
            int tmp = numbers[a];
            numbers[a] = numbers[b];
            numbers[b] = tmp;
        }

    }

}
