import java.util.Stack;

public class IronStick {
    public static void main(String[] args) {
        String str = "()(((()())(())()))(())";
        Solution s = new Solution();
        System.out.println(s.solution(str));
    }

    static class Solution {
        public int solution(String arrangement) {
            int answer = 0;
            Stack<Character> stack = new Stack<>();
   
            for (int i = 0; i < arrangement.length(); i++) {
                char c = arrangement.charAt(i);
                //stick
                if (c == '(') {
                    stack.push(c);
                }
                else {
                    //laser
                    if (!stack.isEmpty() && stack.peek() == '('&& arrangement.charAt(i-1) != ')' ) {
                        stack.pop();
                        answer += stack.size();
                    }//stick -1
                    else {
                        
                            answer ++;
                            stack.pop();
                        
                    }
                }

            }


            return answer;
        }
    }
}
