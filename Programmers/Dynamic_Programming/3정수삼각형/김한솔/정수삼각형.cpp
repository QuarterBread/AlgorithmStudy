/*
** programmers-Á¤¼ö »ï°¢Çü.cpp
** 2020-04-26
*/

#include <string>
#include <vector>
#include <iostream>

using namespace std;

int memory[501][501] = { 0, };
int height;
int triArr[500][500];

int getNumber(int x, int y) {
	
	if(x==height-1) {
		return triArr[x][y];
	}
	
	if(memory[x][y] != 0) {return memory[x][y];}
	
	return memory[x][y] = max(getNumber(x+1, y), getNumber(x+1, y+1))+triArr[x][y];
	
}

int solution(vector<vector<int> > triangle) {
    int answer = 0;
	
	height = triangle.size();
	
	for(int i=0; i<height; i++) {
		for(int j=0; j<triangle[i].size(); j++) {
			triArr[i][j] = triangle[i][j];
		}
	}
	
	answer = getNumber(0, 0);
    
    return answer;
}


int main(void) {
	
	vector<vector<int> > triangle;
	vector<int> a;
	vector<int> b;
	vector<int> c;
	vector<int> d;
	vector<int> e;
	
	a.push_back(7);
	b.push_back(3);
	b.push_back(8);
	c.push_back(8);
	c.push_back(1);
	c.push_back(0);
	d.push_back(2);
	d.push_back(7);
	d.push_back(4);
	d.push_back(4);
	e.push_back(4);
	e.push_back(5);
	e.push_back(2);
	e.push_back(6);
	e.push_back(5);
	
	triangle.push_back(a);
	triangle.push_back(b);
	triangle.push_back(c);
	triangle.push_back(d);
	triangle.push_back(e);
		
	solution(triangle);
	
	return 0;
}
