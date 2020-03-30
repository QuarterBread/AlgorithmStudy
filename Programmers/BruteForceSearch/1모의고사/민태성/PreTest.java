
import java.util.ArrayList;


public class PreTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        int[] arr2 = {1, 3, 2, 4, 2};

        Solution s = new Solution();
        int a[] = s.solution(arr);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    static class Solution {
        public int[] solution(int[] answers) {
            int[] answer;
            int[] t1 = {1, 2, 3, 4, 5};
            int[] t2 = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] t3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};


            int len1 = t1.length;
            int len2 = t2.length;
            int len3 = t3.length;
            int lenA = answers.length;

            int[] cntArr = new int[3];
            for (int i = 0; i < lenA; i++) {
                if (answers[i] == t1[i % len1])
                    cntArr[0]++;
                if (answers[i] == t2[i % len2])
                    cntArr[1]++;
                if (answers[i] == t3[i % len3])
                    cntArr[2]++;

            }
            int max = cntArr[0];
            for (int i = 0; i < 3; i++) {
                if (max < cntArr[i]) {
                    max = cntArr[i];
                }
            }
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0 ; i < 3 ; i++){
                if(max == cntArr[i])
                    list.add(i+1);
            }
            answer = new int[list.size()];

            for(int i= 0 ; i<answer.length;i++){
                answer[i] = list.get(i);
            }

            return answer;
        }
    }
}
