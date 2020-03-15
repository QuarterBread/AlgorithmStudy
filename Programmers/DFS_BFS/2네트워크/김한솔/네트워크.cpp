/*
** programmers-네트워크.cpp
** 2020-02-27
*/

#include <string>
#include <vector>
#include <iostream>

using namespace std;

bool checked[200];

void dfs(vector<vector<int> > com, int x) {
	
	if(checked[x]) {
		return;
	} 
	
	checked[x] = true;		
	cout << x << " ";
	for(int i=0; i<com[x].size(); i++) {
		if(com[x][i] == 1) {			
			dfs(com, i);	
		}		
	}
}

int solution(int n, vector<vector<int> > computers) {
    int answer = 0;
    
    for(int i=0; i<n; i++) {
    	if(checked[i]) {
    		continue;    		
		} else {
			dfs(computers, i);
			answer++;
		}
	}
    
    return answer;
}
