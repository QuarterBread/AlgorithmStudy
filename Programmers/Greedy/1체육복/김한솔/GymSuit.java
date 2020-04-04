package greedyAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class GymSuit {

	public static void main(String[] args) {
		GymSuitSolution gymSuitSolution = new GymSuitSolution();
		int n = 5;
		int[] lost = { 2, 4 };
		int[] reserve = { 1, 3, 5 };
		System.out.println(gymSuitSolution.solution(n, lost, reserve));

	}
}

class GymSuitSolution {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;		
		List<Integer> lostList = new ArrayList<>();
		List<Integer> reserveList = new ArrayList<>();

		for (int i = 0; i < lost.length; i++) {
			lostList.add(lost[i]);
		}

		for (int i = 0; i < reserve.length; i++) {
			reserveList.add(reserve[i]);
		}
				
		for (int i = 0; i < lostList.size(); i++) {
			for (int j = 0; j < reserveList.size(); j++) {
				if(isMine(lostList.get(i), reserveList.get(j))) { // 체육복을 가져온 학생이 잃어버린 경우					
					lostList.remove(i);
					reserveList.remove(j);
					i--;
					break;
				}
			}
		}
	
		for (int i = 0; i < lostList.size(); i++) {
			for (int j = 0; j < reserveList.size(); j++) {
				if(isBorrow(lostList.get(i), reserveList.get(j))) { // 체육복을 빌릴 수 있는 지 확인					
					lostList.remove(i);
					reserveList.remove(j);
					i--;
					break;
				}
			}
		}

		answer = n-lostList.size();
		return answer;
	}

	public boolean isBorrow(int a, int b) { // 빌릴 수 있는지 여부 판단하는 메소드
		if(a==b-1 || a==b+1) return true;		
		return false;
	}
	
	public boolean isMine(int a, int b) { // 잃어버린 학생 중 여분의 것이 있는 지 확인하는 메소드
		if(a==b) return true;		
		return false;
	}
}
