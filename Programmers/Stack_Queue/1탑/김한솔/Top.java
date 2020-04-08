package stackAndQueue;

public class Top {

	public static void main(String[] args) {
		TopSolution topSolution = new TopSolution();
		int[] heights = { 7, 6, 5, 4, 3, 2, 1 };
		topSolution.solution(heights);
	}

}

class TopSolution {
	public int[] solution(int[] heights) {
		int[] answer = {};
		answer = new int[heights.length];

		for(int i=1; i<heights.length; i++) {
			for(int j=i; j>=0; j--) {
				if(heights[i] < heights[j]) {
					answer[i] = j+1;
					break;
				}
			}
		}
		
		for(int i=0; i<answer.length; i++) {
			System.out.print(answer[i]+" ");
		}
		
		return answer;
	}
}