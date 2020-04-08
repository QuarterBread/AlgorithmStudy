package stackAndQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Printer {

	public static void main(String[] args) {
		PrinterSolution printerSolution = new PrinterSolution();
		int[] priorities = {2, 1, 3 ,2};
		int location = 2;
		System.out.println(printerSolution.solution(priorities, location));

	}

}

class PrinterSolution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        ArrayList<Integer> priorOrder = new ArrayList<>();
        LinkedList<Integer> printOrder = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++) {
        	priorOrder.add(priorities[i]);
        }
        
        Collections.sort(priorOrder, Collections.reverseOrder());
    
        for(int i=0; priorOrder.size()>0; i++) {
        	if(!printOrder.contains(i) && priorities[i] == priorOrder.get(0)) {
        		printOrder.add(i);
        		priorOrder.remove(0);
        		if(i == location) {
        			return printOrder.size();
        		}
        	}
        	
        	if(i == priorities.length-1)
        		i = -1;
        }
        
        return answer;
    }
}
