/*
** programmers-스킬트리.cpp
** 2020-05-11
*/

#include <string>
#include <cstring>
#include <vector>
#include <iostream>

using namespace std;

int solution(string skill, vector<string> skill_trees) {
    int answer = 0;
    int prior_arr[26];
    int prior_cnt = 0; // 배운 선행스킬 개수
	bool isAnswer = false; 
    
    memset(prior_arr, -1, sizeof(prior_arr)); // -1로 초기화 
    
    for(int i=0; i<skill.length(); i++) {
    	prior_arr[skill[i]-65] = i; // A의 경우 0번 인덱스에 저장 
	}
	
	for(int i=0; i<prior_arr.size(); i++) {
    	cout << prior_arr[i] << " ";
	}
	cout << endl;
    
    for(int i=0; i<skill_trees.size(); i++) {
    	string skill_str = skill_trees[i];
    	prior_cnt = 0;
    	isAnswer = true;
    	
    	for(int j=0; j<skill_str.length(); j++) {
    		if(prior_arr[skill_str[j]-65] == -1) { // 선행스킬이 따로 없는 경우 
    			continue;
			}
			
			if(prior_arr[skill_str[j]-65] != prior_cnt)	{ // 선행스킬을 배우지 않고 배우려 하는 경우 
				isAnswer = false;
				break; 
			}
			
			// 선행스킬인 경우
			prior_cnt++; 
		}
		
		if(isAnswer) { answer++; }
	
	}
    
    return answer;
}
