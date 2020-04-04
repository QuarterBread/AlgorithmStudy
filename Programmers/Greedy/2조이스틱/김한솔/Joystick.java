package greedyAlgorithm;

import java.util.ArrayList;

public class Joystick {

	public static void main(String[] args) {
		JoystickSolution joystickSolution = new JoystickSolution();
		String name = "JEROEN";
		System.out.println(joystickSolution.solution(name));

	}

}


class JoystickSolution {
    public int solution(String name) {
        int answer = 0;
        int nameSize = name.length();
        int pointer = 0; // 현재위치
        int remainNumber = nameSize; // 바꿔야되는 문자의 갯수
        final int ALPHABET_SIZE = 26;
        ArrayList<Character> nameList = new ArrayList<>();
        boolean[] block = new boolean[nameSize]; // false이면 가지 않아도 되는 곳, true가야 하는 곳
        
        for(int i=0; i<nameSize; i++) {
        	nameList.add('A');
        	if(name.charAt(i) == 'A') {
        		block[i] = false; // 'A'이면 가지 않아도 되므로 false처리
        		remainNumber--; // 'A'이면 바꿀필요가 없으므로 [바꿔야되는 문자의 갯수] 차감
        	}
        	else block[i] = true;
        }
        
        while(true) {
        	
        	// 1. 현재 pointer위치에서 변화가 필요한지 아닌지 판단
        	if(block[pointer]) { // 현재 변화가 필요한 경우
        		answer+=upOrDown(nameList.get(pointer), name.charAt(pointer), answer, ALPHABET_SIZE);
            	block[pointer] = false; // 변화를 마쳤으니 false
            	remainNumber--;
        	}
        	
        	// 2. 바꿔야하는 문자의 개수 확인
        	if(remainNumber == 0) // 바꿀게 없는 경우 while문 탈출
        		break;
        	
        	// 3. 좌우 판단
        	if(leftOrRight(pointer, block, nameSize)) {pointer++;}
        	else {pointer--;}
        	
        	// 3. pointer 유효성 범위 확인
        	if(pointer<0)
        		pointer=nameSize-1;
        	
        	if(pointer==nameSize)
        		pointer=0;        	        	        	
        	
        	answer++;        		        	
        }
        
        return answer;
    }
    
    public int upOrDown(char start, char destination, int answer, int alphabetSize) {  	
    	return destination-start<=13 ? destination-start : alphabetSize-(destination-start);   	
    }
    
    public boolean leftOrRight(int pointer, boolean[] block, int nameSize) { // 좌우 블록 갯수 확인 후 더 적은 쪽으로 방향이동
    	int left=0, right=0;
    	int leftRemain=0, rightRemain=0;
    	
    	// 우측 확인
    	for(int i=pointer; ; i++) {
    		if(block[i]) // true인 벽이 있으면 break;
    			break;
    		right++;    		
    			
    		if(i==nameSize-1)
    			i=-1;
    	}
    	
    	// 좌측 확인
    	for(int j=pointer; ; j--) {
    		if(block[j]) // true인 벽이 있으면 break;
    			break;
    		left++;
    		if(j==0)
    			j=nameSize;
    	}
    	if(left != right)
    		return right<left ? true : false;
    	
    	// 우측에서 바꿔야할 문자 갯수 확인
    	for(int i=pointer+1; ; i++) {    		
    		if(i==nameSize)
    			i=0;
    		rightRemain++;    		
    			    		
    		if(!block[i]) 
    			break;
    	}
    	
    	// 좌측 확인
    	for(int j=pointer-1; ; j--) {    		
    		if(j==-1)
    			j=nameSize-1;
    		
    		leftRemain++;
    		if(!block[j]) 
    			break;    	
    	}
    	
    	return rightRemain<leftRemain ? true : false;
    }       
}