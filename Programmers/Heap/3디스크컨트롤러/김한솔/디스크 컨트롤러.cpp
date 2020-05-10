/*
** programmers-디스크 컨트롤러.cpp
** 2020-05-03
*/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool visited[500] = {false, };

bool compare(vector<int> a, vector<int> b) {	
	if(a.front() == b.front()) {
		return a.back() < b.back();
	} else {
		return a.front() < b.front();	
	}
}

int solution(vector<vector<int> > jobs) {
    int answer = 0;
    int size = jobs.size(); // 디스크 개수 
    int spendTime = 0; // 총 소요시간 
    int time = 0; // 현재 시간
    int workingRequestTime; // 작업이 요청되는 시점
    int workingSpendTime; // 작업의 소요시간
    bool flag = false;
    int idx;
    
    sort(jobs.begin(), jobs.end(), compare);
    
    for(int i=0; i<size; ) {
    	
    	if(visited[i]) { // 이미 작업한 경우 
    		i++;
    		continue;	
		}
    	    	
    	flag = false;
    	int temp = jobs[i][1];
    	for(int j=i; j<size; j++) {
    		if(time >= jobs[j][0] && !visited[j] && temp >= jobs[j][1]) { // 현재 시간안에 요청시간이 있고 작업이 수행되지 않았으며 작업시간이 더 짧은경우
    			temp = jobs[j][1];
    			workingRequestTime = jobs[j][0];
    			workingSpendTime = jobs[j][1];
    			flag = true;
    			idx = j;
			}
		}
		
		if(flag) {
			visited[idx] = true;
		}
		
		if(!flag) {
			workingRequestTime = jobs[i][0];
    		workingSpendTime = jobs[i][1];
    		time = workingRequestTime;
    		visited[i] = true;
    		i++;
		}
	    	        
    	time += workingSpendTime;
        
    	spendTime += (time-workingRequestTime);
	}
	
	
	answer = spendTime/size;
    return answer;
}

int main(void) {
	
	vector<vector<int> > jobs;
	
	vector<int> a;
	vector<int> b;
	vector<int> c;
	
	a.push_back(0);
	a.push_back(3);
	
	b.push_back(1);
	b.push_back(9);
	
	c.push_back(2);
	c.push_back(6);

	jobs.push_back(a);
	jobs.push_back(b);
	jobs.push_back(c);

	solution(jobs);

	return 0; 
}
