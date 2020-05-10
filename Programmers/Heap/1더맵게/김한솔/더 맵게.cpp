/*
** programmers-´õ ¸Ê°Ô.cpp
** 2020-05-02
*/

#include <algorithm>
#include <vector>
#include <iostream>
#include <queue>

using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = -1;
    priority_queue<int, vector<int>, greater<int> > pq;
    int n1, n2, n3;
    int cnt = 0;
    
    for(int i=0; i<scoville.size(); i++) {
    	pq.push(scoville[i]);
	}
    
   	while(true) {
   				
   		if(pq.size() == 1) {
   			if(pq.top() >= K)	{ return cnt;}
			else { return -1;}		
		}
		
		n1 = pq.top();
		pq.pop();
		n2 = pq.top();
		pq.pop();
		
		cout << n1 << " " << n2 << endl;
		
		if(n1 >= K) { 
			return cnt;
		}
		
		n3 = n1 + n2*2;
		cnt++;
		
		pq.push(n3);		
	}
	   
    return answer;
}

int main(void) {
	
	vector<int> scoville;
	scoville.push_back(1);
	scoville.push_back(2);
	scoville.push_back(3);
	scoville.push_back(9);
	scoville.push_back(10);
	scoville.push_back(12);
	
	int K = 7;
	
	cout << solution(scoville, K);
	
	return 0; 
}
