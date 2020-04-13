import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FnDev {
    public static void main(String[] args) {
        Solution s = new Solution();
        int progresses[] = {93, 30, 55};
        int speeds[] = {1, 30, 5};
        int answer[] = s.solution(progresses, speeds);

        for (int i = 0; i < answer.length; i++)
            System.out.println(answer[i]);
    }

    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            int[] answer;
            ArrayList<Integer> suc = new ArrayList<>();
            int i = 0, sum = 0 ,cnt = 0;

            ArrayList<Integer> pro = new ArrayList<>();
            ArrayList<Integer> spd = new ArrayList<>();


            for( i = 0 ; i< progresses.length ; i++) {
                pro.add(progresses[i]);
                spd.add(speeds[i]);
            }


            while (sum != progresses.length) {

                for (i = 0; i < pro.size(); i++) {
                    pro.set(i, pro.get(i) + spd.get(i));
                }

                while (pro.size() != 0) {

                    int temp = pro.get(0);
                    if (temp >= 100) {
                        cnt++;
                        pro.remove(0);
                        spd.remove(0);
                    }
                    else
                        break;
                }
                if(cnt != 0 ){
                    sum+= cnt;
                    suc.add(cnt);
                    cnt=0;
                }
            }

            answer = new int[suc.size()];

            for (i = 0; i < suc.size(); i++) {
                answer[i] = suc.get(i);
            }

            return answer;
        }
    }

}
