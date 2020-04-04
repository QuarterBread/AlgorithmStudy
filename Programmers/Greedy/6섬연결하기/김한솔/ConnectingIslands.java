package greedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;

public class ConnectingIslands {

	public static void main(String[] args) {
		ConnectingIslandsSolution connectingIslandsSolution = new ConnectingIslandsSolution();
		int[][] costs = { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } };
		int n = 4;
		System.out.println(connectingIslandsSolution.solution(n, costs));

	}

}

class Island implements Comparable<Island> {
	private int x;
	private int y;
	private int cost;
	
	public Island(int x, int y, int cost) {
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getCost() {
		return cost;
	}

	@Override
	public int compareTo(Island o) {
		if(this.cost > o.cost) {
			return 1;
		}
		else if(this.cost == o.cost) {
			if(this.x > o.x) {return 1;}
			else if(this.x == o.x) {
				if(this.y > o.y) {return 1;}
			}
		}
		return -1;
	}
}

class ConnectingIslandsSolution {
	public int solution(int n, int[][] costs) {
		int answer = 0;
		ArrayList<Island> isLands = new ArrayList<>();
		int parent[] = new int[n];
		
		for(int i=0; i<n; i++) {
			parent[i] = i;
		}

		for(int i=0; i<costs.length; i++) {
			isLands.add(new Island(costs[i][0], costs[i][1], costs[i][2]));
		}
		
		Collections.sort(isLands);
		
		for(int i=0; i<isLands.size(); i++) {
			if(!isCycle(parent, isLands.get(i).getX(), isLands.get(i).getY())) {
				unionParent(parent, isLands.get(i).getX(), isLands.get(i).getY());
				answer += isLands.get(i).getCost();
			}
				
		}

		return answer;
	}
	
	public int getParent(int[] parent, int x) { // 그래프의 부모 노드 확인
		if(parent[x] == x) return x;
		return getParent(parent, parent[x]);
	}
	
	public void unionParent(int[] parent, int x, int y) { // 그래프 연결 메소드
		x = getParent(parent, x);
		y = getParent(parent, y);
		if(x<y) 
			parent[y] = x;
		else
			parent[x] = y;
	}
	
	public boolean isCycle(int[] parent, int x, int y) { // 사이클을 형성하는지 확인
		x = getParent(parent, x);
		y = getParent(parent, y);
		if(x == y) return true;
		else return false;
	}

}