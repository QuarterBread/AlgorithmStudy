package greedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;

public class IntermittentCamera {
	public static void main(String[] args) {

		IntermittentCameraSolution intermittentCameraSolution = new IntermittentCameraSolution();
		int[][] routes = { { -20, 15 }, { -14, -5 }, { -18, -13 }, { -5, -3 } };
		System.out.println(intermittentCameraSolution.solution(routes));
	}
}

class Route implements Comparable<Route>{
	int start;
	int destination;

	Route(int start, int destination) {
		this.start = start;
		this.destination = destination;
	}

	public int getStart() {
		return this.start;
	}

	public int getDestination() {
		return this.destination;
	}

	@Override
	public int compareTo(Route o) {
		
		if(this.start > o.start) {
			return 1;
		}
		else if(this.start == o.start ) {
			if(this.destination < o.destination) {
				return 1;
			}
		}
		return -1;
	}
}

class IntermittentCameraSolution {
	public int solution(int[][] routes) {
		int answer = 0;
		ArrayList<Route> routeList = new ArrayList<>();
		int x = -30001, y = -30001;
		
		for(int i=0; i<routes.length; i++) {
			routeList.add(new Route(routes[i][0], routes[i][1]));
		}
		
		Collections.sort(routeList);
		
		for(int i=0; i<routeList.size(); i++) {
			if(x<routeList.get(i).start && x<routeList.get(i).destination
				&& y<routeList.get(i).start && y<routeList.get(i).destination) { // 현재까지 단속카메라의 범위를 벗어난 경우 
				x = routeList.get(i).start;
				y = routeList.get(i).destination;
				System.out.println(x+" "+y);
				answer++;
				continue;			
			}
			
			if(x<routeList.get(i).start) {
				x = routeList.get(i).start;
			}
			
			if(y>routeList.get(i).destination) {
				y = routeList.get(i).destination;
			}
		}
		
		return answer;
	}
}