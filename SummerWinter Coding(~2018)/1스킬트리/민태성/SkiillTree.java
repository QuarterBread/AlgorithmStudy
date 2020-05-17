package Kakao2019Winter;

public class SkiillTree {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skilltrees = {"BACDE", "CBADF", "AECB", "BDA"};

        Solution s = new Solution();
        System.out.println(s.solution(skill, skilltrees));
    }

    static class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = skill_trees.length;
            int idx = 0;
            int max = skill.length();

            for (int i = 0; i < skill_trees.length; i++) {
                String s = skill_trees[i];
                System.out.println(i+1+"번째 스킬 트리" + s);
                for (int j = 0; j < s.length(); j++) {
                    char preSkill = skill.charAt(idx);
                    String temp = s.charAt(j) + "";
                    System.out.println("사전에 배워야하는 스킬 =" +preSkill);
                    System.out.println("배우고 싶은 스킬 = " + temp);
                    // 인덱스가 스킬트리의 순서일경우
                    if (s.charAt(j) == preSkill ) {
                        System.out.println("사전에 배워야하는 스킬이 맞음");
                        if(idx < skill.length()-1)
                            idx++;
                    }//  스킬트리긴 한데 순서가 맞지않은 경우
                    else if (skill.indexOf(temp) >= 0) {
                        System.out.println("사전에 배워둬야하는 스킬이 있어야하는데 현재는 아님 고로 이주문은 배울수 없음");
                        answer -= 1;
                        break;
                    }// 스킬트리 관련 스킬이 아닌경우 일반스킬일경우
                    else {
                        System.out.println("배우고 싶은 스킬이 일반 주문이므로 다음 주문을 배우러 간다");
                        continue;
                    }

                }
                idx=0;

            }
            return answer;
        }
    }
}
