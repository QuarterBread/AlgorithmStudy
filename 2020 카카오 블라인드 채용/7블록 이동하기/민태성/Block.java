package Kakao2020Blind;

import java.util.LinkedList;
import java.util.Queue;

public class Block {
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 1, 1},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 0, 0}
        };

        Solution s = new Solution();
        System.out.println(s.solution(board));
    }

    static class Solution {
        int dx[] = {0, -1, 0, 1};
        int dy[] = {1, 0, -1, 0};

        boolean[][] armAvisited;
        boolean[][] armBvisited;
        int answer = 0;

        public int solution(int[][] board) {

            armAvisited = new boolean[board.length][board.length];
            armBvisited = new boolean[board.length][board.length];
            bfs(board, armAvisited, armBvisited);

            return answer;
        }

        private void bfs(int[][] board, boolean[][] armAvisited, boolean[][] armBvisited) {
            Arm a = new Arm(0, 0);
            Arm b = new Arm(0, 1);
            Robot robot = new Robot(a, b, 0);
            armAvisited[0][0]= true;
            armBvisited[0][1] =true;
            Queue<Robot> q = new LinkedList<>();
            q.add(robot);

            while (!q.isEmpty()) {
                Robot current = q.poll();
                System.out.println("q poll = [" + current.armA.x + "][" + current.armA.y+"] , [" + current.armB.x+"]["+current.armB.y+"]");
                if (current.armA.x == board.length && current.armA.y == board.length) {
                    answer = current.cnt;
                    return;
                }
                if (current.armB.x == board.length && current.armB.y == board.length) {
                    answer = current.cnt;
                    return;
                }

                for (int i = 0; i < 4; i++) {
                    int armAnextX = current.armA.x + dx[i];
                    int armAnextY = current.armA.y + dy[i];
                    int armBnextX = current.armB.x + dx[i];
                    int armBnextY = current.armB.y + dy[i];
                    System.out.println(armAnextX + " , " + armAnextY + " , " + armBnextX + " , " + armBnextY);

                    if (armAnextX < 0 || armAnextY < 0 || armBnextX < 0 || armBnextY < 0 || armAnextX >= board.length || armBnextX >= board.length ||
                            armAnextY >= board.length || armBnextY >= board.length)
                        continue;
                    if (board[armAnextX][armAnextY] == 1 || board[armBnextX][armBnextY] == 1 || armAvisited[armAnextX][armAnextY] || armBvisited[armBnextX][armBnextY])
                        continue;
                    System.out.println("condition ok q .add");
                    q.add(new Robot(new Arm(armAnextX, armAnextY), new Arm(armBnextX, armBnextY), current.cnt++));

                    if (!armAvisited[armAnextX][armAnextY])
                        armAvisited[armAnextX][armAnextY] = true;
                    if (!armBvisited[armBnextX][armBnextY])
                        armBvisited[armBnextX][armBnextY] = true;
                }

                int armAnextX = current.armA.x;
                int armBnextX = current.armB.x;
                int armAnextY = current.armA.y;
                int armBnextY = current.armB.y;
                System.out.println("current Arm A = [" + armAnextX + "][" + armAnextY + "]  Arm B = [" + armBnextX + "][" + armBnextY + "]");
                //가로에서 세로로 돌릴수 있는지 시계방향, 반시게

                //A가 외쪽 B 오른쪽 일때 아래쪽세로로 돌리는거
                if (armAnextY < armBnextY) {
                    if (armAnextX+1 <board.length && armBnextX+1 < board.length && board[armAnextX + 1][armAnextY] == 0 && board[armBnextX + 1][armBnextY] == 0) {
                       // if (!armAvisited[armAnextX + 1][armAnextY + 1]) {
                            q.add(new Robot(new Arm(armAnextX + 1, armAnextY + 1), new Arm(armBnextX, armBnextY), current.cnt++));
                            System.out.println("가로에서 세로로 회전 A가 왼쪽일때 A를 B 아래로 반시계방향 회전  q .add ( " + (armAnextX + 1) + " , " + (armAnextY + 1));
                     //       armAvisited[armAnextX + 1][armAnextY + 1] = true;
                   //     }
                      //  if (!armBvisited[armBnextX + 1][armBnextY - 1]) {
                            q.add(new Robot(new Arm(armAnextX, armAnextY), new Arm(armBnextX + 1, armBnextY - 1), current.cnt++));
                            System.out.println("가로에서 세로로 회전 B가 오른쪽일때 B를 A 아래로 시계방향 회전  q .add ( " + (armBnextX + 1) + " , " + (armBnextY - 1));
                      //      armBvisited[armBnextX + 1][armBnextY - 1] = true;
                      //  }
                    }
                } else if (armAnextY > armBnextY) {
                    if (armAnextX+1 <board.length && armBnextX+1 < board.length && board[armAnextX + 1][armAnextY] == 0 && board[armBnextX + 1][armBnextY] == 0) {
                    //    if (!armAvisited[armAnextX + 1][armAnextY - 1]) {
                            q.add(new Robot(new Arm(armAnextX + 1, armAnextY - 1), new Arm(armBnextX, armBnextY), current.cnt++));
                            System.out.println("가로에서 세로로 회전 / A가 오른쪽일때 A를 B 아래로 시계방향 회전  q .add ( " + (armAnextX + 1) + " , " + (armAnextY - 1));
                      //      armAvisited[armAnextX + 1][armAnextY - 1] = true;
                      //  }
                     //   if (!armBvisited[armBnextX + 1][armBnextY + 1]) {
                            q.add(new Robot(new Arm(armAnextX, armAnextY), new Arm(armBnextX + 1, armBnextY + 1), current.cnt++));
                            System.out.println("가로에서 세로로 회전 / B가 왼쪽일때 B를 A아래로 반시계회전  q .add ( " + (armBnextX + 1) + " , " + (armBnextY + 1));
                    //        armBvisited[armBnextX + 1][armBnextY + 1] = true;
                       // }
                    }
                }

                //세로에서 가로로 돌리는거
                if (armAnextX < armBnextX) {
                    if (armAnextY+1 <board.length && armBnextY+1 < board.length && board[armAnextX][armAnextY + 1] == 0 && board[armBnextX][armBnextY + 1] == 0) {
                      //  if (!armAvisited[armAnextX + 1][armAnextY + 1]) {
                            q.add(new Robot(new Arm(armAnextX + 1, armAnextY + 1), new Arm(armBnextX, armBnextY), current.cnt++));
                            System.out.println("세로에서 가로로 회전 / A가 위쪽일때 A를 B옆으로 시게 방향으로 회전   q .add ( " + (armAnextX + 1) + " , " + (armAnextY + 1));
                    //        armAvisited[armAnextX + 1][armAnextY + 1] = true;
                      //  }

                       // if (!armBvisited[armBnextX - 1][armBnextY + 1]) {
                            q.add(new Robot(new Arm(armAnextX, armAnextY), new Arm(armBnextX - 1, armBnextY + 1), current.cnt++));
                            System.out.println("세로에서 가로로 회전 / B가 아래쪽일때 B를 A옆으로 반시계 방향으로 회전  q .add ( " + (armBnextX - 1) + " , " + (armBnextY + 1));
                     //       armBvisited[armAnextX - 1][armAnextY + 1] = true;
                      //  }
                    }
                } else if (armAnextX > armBnextX) {
                    if (armAnextY+1 <board.length && armBnextY+1 < board.length &&board[armAnextX][armAnextY + 1] == 0 && board[armBnextX][armBnextY + 1] == 0) {
                     //   if (!armAvisited[armAnextX - 1][armAnextY + 1]) {
                            q.add(new Robot(new Arm(armAnextX - 1, armAnextY + 1), new Arm(armBnextX, armBnextY), current.cnt++));
                            System.out.println("세로에서 가로로 회전 / A가 아래쪽일때 A를 B옆으로 반시게 방향으로 회전   q .add ( " + (armAnextX - 1) + " , " + (armAnextY + 1));
                      //      armAvisited[armAnextX - 1][armAnextY + 1] = true;
                //        }
                //        if (!armBvisited[armBnextX + 1][armBnextY + 1]) {
                            q.add(new Robot(new Arm(armAnextX, armAnextY), new Arm(armBnextX + 1, armBnextY + 1), current.cnt++));
                            System.out.println("세로에서 가로로 회전 / B가 위쪽일때 B를 A옆으로 시계 방향으로 회전  q .add ( " + (armBnextX + 1) + " , " + (armBnextY + 1));
                 //           armBvisited[armBnextX + 1][armBnextY + 1] = true;
                  //      }
                    }
                }
            }


        }

        class Robot {
            Arm armA;
            Arm armB;
            int cnt;

            public Robot(Arm a, Arm b, int cnt) {
                armA = a;
                armB = b;
                this.cnt = cnt;
            }

        }

        class Arm {
            int x;
            int y;

            public Arm(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

    }
}
