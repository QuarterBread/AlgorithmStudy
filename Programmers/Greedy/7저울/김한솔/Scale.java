package greedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class Scale {

	public static void main(String[] args) {

		ScaleSolution scaleSolution = new ScaleSolution();
		int[] weight = { 3, 1, 6, 2, 7, 30, 1 };
		System.out.println(scaleSolution.solution(weight));
	}
}

class ScaleSolution {
	public int solution(int[] weight) {
		int answer = 0;
		
		ArrayList<Integer> memory = new ArrayList<>();	
		Arrays.sort(weight);

		if(weight[0] != 1)
			return 1;
		
		memory.add(0); // 무게 추를 단독으로 올려놓는 것을 가정하여 0 삽입
		
		for (int i = 0; i < weight.length; i++) {			
			if(memory.get(memory.size()-1) < weight[i]-1)
				break;
			memory.add(weight[i] + memory.get(memory.size()-1));
		}

		answer = memory.get(memory.size() - 1) + 1;
		return answer;
	}
}
