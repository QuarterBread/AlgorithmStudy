/*
** programmers-예산.cpp
** 2020-04-22
*/

#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(vector<int> budgets, int M) {
    int answer = 0;
    long long k = 0;  // 지방의 예산요청 총 금액
    // int idx = (0+budgets.size())/2;
    
    for(int i=0; i<budgets.size(); i++) {
    	k += budgets[i];
	}
		
	sort(budgets.begin(), budgets.end());
	
	if(k <= M) {		
		return budgets[budgets.size()-1];
	} else {
		for(int i=0; i<budgets.size(); i++) {
			cout << M << endl;
			cout << budgets[i]*(budgets.size()-i) << endl;
			cout << endl;
			if(M >= (budgets[i]*(budgets.size()-i))) {
				M -= budgets[i];
			} else {
				return M/(budgets.size()-i);
			}
		}
	}
}

int main(void) {
	
	vector<int> budgets;
	budgets.push_back(120);
	budgets.push_back(110);
	budgets.push_back(140);
	budgets.push_back(150);
	
	cout << solution(budgets, 485) << endl;
	return 0;
}

