package bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class BaseballGame {

	public static void main(String[] args) {
		int[][] baseball = { { 123, 1, 1 }, { 356, 1, 0 }, { 327, 2, 0 }, { 489, 0, 1 }};
		
		BaseballGameSolution baseballGameSolution = new BaseballGameSolution();
		baseballGameSolution.solution(baseball);
	}

}

class BaseballGameSolution {
	public int solution(int[][] baseball) {
		int answer = 0;
		final int START = 123, FINISH = 987, SIZE = 3;
		int nArr[] = new int[SIZE];
		ArrayList<Integer> banNumberList = new ArrayList<>();
		
		Arrays.sort(baseball, new Comparator<int[]>() { // s, b기준으로 오름차순 정렬(out이 있는 지 확인하기 위함)

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1])
					return Integer.compare(o1[2], o2[2]);
				else return Integer.compare(o1[1], o2[1]);
			}
		});
		
		banNumberList.add(0);
		
		for(int i=0; i<baseball.length; i++) {
			if(baseball[i][1] != 0 || baseball[i][2] != 0) // out이 아닌 경우
				break;		
			decomposition2(banNumberList, baseball[i][0]);
		}	
		
		for(int i=START; i<=FINISH; i++) {
						
			decomposition1(nArr, i);
			
			if(banNumberList.contains(nArr[0]) ||  // 유효성 검증 1) 제외된 숫자인 경우
				banNumberList.contains(nArr[1]) || 
				banNumberList.contains(nArr[2]))
				continue;
			
			if(nArr[0] == nArr[1] || nArr[0] == nArr[2] || nArr[1] == nArr[2]) // 유효성 검증 2) 숫자가 겹치는 경우
				continue;					
			
			if(checkNumber(baseball, nArr, SIZE))
				answer++;
		}
		
		System.out.println(answer);
		return answer;
	}

	private boolean checkNumber(int[][] baseball, int[] n, int size) {
		
		int strike, ball;		
		
		for(int i=0; i<baseball.length; i++) {
			
			strike = 0; ball = 0;
			int bArr[] = new int[size];
			
			decomposition1(bArr, baseball[i][0]);				
			
			for(int j=0; j<size; j++) {
				for(int k=0; k<size; k++) {
					if(n[j] == bArr[k]) { // 해당 숫자가 포함되어 있는 경우
						if(j == k) {strike++;} // 자리까지 같은 경우
						else { ball++;} // 자리는 다른 경우						
					}						
				}
			}
			
			if(baseball[i][1] != strike || baseball[i][2] != ball)
				return false;
			
		}
		
		return true;
	}
	
	public void decomposition1(int arr[], int number) { // 3자리 수를 쪼개어 배열에 각각 저장
		int value = number;
		
		arr[0] = value/100;
		arr[2] = value%10;
		value /= 10;
		arr[1] = value%10;							
	}
	
	public void decomposition2(ArrayList<Integer> list, int number) { // 3자리 수를 쪼개어 배열에 각각 저장
		int value = number;
		
		list.add(value/100);
		list.add(value%10);
		value /= 10;
		list.add(value%10);						
	}
}
