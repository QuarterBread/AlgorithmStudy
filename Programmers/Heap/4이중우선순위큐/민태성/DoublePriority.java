import java.util.Comparator;
import java.util.PriorityQueue;

public class DoublePriority {
    public static void main(String[] args) {

        Solution s = new Solution();
        String[] oper = {"I 16", "I 5", "I 1", "D -1", "D 1", "D 1"};
        String[] a = {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"};
        int answer[] = s.solution(a);
        for (int i = 0; i < answer.length; i++)
            System.out.print(answer[i] + " ");
    }

    static class Solution {
        public int[] solution(String[] operations) {
            int[] answer = {0, 0};
            PriorityQueue<Integer> qMin = new PriorityQueue<>();
            PriorityQueue<Integer> qMax = new PriorityQueue<>(Comparator.reverseOrder());

            /*
                1 5 16
                16 5 1

             */
            for (int i = 0; i < operations.length; i++) {
                String[] op = operations[i].split(" ");
                if (op[0].equals("I") ) {
                    int insertValue = Integer.parseInt(op[1]);
                    qMin.add(insertValue);
                    qMax.add(insertValue);
                } else {
                    //min Delete

                    if (Integer.parseInt(op[1]) < 0 && !qMin.isEmpty()) {
                        int min = qMin.poll();
                        qMax.remove(min);

                    }
                    //max Delete
                    else if (!qMax.isEmpty()) {
                        int max = qMax.poll();
                        qMin.remove(max);
                    }
                }
            }
            if (qMin.isEmpty()) {
                return answer;
            } else {
                answer = new int[]{qMax.poll(), qMin.poll()};
                return answer;
            }
        }
    }
}
