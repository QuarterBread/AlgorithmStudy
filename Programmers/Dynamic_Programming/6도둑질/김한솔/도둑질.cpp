/*
** programmers-도둑질.cpp
** 2020-04-17
*/

#include <iostream>
#include <vector>

using namespace std;

int maxMoney = 0;
int moneyCache[1000000];
int moneyCache2[1000000];
int moneyList[1000000]; 

int steal(int cur, bool flag, int size) { // 첫 번째 집부터 시작인 경우 -> 마지막집을 선택할 수 없다 
	
	if(cur>=size-1) { 
		return 0;
	}
	
	if(moneyCache[cur] != -1) { // 캐시에 저장되어 있으면 반환 
		return moneyCache[cur];
	}
	
	return moneyCache[cur] = max(steal(cur+2, true, size) + moneyList[cur], steal(cur+1, false, size));

}

int steal2(int cur, bool flag, int size) { // 두 번째 집부터 시작인 경우 -> 첫번째 집을 선택할 수 없다 
	
	if(cur>=size) { 
		return 0;
	}
	
	if(moneyCache2[cur] != -1) { // 캐시에 저장되어 있으면 반환 
		return moneyCache2[cur];
	}
	
	return moneyCache2[cur] = max(steal2(cur+2, true, size) + moneyList[cur], steal2(cur+1, false, size));


}

int solution(vector<int> money) {
	
	int size = money.size();
	
	for(int i=0; i<size; i++) {
		moneyList[i] = money[i];
		moneyCache[i] = -1;
		moneyCache2[i] = -1;
	}
    
    maxMoney = max(steal(0, false, size), steal2(1, false, size));
    
    return maxMoney;
}


int main(void) {
	
	vector<int> money;
	money.push_back(1);
	money.push_back(2);
	money.push_back(3);
	money.push_back(4);
	money.push_back(6);
	money.push_back(3);
	money.push_back(7);
	
	
	cout << solution(money) << endl;
	
	return 0;
}
