package greedyAlgorithm;

import java.util.Arrays;

public class Lifeboat {

	public static void main(String[] args) {
		LifeboatSolution lifeboatSolution = new LifeboatSolution();
		int[] people = { 40,40,40 };
		int limit = 100;
		System.out.println(lifeboatSolution.solution(people, limit));
	}
}

class LifeboatSolution {
	public int solution(int[] people, int limit) {
		int answer = 0;		
		int head, tail;
        boolean flag = false;
        
        Arrays.sort(people);
		
		head = 0;
		tail = people.length-1;
		for(int i=tail; i>=0; i--) {			
			if(people[i] + people[head] <= limit) {
				tail = i;
                flag = true;
				break;
			}
			answer++;
		}		
		
        if(flag) {
            while(head<=tail) {
                if(head == tail) {
                    answer++; break;
                }
                if(people[head] + people[tail] <= limit) {				
                    answer++;
                    head++;			
                } else { answer++;}	
                tail--;			
            }
        }
		
		return answer;
	}

}