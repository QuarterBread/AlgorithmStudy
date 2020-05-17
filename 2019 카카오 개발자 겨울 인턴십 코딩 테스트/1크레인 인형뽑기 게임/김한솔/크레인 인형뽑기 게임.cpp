/*
** programmers-크레인 인형뽑기 게임.cpp
** 2020-05-11
*/

#include <vector>
#include <iostream>
#include <cstring>

using namespace std;

int basket[900] = {0,}; 
int position_cache[30]; // 없으면 -1

int solution(vector<vector<int> > board, vector<int> moves) {
    int answer = 0;
    int basket_idx = 0;
    int basket_cnt = 0; // 현재 바구니에 존재하는 인형 갯수 
    int moves_idx = 0;
    int board_idx = 0;
    int size = board.size(); // board 크기
    
    memset(basket, -1, sizeof(basket));
    
    for(int i=0; i<size; i++) {
    	for(int j=0; j<size; j++) {
    		if(board[j][i] != 0) { // 인형이 존재하는 경우 
				position_cache[i] = j; // 인형이 존재하는 위치 저장 
				break;
			}
		}		
	}

	while(moves_idx < moves.size()) {
		
		int move_number = moves[moves_idx]-1;
		
		if(position_cache[move_number] == -1) { // 인형이 존재하지 않는 경우 
			moves_idx++;
			continue;
		}
		
		// 인형을 바구니에 넣음
		basket[basket_idx] = board[position_cache[move_number]][move_number];
		basket_cnt++;
		
		// position_cache 갱신
		if(position_cache[move_number] + 1 != size) { // 다음 인형인덱스로 이동 
			position_cache[move_number]++;
		} else { // 인형이 모두 소진된 경우 
			position_cache[move_number] = -1;
		}
		
		if(basket_cnt > 1) { // 바구니에 존재하는 인형 갯수가 2개 이상인 경우 
			if(basket[basket_idx] == basket[basket_idx-1]) { // 같은 인형이 존재하는 경우 
				basket[basket_idx] = 0;
				basket[basket_idx-1] = 0;
				basket_idx -= 2;
				basket_cnt -= 2;
				answer+=2;	
			}			
		}
		
		basket_idx++; 
		moves_idx++;
	}
    return answer;
}
