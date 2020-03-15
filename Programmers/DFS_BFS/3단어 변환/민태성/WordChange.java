public class WordChange {
    public static void main(String[] args) {
        Solution s = new Solution();
       // String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        String[] words = {"hhh","hht"};
        int answer = s.solution("hit", "hhh", words);
        System.out.println(answer);
    }

    static class Solution {
        int res;
        public int solution(String begin, String target, String[] words) {
            boolean[] visited = new boolean[words.length];
            res= words.length;
            dfs(begin, target, words,visited,0);
            return res;
        }

        public void dfs(String begin, String target, String[] words,boolean[] visited,int depth) {

            if (begin == target) {
                if(depth <res)
                    res= depth;
            } else {
                int wordsCnt;
                for (int i = 0; i < words.length; i++) {
                    if(!visited[i]) {
                        wordsCnt = 0;
                        for (int j = 0; j < begin.length(); j++) {
                            if (begin.charAt(j) == words[i].charAt(j))
                                wordsCnt++;
                        }
                        if ((begin.length() - wordsCnt) == 1) {
                            visited[i]= true;
                            boolean []visit = new boolean[words.length];
                            for(int k = 0 ; k < words.length; k++) {
                                if (visited[k])
                                    visit[k] = true;
                            }
                            dfs(words[i], target, words,visit,depth+1);
                        }
                    }
                }
            }
        }
    }

}
