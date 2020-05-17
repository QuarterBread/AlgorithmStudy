package Kakao2019Winter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Tuple {
    public static void main(String[] args) {
        String str = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String str1 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        Solution s = new Solution();
        int[] answer = s.solution(str1);
        for (int i = 0; i < answer.length; i++)
            System.out.print(answer[i] + " ");
    }


    static class Solution {
        public int[] solution(String s) {
            int[] answer;
            HashMap<String, Integer> map = new HashMap<>();
            ArrayList<String> list = new ArrayList<>();
            ArrayList<String> t = new ArrayList<>();

            String words = s.replace("},{", ";");
            words = words.replace("{", "");
            words = words.replace("}", "");

            System.out.println(words);
            String temp[] = words.split(";");
            Arrays.sort(temp, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.length() > o2.length())
                        return 1;
                    else
                        return -1;
                }
            });

            for (int i = 0; i < temp.length; i++) {
                System.out.println(temp[i]);
                String[] word = temp[i].split(",");
                for (int j = 0; j < word.length; j++)
                    if (!t.contains(word[j])) {
                        t.add(word[j]);
                    }
            }
            answer = new int[t.size()];
            for (int i = 0; i < t.size(); i++)
                answer[i] = Integer.parseInt(t.get(i));

            return answer;
        }
    }
}
