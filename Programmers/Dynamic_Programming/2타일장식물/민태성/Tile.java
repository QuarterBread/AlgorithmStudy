import java.util.ArrayList;

public class Tile {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution(6));
    }

    static class Solution {
        public long solution(int N) {
            long answer = 0;

            long nextTile;

            ArrayList<Long> tiles = new ArrayList<>();
            long tmp  =1;
            tiles.add(tmp);
            tiles.add(tmp);

            while (tiles.size() != N) {
                nextTile = tiles.get(tiles.size()-2)+ tiles.get(tiles.size()-1);
                tiles.add(nextTile);
            }
            answer = tiles.get(N-1) * 4 + tiles.get(N-2)*2;


            return answer;
        }

    }
}
