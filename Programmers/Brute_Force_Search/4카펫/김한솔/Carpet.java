package bruteforce;

public class Carpet {

	public static void main(String[] args) {
		
		int brown = 24;
		int red = 24;
		
		CarpetSolution carpetSolution = new CarpetSolution();
		carpetSolution.solution(brown, red);

	}

}

class CarpetSolution {
    public int[] solution(int brown, int red) {
        int[] answer = {};
        int x, y;
        
        // 1. red의 모형을 찾아라 -> red모형이 (x, y)인 경우 카펫 크기는 (x+2, y+2)가 된다
        // 2. 주어진 brown개수를 통해 red모형을 찾아라 -> red모형이 (x, y)인 경우 brown 개수는 2x+2y+4가 된다
        // 조건) 1 < x*y < 2,000,000
        // 3. red모형은 사각형이므로 x*y형으로 딱 떨어져야함.
        
        for(int i=red; i>=(red/i); i--) {
        	if(red%i!=0) // 딱 떨어지지 않는 경우
        		continue;
        	
        	x = i;
        	y = red/x;
        	if(2*x+2*y+4 == brown) {
        		answer = new int[2];
        		answer[0] = x+2;
        		answer[1] = y+2;
        		break;
        	}
        		
        }
        
        System.out.println(answer[0] + ", " + answer[1]);
        return answer;
    }
}