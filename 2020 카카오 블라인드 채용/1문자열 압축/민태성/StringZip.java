package Kakao2020Blind;

public class StringZip {
    public static void main(String[] args) {
        String s = "aabbaccc";
        String s2 = "xababcdcdababcdcd";

        Solution solution = new Solution();
        System.out.println(solution.solution(s2));
    }

    static class Solution {
        public int solution(String s) {
            int answer = 0, unit = 1, strLen = s.length();
            String str = "";
            StringBuilder sb = new StringBuilder();
            while (unit != s.length()) {
                int charCnt = 1;
                System.out.println("자르는 단위 : " + unit);
                for (int i = 0; i < s.length(); i = i + unit) {
                    if (i + unit > s.length()) {
                        String remainStr = s.substring(i,s.length());
                        sb.append(remainStr);
                        break;
                    }
                    String t = s.substring(i, i + unit);
                    // System.out.println("unit = " + unit  + " , " + t);
                    int nextIdx = i + unit;
                    // System.out.println("unit = " + unit  + " , " + s.substring(nextIdx,nextIdx+unit));
                    System.out.println("cur idx = " + i + " , 잘린 문자열 =" + t + " , next idx = " + nextIdx);
                    if (nextIdx < s.length() && check(nextIdx, unit, s) && t.equals(s.substring(nextIdx, nextIdx + unit))) {
                            charCnt++;
                            System.out.println("charCnt = " + charCnt);
                            continue;

                    } //짝이 맞지않을경우 나머지 다 append
                    else{ // 짝이 맞을때
                        if (charCnt > 1) {
                            sb.append(charCnt);
                            sb.append(t);
                            charCnt = 1;
                        } else
                            sb.append(t);
                    }
                }
                str = sb.toString();
                System.out.println("압축된 문자열 = " + str);
                if (strLen > str.length())
                    strLen = str.length();
                unit++;
                sb = new StringBuilder();
            }
            answer = strLen;
            return answer;
        }

        //nextIdx에서 subString을 할수 있는지 검증
        public boolean check(int nextIdx, int unit, String s) {

            int nu = nextIdx + unit;
            if (nu <= s.length())
                return true;
            else return false;
        }

    }
}
