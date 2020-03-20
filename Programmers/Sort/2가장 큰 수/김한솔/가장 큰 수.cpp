/*
** programmers-가장 큰 수.cpp
** 2020-03-16
*/

#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <iostream>

using namespace std;

bool compare(int numA, int numB) {
	int lengthA=0, lengthB=0, tempA, tempB;
	stack<int> a, b;
	int t=0, k=0;
	
	tempA = numA; tempB = numB;
    if(numA == numB) { return numA>numB; }
		
	while(tempA > 0) {		
		tempA /= 10;
		lengthA++;		
	}
	
	while(tempB > 0) {
		tempB /= 10;
		lengthB++;
	}
	
	tempA = numA; tempB = numB;
	
	for(int i=lengthA; i>0; i--) {		
		a.push(tempA%10);
		tempA/=10;
	}
	
	for(int j=lengthB; j>0; j--) {		
		b.push(tempB%10);
		tempB/=10;
	}
	
	while((!a.empty()) && (!b.empty())) {
		t = a.top();
		k = b.top();
		
		if(t!=k) {
			return t>k;
		}
		
		a.pop(); b.pop();
	}
	
	while(!a.empty()) { // a숫자가 남았을 때(더 긴 숫자일 때)
		t = a.top();
		if(t!=k) {
			return t>k;
		}
		a.pop();
	}
	
	while(!b.empty()) {
		k = b.top();
		if(t!=k) {
			return t>k;
		}
		b.pop();
	}
    
    return t>k;
}

string solution(vector<int> numbers) {
    string answer = "";
    
    sort(numbers.begin(), numbers.end(), compare);
    
    if(numbers[0] == 0)
        return "0";
    
	for(int i=0; i<numbers.size(); i++) {
        //cout << numbers[i] << endl;
        string str = to_string(numbers[i]);
        answer.append(str);
	}
    
    return answer;
}
