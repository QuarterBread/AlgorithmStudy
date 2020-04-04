package greedyAlgorithm;

public class LargeNumber {

	public static void main(String[] args) {
		LargeNumberSolution largeNumberSolution = new LargeNumberSolution();
		String number = "777777";
		int k = 4;
		System.out.println(largeNumberSolution.solution(number, k));

	}
}

class LargeNumberSolution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder stringbuilder = new StringBuilder();
        
        // 1. 총 길이 구하기
        int length = number.length();
        char temp = 0;
        int idx = 0;
        boolean flag = false;

        for(int i=0; i<length && length-i>k; ) {
        	temp = number.charAt(i);
        	if(k>0) {
	        	for(int j=i+1; j<length && j<i+1+k; j++) {
	        		if(temp < number.charAt(j)) { // 큰 수를 찾은 경우
	            		temp = number.charAt(j); 
	            		idx = j; // 해당 인덱스 저장
	            		flag = true;
	            	}
	        	}
	        	if(flag) {
	        		k -= (idx-i); // 해당 인덱스 크기 만큼 제거할 수 있는 k수 삭감
		        	i += (idx-i); // i는 인덱스 크기만큼 이동
		        	flag = false; // flag 초기화
	        	}	        	  
        	} else {
        		stringbuilder.append(number.substring(i, number.length()));
        		break;
        	}        
        	
        	if(!flag) { i++; }
        	stringbuilder.append(temp);
        }
                
//        if(k>0) {
//        	return stringbuilder.substring(0, number.length()-k);
//        }
        
        answer = stringbuilder.toString();
        return answer;
    }
}