/*
** programmers-카드게임.cpp
** 2020-04-15
*/

#include <iostream>
#include <vector>

using namespace std;

int cachePoint[2000][2000];
int leftCard[2000];
int rightCard[2000];

int game(int leftIdx, int rightIdx) {
	
	// 1. 남은 카드가 없는 경우
	if(leftIdx == (sizeof(leftCard)/sizeof(int)) || rightIdx == (sizeof(rightCard)/sizeof(int))) {		
		return 0;
	}
	
	if(cachePoint[leftIdx][rightIdx] != -1) { // 값이 존재하는 경우 
		return cachePoint[leftIdx][rightIdx];
	}
	
	// 2. 왼쪽이 오른쪽보다 작은 경우 -> 오른쪽 버리고 포인트 획득
	if(leftCard[leftIdx] > rightCard[rightIdx]) {
		cachePoint[leftIdx][rightIdx] = game(leftIdx, rightIdx+1) + rightCard[rightIdx];
	} else { // 3. 왼쪽이 오른쪽보다 큰 경우
		cachePoint[leftIdx][rightIdx] = max(game(leftIdx+1, rightIdx+1),  game(leftIdx+1, rightIdx));
	}
	return cachePoint[leftIdx][rightIdx];
}

int solution(vector<int> left, vector<int> right) {
	
	for(int i=0; i<left.size(); i++) {
		for(int j=0; j<right.size(); j++) {
			cachePoint[i][j] = -1;
			leftCard[i] = left[i];
			rightCard[i] = right[i];
		}
	}

    return game(0, 0);
}

int main(void) {
	
	vector<int> left;
	vector<int> right;
	int n, num;
	
	cin >> n;
	
	for(int i=0; i<n; i++)  {
		cin >> num;
		left.push_back(num);
	}
	
	for(int i=0; i<n; i++)  {
		cin >> num;
		right.push_back(num);
	}
	
	cout << solution(left, right) << endl;
	
	return 0;
}
