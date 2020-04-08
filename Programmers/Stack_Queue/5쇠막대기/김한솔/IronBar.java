package stackAndQueue;

import java.util.ArrayList;
import java.util.Stack;

public class IronBar {

	public static void main(String[] args) {
		
		IronBarSolution ironBarSolution = new IronBarSolution();
		String arrangement = "()(((()())(())()))(())";
		
		System.out.println(ironBarSolution.solution(arrangement));

	}

}

class IronBarSolution {
    public int solution(String arrangement) {
        int answer = 0, raiser = 0, raiserTemp = 0, cnt = 0;
        // ArrayList<Integer> raiserList = new ArrayList<>();
        Stack<Character> arrStack = new Stack<>();
        
        for(int i=0; i<arrangement.length(); i++) {
        	
        	// 1. '(' 가 들어온 경우 스택에 삽입
        	if(arrangement.charAt(i) == '(') {
        		arrStack.add(arrangement.charAt(i));
        		continue;
        	}
        	
        	// 2. ')' 가 들어온 경우
        	// 2-1. 바로 직전 문자가 '('인 경우 -> 레이저
        	if(arrStack.size() > 0 
        			&& arrangement.charAt(i-1) == '(' 
        			&& arrangement.charAt(i) == ')') {
        		arrStack.pop(); // 맨 위에 것 제거
        		answer += arrStack.size(); // 막대 개수 만큼 추가
        		continue;
        	} 

        	// 2-2. 2-1을 제외하고 ')'가 들어온 경우 -> 막대
        	if(arrStack.size() > 0 && arrangement.charAt(i) == ')') {
        		arrStack.pop(); // 맨 위에 것 제거
        		answer += 1;
        	}               
        }
        
        return answer;
    }
}