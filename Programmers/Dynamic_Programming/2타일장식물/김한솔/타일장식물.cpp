/*
** programmers-타일장식물.cpp
** 2020-04-15
*/

#include <iostream>

using namespace std;

long long numCache[81] = { 0, };
long long roundCache[81] = { 0, };

long long fibonacci(int N) {
	
	if(N == 1) { return 1; }
	if(N == 2) { return 1; }
	if(N == 3) { return 2; }
	if(numCache[N] != 0)
		return numCache[N];
	return numCache[N] = fibonacci(N-1) + fibonacci(N-2);
	
}

long long solution(int N) {
    
	if(N == 1) { 
		return 4*fibonacci(N);
	}
	
	if(roundCache[N] != 0) 
		return roundCache[N];
	return roundCache[N] = 2*fibonacci(N)+solution(N-1);
}
 
int main(void) {
	
	long long n;
	cin >> n;
	cout << solution(n) << endl;
	
	return 0;
}
