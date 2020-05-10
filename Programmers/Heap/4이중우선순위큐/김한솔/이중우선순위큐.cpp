/*
** programmers-이중우선순위큐.cpp
** 2020-05-06
*/

#include <string>
#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>

using namespace std;

vector<int> solution(vector<string> operations) {
    vector<int> answer;
    int num, size=0;
    priority_queue<int, vector<int>, less<int> > max_pq;
    priority_queue<int, vector<int>, greater<int> > min_pq;
    
    
    for(int i=0; i<operations.size(); i++) {
    	
    	if(operations[i].at(0) == 'I') { // 큐에 주어진 숫자를 삽입하는 연산
			string numStr = operations[i].substr(2, operations[i].size()-2);
			num = stoi(numStr);

			max_pq.push(num);
			min_pq.push(num);
			size++;
    		
		} else if(operations[i].at(0) == 'D' && size > 0){ // 큐에서 삭제하는 연산 
			if(operations[i].at(2) == '1')  { // 최댓값 삭제 
				max_pq.pop();				
			} else { // 최솟값 삭제 
				min_pq.pop();
			}
			size--;
			if(size == 0) { // 큐안에 값이 없는경우 => 모두 소진시켜야 한다. 
				while(!max_pq.empty()) {
					max_pq.pop();
				}
				while(!min_pq.empty()) {
					min_pq.pop();
				}
			}
		} else {
			continue;
		}
    	
	}
	
	if(size > 0) {
		int max = max_pq.top();
		int min = min_pq.top();
		answer.push_back(max);
		answer.push_back(min);
	} else {
		answer.push_back(0);
		answer.push_back(0);
	}

    return answer;
}

int main(void) {
	
	
	return 0; 
}
