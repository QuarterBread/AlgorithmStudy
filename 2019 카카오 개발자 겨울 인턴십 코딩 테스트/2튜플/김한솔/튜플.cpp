/*
** programmers-튜플.cpp
** 2020-05-11
*/

#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#define MEM_SIZE 100001

using namespace std;

int memory[MEM_SIZE] = {0,};
int memory_idx[MEM_SIZE] = {0,};

bool compare(int a, int b) {
	return a>b;
}

vector<int> solution(string s) {
    vector<int> answer;
   	int idx = 0; 
   	int temp_idx;
   	int num = 0;
   	int cnt = 0;
   	string num_str;
   	
   	idx++;
   	while(idx<s.length()) {
   	
	   if(s[idx] == '{') {
	   		
			idx++;
			temp_idx = idx; // 기존 idx 기억 
				   	
			while(true)	{
				idx++;
								
				if(s[idx] == '}' || s[idx] == ',') {
					num_str = s.substr(temp_idx, idx-temp_idx);
					// cout << num_str << endl;
					num = stoi(num_str);
					memory[num] += 1;
					if(s[idx] == '}') { // 하나의 원소배열 끝 
						idx += 2; // '}' 와 ','를 지나침
						cnt++;
						break;
					}
					temp_idx = ++idx;
				}	
			}
		
	   }
	}
    
	
	for(int i=1; i<MEM_SIZE; i++) {
		if(memory[i] != 0)
			memory_idx[memory[i]] = i;
	}	
	
	for(int i=cnt-1; i>0; i--) {
		answer.push_back(memory_idx[i]);
	}
    
    return answer;
}
