import java.time.Year;
import java.util.*;

public class Printer {
    public static void main(String[] args) {

        int pritor[] = {3, 3, 4, 2};
        int location = 3;
        System.out.println(new Solution().solution(pritor, location));
    }

    static class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 0;
            char c = (char) (location + 65);

            Queue<Priority> q = new LinkedList<>();

            ArrayList<Integer> keyList = new ArrayList<>();

            Priority[] pList = new Priority[priorities.length];


            for (int i = 0; i < priorities.length; i++) {
                keyList.add(priorities[i]);
                pList[i] = new Priority(priorities[i], (char) (i + 65));
                q.add(pList[i]);
            }

            int cnt = 0;
            while (true) {
                Priority first = q.poll();
                System.out.println(first.p + " , " + first.value);
                keyList.remove(0);
                if(keyList.size()==0){
                    return cnt+1;
                }

                if (first.p < Collections.max(keyList)) {
                    q.add(first);
                    keyList.add(first.p);
                } else {
                    cnt++;
                    if (first.value == c)
                        return cnt;

                }
            }


        }

        class Priority {
            private int p;
            private char value;

            public Priority(int p, char value) {
                this.p = p;
                this.value = value;
            }

        }
    }


}
