import java.util.*;
public class HIndex {
    public static void main(String[] args) {
        Solution s = new Solution();
        int arr[] = {3,0,6,1,5};
        System.out.println(s.solution(arr));
    }

    static class  Solution {
        public int solution(int[] citations) {
            int answer = 0;
            int h;
            Arrays.sort(citations);

            for(int i =0 ; i <citations.length ; i++){
                h =0;
                for(int j = 0 ; j< citations.length;j++){
                    if(i <= citations[j]) h++;
                }
                if( i >=citations.length-h && i <= h )
                    answer = i;
            }

            return answer;
        }
    }
}
