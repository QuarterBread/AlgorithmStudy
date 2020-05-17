package Kakao2019Winter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TakePicture {
    public static void main(String[] args) {
        String[] data = {"N~F=0", "R~T>2"}; // = , < , >
        int n = 2;
        Solution s = new Solution();
        System.out.println(s.solution(n, data));
    }


    static class Solution {
        static int answer = 0;
        static int[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
        static ArrayList<Character> member = null;

        public int solution(int n, String[] data) {

            member = new ArrayList<>();
            member.add('A');
            member.add('C');
            member.add('F');
            member.add('J');
            member.add('M');
            member.add('N');
            member.add('R');
            member.add('T');


            Permutation p = new Permutation(arr.length, 8);
            p.perm(arr, 0, data);

            return answer;
        }

        class Permutation {

            private int n; // nPr의 n
            private int r; // nPr의 r
            private int[] res;

            // 초기화
            public Permutation(int n, int r) {
                this.n = n;
                this.r = r;
                res = new int[r];
            }

            public void swap(int[] arr, int i, int j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

            public void perm(int[] arr, int depth, String[] data) {
                // depth가 0부터 시작했을 경우 depth == r에서 리턴
                if (depth == r) {
                    System.out.println(Arrays.toString(res));
                    int leftIdx = 0, rightIdx = 0;
                    for (int i = 0; i < data.length; i++) {
                        String dataStr = data[i];
                        for (int j = 0; j < 8; j++) {
                            if (member.get(res[j]) == dataStr.charAt(0))
                                leftIdx = j;
                            else if (member.get(res[j]) == dataStr.charAt(2))
                                rightIdx = j;
                        }
                        System.out.println(leftIdx + " , " + rightIdx);
                        int friend1_Idx = dataStr.charAt(0); //5
                        int friend2_Idx = dataStr.charAt(2); //2
                        char op;
                        int dist;
                        if (dataStr.length() == 5) {
                            op = dataStr.charAt(3);
                            dist = data[i].charAt(4) - '0';
                        }
                        else {
                            op = dataStr.charAt(4);
                            dist = data[i].charAt(6) - '0';
                        }
                        //  System.out.println("res length= "+ res.length);
                        int friendDist = Math.abs(leftIdx - rightIdx) - 1;
                        //  System.out.println(friendDist);
                        //  System.out.println("dist Condition = " + dist);

                        switch (op) {
                            case '=':
                                if (dist == friendDist) {
                                    System.out.println(Arrays.toString(res));
                                    break;
                                } else
                                    return;
                            case '>':
                                if (dist < friendDist)
                                    break;
                                else
                                    return;
                            case '<':
                                if (dist > friendDist)
                                    break;
                                else
                                    return;

                        }

                    }
                    System.out.println("gd");
                    answer++;
                    return;
                }

                for (int i = depth; i < n; i++) {
                    swap(arr, depth, i);     // 스왑
                    res[depth] = arr[depth]; // 선택된 원소 저장
                    perm(arr, depth + 1, data);     // 재귀호출
                    swap(arr, depth, i);     // 복원
                }
            }


        }
    }
}
