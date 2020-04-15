package bruteforce;

import java.util.ArrayList;
import java.util.Arrays;

public class MockTest {
	public static void main(String[] args) {
		MockTestSolution mSolution = new MockTestSolution();
		
		int [] answers = {1, 3, 2, 4, 2};
		mSolution.solution(answers);
	}
}

class MockTestSolution {
	public int[] solution(int[] answers) {

		int[] answer = {};
		int[] student1 = { 1, 2, 3, 4, 5 }; // 1번 수포자
		int[] student2 = { 2, 1, 2, 3, 2, 4, 2, 5 }; // 2번 수포자
		int[] student3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }; // 3번 수포자
		int[] answerCount = { 0, 0, 0 }; // 정답 갯수
		ArrayList<Integer> answerList = new ArrayList<>();

		for (int i = 0; i < answers.length; i++) {			
			if(answers[i] == student1[i%student1.length]) // 1번 수포자와 정답 비교
				answerCount[0] += 1;
			if(answers[i] == student2[i%student2.length]) // 2번 수포자와 정답 비교
				answerCount[1] += 1;
			if(answers[i] == student3[i%student3.length]) // 3번 수포자와 정답 비교
				answerCount[2] += 1;
		}
		
		int[] tempCount = new int[3];
		for(int i=0; i<answerCount.length; i++) {
			tempCount[i] = answerCount[i];
		}
		
		Arrays.sort(answerCount);
		int temp = answerCount[answerCount.length-1]; // 가장 많이 맞춘 정답 갯수 확인
		
		for(int i=0; i<tempCount.length; i++) {
			if(temp == tempCount[i])
				answerList.add(i+1);
		}
		
		answer = new int[answerList.size()];
		
		for(int i=0; i<answer.length; i++) {
			answer[i] = answerList.get(i);
			System.out.println(answer[i]);
		}
		return answer;
	}
}
