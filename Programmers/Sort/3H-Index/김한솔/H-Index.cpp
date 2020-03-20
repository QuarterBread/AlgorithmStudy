/*
** programmers-H-Index.cpp
** 2020-03-19
*/

#include <algorithm>
#include <vector>
#include <iostream>

using namespace std;

bool compare(int a, int b) {
	return a>b;
}

int solution(vector<int> citations) {
    int answer = 0, cnt = 0;
    	
    sort(citations.begin(), citations.end(), compare); // 내림차순 정렬 
    
    for(int i=0; i<citations.size(); i++) {
    	answer = citations[i];
    	cnt++;
    	
    	if(answer == cnt) {
    		answer = cnt;
    		break;
		} else if(answer < cnt){
			answer = cnt-1;
			break;
		}   	
	}

    return cnt;
}

int main(void) {
	
	vector<int> citations;
	citations.push_back(42);
	citations.push_back(22);
	//citations.push_back(6);
	//citations.push_back(1);
	//citations.push_back(5);
	
	cout << solution(citations) << endl;
	
	return 0;	
}
