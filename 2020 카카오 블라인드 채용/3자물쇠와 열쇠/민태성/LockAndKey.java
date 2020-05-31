package Kakao2020Blind;

public class LockAndKey {
    public static void main(String[] args) {
        int[][] key = {
                {0, 0, 0},
                {1, 0, 0},
                {0, 1, 1}};
        int[][] lock = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}};

        Solution s = new Solution();
        System.out.println(s.solution(key, lock));
    }

    static class Solution {
        int[][] lock;
        boolean answer;

        public boolean solution(int[][] key, int[][] lock) {
            answer = false;
            this.lock = lock;
            int rotateKey[][] ;
            int degree = 90;
            int keyLen = key.length;
            int boardLen = lock.length+ (key.length-1)*2;
            int board[][] ;

            int len = boardLen - keyLen;

            // key =3 lock= 3 board = 7 , key =4 lock = 3 borad = 9  board-length - k
            for (int k = 0; k < 4; k++) {
                rotateKey = rotate(key, degree);

                for (int i = 0; i <len ; i++) {
                    for (int j = 0; j < len; j++) {
                        board = makeBoard(lock,boardLen,key);
                        if (inputKeyToBoard(rotateKey, board,keyLen, i, j))
                            answer = true;
                    }
                }

                degree = degree+ 90;
            }
            return answer;
        }

        private int[][] makeBoard(int[][] lock, int boardLen, int[][] key) {
            int board[][] = new int[boardLen][boardLen];
            for (int i = key.length-1; i <= board.length-key.length; i++) {
                for (int j = key.length-1; j <= board.length-key.length; j++) {
                    board[i][j] = lock[i-key.length+1][j-key.length+1];
                }
            }
            return board;
        }

        private void print(int[][] rotateKey) {
            for (int i = 0; i < rotateKey.length; i++) {
                for (int j = 0; j < rotateKey.length; j++) {
                    System.out.print(rotateKey[i][j] + " ");
                }
                System.out.println();
            }
        }

        public boolean inputKeyToBoard(int[][] key, int[][] board, int keyLen, int nx, int ny) {

            //board에 key값 add
            for (int i = nx; i <nx+ key.length; i++) {
                for (int j = ny; j <ny+ key.length; j++) {
                    board[i][j] += key[i-nx][j-ny];
                }
            }

            System.out.println("add key to board ");
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("==================");

            //보드에 넣은 키값영역과 lock부분을 대조
            for (int i = keyLen - 1; i <= board.length - keyLen; i++) {
                for (int j = keyLen - 1; j <= board.length - keyLen; j++) {
                    if (board[i][j] != 1) return false;
                }
            }
            return true;

        }


        private int[][] rotate(int[][] arr, int degree) {

            int n = arr.length;
            int[][] rotate = new int[n][n];

            System.out.println(degree + " ");

            for (int i = 0; i < rotate.length; i++) {
                for (int j = 0; j < rotate[i].length; j++) {
                    System.out.print(arr[i][j] + " ");
                    switch (degree) {
                        case 90:
                            rotate[i][j] = arr[n - 1 - j][i];
                            break;
                        case 180:
                            rotate[i][j] = arr[n - 1 - i][n - 1 - j];
                            break;
                        case 270:
                            rotate[i][j] = arr[j][n - 1 - i];
                            break;
                        case 360:
                            rotate[i][j] = arr[i][j];
                            break;
                        default:
                            rotate[i][j] =arr[i][j];
                            break;
                    }
                }
                System.out.println();
            }
            System.out.println("after");
            for (int i = 0; i < rotate.length; i++) {
                for (int j = 0; j < rotate[i].length; j++) {
                    System.out.print(rotate[i][j] + " ");

                }
                System.out.println("");
            }
            return rotate;
        }

    }
}
