/*
** programmers-라면공장.cpp
** 2020-05-06
*/

#include <string>
#include <queue>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

bool compare(int a, int b) {
	return a>b;
}

int solution(int stock, vector<int> dates, vector<int> supplies, int k) {
    int answer = 0;    
    priority_queue<int, vector<int>, less<int> > max_pq;
    int day = 0;
    int idx = 0;
    
    while(day<k) {
    	
    	stock--;
    	day++;
    	
    	if(stock >= k-day) {
    		break;
		}
    	
    	// 1. 해당 날짜에 공급되는 밀가루가 있는 경우 우선순위 큐에 저장 
		if(dates[idx] == day) {
			max_pq.push(supplies[idx]);
			idx++;
		}
		
		// 2. 밀가루가 모두 소진된 경우 지금까지 받아놓은 밀가루 중에서 가장 많은 것 사용
		if(stock == 0) {
			cout << max_pq.size();
			stock += max_pq.top();
			max_pq.pop();
			answer++;
		} 
				
	}

    return answer;
}

int main(void) {
	
	vector<int> dates;
	vector<int> supplies;
	
	dates.push_back(4);
	dates.push_back(10);
	dates.push_back(15);
	
	supplies.push_back(20);
	supplies.push_back(5);
	supplies.push_back(10);
	
	cout << solution(4, dates, supplies, 30) << endl;
	return 0; 
}
