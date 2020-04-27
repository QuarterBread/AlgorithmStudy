/*
** programmers-µî±·±æ.cpp
** 2020-04-27
*/

#include <iostream>
#include <vector>

#define SharingNumber 1000000007

using namespace std;

long long int memory[101][101] = {0,};

int solution(int m, int n, vector<vector<int> > puddles) {
    int answer = 0;	 
    
    for(int k=0; k<puddles.size(); k++) {
    	
		memory[puddles[k][0]][puddles[k][1]] = -1;
 		if(puddles[k][0] == 1) {
 			for(int i=puddles[k][1]+1; i<=n; i++) {
 				memory[puddles[k][0]][i] = -1;
 			}
 		}
		
 		if(puddles[k][1] == 1) {
 			for(int i=puddles[k][0]+1; i<=m; i++) {
 				memory[i][puddles[k][1]] = -1;
 			}
 		}
	}
    
	for(int i=1; i<=m; i++) {
    	for(int j=1; j<=n; j++) {
            
            if(memory[i][j] == -1) {
            	memory[i][j] = 0;
                continue;
			} 
    		
    		if(i == 1 || j == 1) {
    			memory[i][j] = 1;
			} else {
			    memory[i][j] = (memory[i-1][j]+memory[i][j-1])%SharingNumber;	
			}    		
    		
		}
	}
	
	for(int i=1; i<=m; i++) {
    	for(int j=1; j<=n; j++) {
            
            cout << memory[i][j] << " ";  		
    		
		}
		cout << endl;
	}
    
    
    return memory[m][n]%SharingNumber;
}

int main(void) {
	
	vector<vector<int> > puddles;
	vector<int> a;
	vector<int> b;
	
	a.push_back(1);
	a.push_back(4);

	b.push_back(3);
	b.push_back(3);
	
	puddles.push_back(a);
	puddles.push_back(b);
		
	solution(30, 10, puddles);
	
	return 0;
}
