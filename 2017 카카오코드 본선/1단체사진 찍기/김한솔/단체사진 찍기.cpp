/*
** programmers-단체사진 찍기.cpp
** 2020-05-11
*/

#include <string>
#include <vector>
#include <iostream>

using namespace std;

char person[] = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
vector<string> constrain_data;
int constraint_cnt;
int cnt;
int size;

int swap(int i,int j) {
    int temp;
    if(i==j) return 0;
    temp = person[i];
    person[i]=person[j];
    person[j]=temp;
    return 0;
}

int permutation(int n, int r, int depth)
{
    int i, a_idx, b_idx, diff;
    char person_a, person_b;
    char symbol;
    int num, temp_cnt=0;
	
    if( r==depth ) { // 의미
	
		for(int j=0; j<constraint_cnt; j++) {
			string constraint_str = constrain_data[j];
			person_a = constraint_str[0];
			person_b = constraint_str[2];
			symbol = constraint_str[3];
			num = constraint_str[4]-'0';				
			
			for(int k=0; k<size; k++) {
				if(person_a == person[k]) {
					a_idx = k;
				}
				if(person_b == person[k]) {
					b_idx = k;
 				}
			}
			
			diff = a_idx > b_idx ? a_idx-b_idx : b_idx-a_idx;
			
			if(symbol == '=' && diff-1 == num) {
				temp_cnt++;
			} else if(symbol == '>' && diff-1 > num) {
				temp_cnt++;
			} else if(symbol == '<' && diff-1 < num){
				temp_cnt++;
			} else {
				break;
			}
		}
		
		if(temp_cnt == constraint_cnt) {
			cnt++;
		}
		
        return 0;
    }

    for(i=depth;i<n;i++){
        swap(i, depth);
        permutation(n,r,depth+1);
        swap(i, depth);
    }
    return 0;
}

// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
int solution(int n, vector<string> data) {
		
    int answer = 0;
    constrain_data = data;
    constraint_cnt = n;
    cnt = 0;
    size = 8;
    
    permutation(8, 8, 0);
    
    answer = cnt;
    return answer;
}

int main(void) {
	
	vector<string> data;
	data.push_back("N~F=0");
	data.push_back("R~T>2");
	solution(2, data);
	
	cout << cnt << endl;
}
