import sun.security.krb5.internal.Ticket;

public class TravelRoute {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String []answer= s.solution(tickets);
        for(int i =0 ; i <answer.length;i++)
            System.out.print(answer[i]+ " ");
    }

    static class Solution {
        public static String[] solution(String[][] tickets) {

            String[] answer = new String[tickets.length+1];

            Ticket []ticketList = new Ticket[tickets.length];

            for(int i = 0 ; i < tickets.length; i++){
                ticketList[i] = new Ticket(tickets[i][0],tickets[i][1],false);
            }

            dfs(answer,ticketList,"ICN",0);


            return answer;
        }

        private static void dfs(String[] answer, Ticket[] ticketList, String to , int idx) {

            if(idx == answer.length){
                return ;
            }
            for(int i = 0 ; i < ticketList.length ; i++){
                if(to == to)return;
            }


        }

    }

    static class Ticket{
        private String from;
        private String to;
        private boolean visiited;

        public Ticket(String from, String to, boolean visiited) {
            this.from = from;
            this.to = to;
            this.visiited = visiited;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public boolean isVisiited() {
            return visiited;
        }

        public void setVisiited(boolean visiited) {
            this.visiited = visiited;
        }
    }
}
