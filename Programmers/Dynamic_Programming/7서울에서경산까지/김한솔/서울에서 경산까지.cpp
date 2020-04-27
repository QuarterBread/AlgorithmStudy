/*
** programmers-서울에서 경산까지.cpp
** 2020-04-26
*/

#include <vector>
#include <iostream>

using namespace std;

int memory[101][100001] = { 0, };
bool isAccess[101][100001];
int travelArr[101][4];
int cities;
int times;

int dp(int idx, int remainTime) {
	
	if(remainTime < travelArr[idx][2]) {
		return -1;
	}
	
	if(idx < 0) {
		return 0;
	}
	
	if(memory[idx][remainTime] != 0) {
		return memory[idx][remainTime];
	}
	
	if((remainTime-travelArr[idx][0]) >= 0 && dp(idx-1, remainTime-travelArr[idx][0]) != -1) { // 도보 경로 이동할 수 있는 경우
		memory[idx][remainTime] = max(memory[idx][remainTime], dp(idx-1, remainTime-travelArr[idx][0])+travelArr[idx][1]);
	}
	
	if((remainTime-travelArr[idx][2]) >= 0 && dp(idx-1, remainTime-travelArr[idx][2]) != -1) { // 자전거 경로 이동할 수 있는 경우
		memory[idx][remainTime] = max(memory[idx][remainTime], dp(idx-1, remainTime-travelArr[idx][2])+travelArr[idx][3]);
	}
	
	if(isAccess[idx][remainTime])
		return memory[idx][remainTime];
} 

int solution(int K, vector<vector<int> > travel) {
    int answer = 0;
    cities = travel.size(); // travel 행의 갯수 : 거쳐가는 도시의 개수
    times = K; // 남은 시간 
    
    for(int i=0; i<cities; i++) {
    	travelArr[i][0] = travel[i][0];
    	travelArr[i][1] = travel[i][1];
    	travelArr[i][2] = travel[i][2];
    	travelArr[i][3] = travel[i][3];
	}
    
    answer = dp(cities, times);
    
    return answer;
}

int main(void) {

	vector<vector<int> > travel;
	vector<int> a;
	vector<int> b;
	vector<int> c;
	vector<int> d;
	
//	a.push_back(500);
//	a.push_back(200);
//	a.push_back(200);
//	a.push_back(100);
//	
//	b.push_back(800);
//	b.push_back(370);
//	b.push_back(300);
//	b.push_back(120);
//	
//	c.push_back(700);
//	c.push_back(250);
//	c.push_back(300);
//	c.push_back(90);
	
	a.push_back(1000);
	a.push_back(2000);
	a.push_back(300);
	a.push_back(700);
	b.push_back(1100);
	b.push_back(1900);
	b.push_back(400);
	b.push_back(900);
	c.push_back(900);
	c.push_back(1800);
	c.push_back(400);
	c.push_back(700);
	
	d.push_back(1200);
	d.push_back(2300);
	d.push_back(500);
	d.push_back(1200);
	
	travel.push_back(a);
	travel.push_back(b);
	travel.push_back(c);
	travel.push_back(d);

	solution(3000, travel);
	
	return 0;
}


