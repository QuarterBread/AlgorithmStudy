/*
** programmers-단어변환.cpp
** 2020-03-10
*/

#include <cstring>
#include <vector>
#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int checked[50] = {0};
vector<int> v[50];

void bfs(int start, int target) {
	
	memset(checked, -1, sizeof(checked));
	queue<int> q;	
	q.push(start);
	checked[start] = 0;		
	
	while(!q.empty()) {
		int x = q.front();			
		if(x == target) {return;}
				
		for(int i=0; i<v[x].size(); i++) {
			if(checked[v[x][i]] != -1) 
				continue;
			checked[v[x][i]] = checked[x]+1;
			q.push(v[x][i]);
		}
		q.pop();		
	}
	 
}

bool compare(int a, int b) {
	return a>b;
}

int solution(string begin, string target, vector<string> words) {
    int answer = 0, flag = 0;
    int wordLength = words[0].size();
    int beginIndex, targetIndex;
    
    for(int i=0; i<words.size(); i++) {
    	if(target == words[i]) {
    		targetIndex = i;
    		flag = 1;
    		break;
		}
	}
	
	if(!flag) { return answer; }
        
    words.push_back(begin);
    beginIndex = words.size()-1;
    
   	for(int i=0; i<words.size(); i++) {
	   
   		for(int j=0; j<words.size(); j++) {
   			if(i==j) 
				continue;
   			flag = 0;   			
   			for(int k=0; k<wordLength; k++) {
   				
				if(words[i].at(k) != words[j].at(k))
					flag++;
			}
			if(flag == 1) {
				v[i].push_back(j);				
			}			
		}
		cout << endl;	 		
	} 
    
    bfs(beginIndex, targetIndex);
    
    sort(checked, checked+50, compare);
    
    answer = checked[0];
    
    return answer;
}

int main(void) {
	
	string begin = "hit";
	string target = "cog";
	vector<string> words;
	words.push_back("hot");
	words.push_back("dot");
	words.push_back("dog");
	words.push_back("lot");
	words.push_back("log");
	words.push_back("cog");
	int a = solution(begin, target, words);
	cout << a << endl;
	
	return 0;
}
