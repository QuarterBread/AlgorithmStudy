package stackAndQueue;

public class StockPrice {

	public static void main(String[] args) {
		StockPriceSolution priceSolution = new StockPriceSolution();
		int[] prices = { 1, 2, 3, 2, 3 };
		priceSolution.solution(prices);

	}

}

class StockPriceSolution {
	public int[] solution(int[] prices) {
		int[] answer = {};
		int time;
		
		answer = new int[prices.length];
		
		for(int i=0; i<prices.length; i++) {
			
			time = 0;
			for(int j=i+1; j<prices.length; j++) {
				time++;
				if(prices[i] > prices[j]) {
					answer[i] = time;
					break;
				}								
			}						
			answer[i] = time;			
		}
				
		return answer;
	}
}
