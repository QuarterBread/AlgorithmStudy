// 문제 풀면서 느낀점 : 이 문제는 로직이 간단한데에 비해 시간이 오래걸렸다..
// 이유 1 : 자료구조 선택에 애를 먹었다. 결국엔 클래스 처리
// 이유 2 : null처리를 제대로 못했음.
// 이유 3 : Java String 비교할때 equals가 기본인데 == 연산자를 사용해서 테스트 통과하는데 애를 먹음(이클립스에서는 잘 도는데 프로그래머스에서 잘 안돌았음..)

package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class TravelRoute {

	public static void main(String[] args) {
		// String[][] tickets = { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" }};
		String[][] tickets = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" }, { "ATL", "SFO" }};
		
		TravelRouteSolution tSolution = new TravelRouteSolution();
		tSolution.solution(tickets);

	}
}

class Flight {

	private String endPoint;
	private boolean checked;

	public Flight(String endPoint) {
		this.endPoint = endPoint;
		this.checked = false;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}

class TravelRouteSolution {
	public String[] solution(String[][] tickets) {
		String[] answer = {};
		HashMap<String, ArrayList<Flight>> ticketMaps = new HashMap<String, ArrayList<Flight>>();
		ArrayList<Flight> flights = new ArrayList<>();
		ArrayList<String> routes = new ArrayList<>();

		Arrays.sort(tickets, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				String v1 = o1[0];
				String v2 = o2[0];
				
				if(v1.equals(v2)) {return o1[1].compareTo(o2[1]);}
				
				return v1.compareTo(v2);
			}
		});
		for (int i = 0; i < tickets.length; i++) {
			System.out.println(tickets[i][0] + ", " + tickets[i][1]);
		}
		
		for (int i = 0; i < tickets.length; i++) {
			if(i+1 < tickets.length && tickets[i][0].equals(tickets[i+1][0])) {
				System.out.println("ddd");
				flights.add(new Flight(tickets[i][1]));
				continue;
			}
			flights.add(new Flight(tickets[i][1]));
			ArrayList<Flight> flList = new ArrayList<>();
			
			flList.addAll(flights);
			for(int j=0; j<flList.size(); j++) 
				System.out.println(j+", "+flList.get(j).getEndPoint());
			ticketMaps.put(tickets[i][0], flList);
			flights.clear();
		}

//		Set<String> keys = ticketMaps.keySet();
//		for(String key : keys) {
//			System.out.println(key + "---");
//			ArrayList<Flight> flights2 = ticketMaps.get(key);
//			for(int i=0; i<flights2.size(); i++) 
//				System.out.println(flights2.get(i).getEndPoint());
//		}
		
		dfs("ICN", ticketMaps, routes);
		
		answer = new String[routes.size()];
//		System.out.println(routes.size());
		answer = routes.toArray(answer);
		
//		for(int i=0; i<answer.length; i++)
//			System.out.println(answer[i] + " ");
		return answer;
	}
	
	public void dfs(String startPoint, HashMap<String, ArrayList<Flight>> maps, ArrayList<String> routes) {
		
		//System.out.println(startPoint);
		routes.add(startPoint); // 지역 추가
		ArrayList<Flight> flightList = maps.get(startPoint);
			
		for(int i=0; i<flightList.size(); i++) {
			if(!flightList.get(i).isChecked()) { // 아직 티켓을 사용하지 않은 경우
				maps.get(startPoint).get(i).setChecked(true); // 티켓 사용 표기
				dfs(flightList.get(i).getEndPoint(), maps, routes);
				return;
			}
		}
	}

}