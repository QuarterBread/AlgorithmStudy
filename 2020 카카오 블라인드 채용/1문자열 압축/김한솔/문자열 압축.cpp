/*
** programmers-문자열 압축.cpp
** 2020-05-31
*/

#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(string s) {
    int answer = 100000;
    int cnt = 1;
    string temp, result;
    
    if(s.length() == 1) { return 1; }
    
    for(int i=1; i<=s.length() / 2; i++) { // i : 문자열을 자르는 개수(단위) 
    	
        result = ""; // 압축 후처리 문자열 
        
        for(int j=0; j<s.length(); j+=i) {
        	
            temp = s.substr(j, i); // 비교기준 문자열
            
            if(j+i > s.length() || temp != s.substr(j+i, i)) { // 문자열이 같지 않거나 비교 길이를 초과한 경우 
                if(cnt != 1) {
                	result += to_string(cnt);
				}
                    
                result += temp;
                cnt = 1;
            }
            else {
            	cnt++;
			}
                
        }
        
        if(answer > result.length()) {
            answer = result.length();
        }
        
    }

    
    return answer;
}
