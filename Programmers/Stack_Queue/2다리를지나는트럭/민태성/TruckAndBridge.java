import java.util.LinkedList;
import java.util.Queue;

public class TruckAndBridge {
    public static void main(String[] args) {
        int[] tw = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10,};
        System.out.println(new Solution().solution(100, 100, tw));
    }

    static class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {

            int bridgeWeight = 0;

            Queue<Truck> bridge = new LinkedList<>();
            Queue<Truck> trucks = new LinkedList<>();

            for (int i = 0; i < truck_weights.length; i++)
                trucks.add(new Truck(truck_weights[i], 0));

            int current = 0;
            while (true) {

                current++;

                if (!bridge.isEmpty()) {
                    Truck firstTruck = bridge.peek();

                    if (current - firstTruck.getLen() == bridge_length) {
                        bridgeWeight -= firstTruck.getWeight();
                        bridge.poll();
                    }
                    if (bridgeWeight == 0)
                        return current;

                }
                if (!trucks.isEmpty()) {
                    Truck firstTruck = trucks.peek();

                    if (bridgeWeight + firstTruck.getWeight() <= weight) {

                        firstTruck = trucks.poll();

                        bridgeWeight += firstTruck.getWeight();

                        bridge.add(new Truck(firstTruck.getWeight(), current));
                    }
                }


            }

        }

    }

    static class Truck {
        private int weight;
        private int len;

        public Truck(int weight, int len) {
            this.weight = weight;
            this.len = len;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getLen() {
            return len;
        }

        public void setLen(int len) {
            this.len = len;
        }
    }
}
