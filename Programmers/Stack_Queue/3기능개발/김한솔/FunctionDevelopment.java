package stackAndQueue;

import java.util.ArrayList;

public class FunctionDevelopment {

	public static void main(String[] args) {
		FunctionDevelopmentSolution developmentSolution = new FunctionDevelopmentSolution();
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		developmentSolution.solution(progresses, speeds);
	}

}

class FunctionDevelopmentSolution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int finishIdx = 0; // 작업 마감 인덱스
        int finishCnt = 0; // 배포 가능한 개수
        int idx = 0;
        ArrayList<Integer> finishList = new ArrayList<>();
        
        while(finishIdx < progresses.length) {
        
        	// 1. 작업 진행
        	for(int i=finishIdx; i<progresses.length; i++) {
        		if(progresses[i] < 100) {			
        			progresses[i] += speeds[i];
        		}
        	}
        	        
        	// 2. 배포 가능여부
        	for(int i=finishIdx; i < progresses.length && progresses[i] >= 100; i++) {
        		finishCnt++;
        		finishIdx++;
        	}
        	
        	if(finishCnt > 0) {
        		finishList.add(finishCnt);
        		finishCnt = 0;
        	}

        }        

        answer = new int[finishList.size()];
        for(int i=0; i<answer.length; i++) {
        	answer[i] = finishList.get(i);
        }
        
        return answer;
    }
}