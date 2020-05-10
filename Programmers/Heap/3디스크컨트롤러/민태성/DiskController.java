import java.util.*;

public class DiskController {
    public static void main(String[] args) {
        int[][] job = {{0, 3}, {1, 9}, {500, 6}};
        int[][] jobs = {{1, 9}, {1, 4}, {1, 5}, {1, 7}, {1, 3}}; // 13
        int[][] j = {{0, 3}, {4, 3}, {10, 3}}; // 3 + 3 + 3

        Solution s = new Solution();
        System.out.println(s.solution(job));
    }

    static class Solution {
        public class Job implements Comparable<Job> {
            int start;
            int workTime;

            public Job(int start, int time) {
                this.start = start;
                this.workTime = time;
            }

            public int getWorkTime() {
                return workTime;
            }

            //걸리는 소요시간이 짧을수록, 시작 시간이 짧을 수록 우선수위를 높게함
            @Override
            public int compareTo(Job o) {
                if (this.start < o.start) return -1;
                else if (this.start == o.start) {
                    if (this.workTime < o.workTime) return -1;
                    else return 1;
                } else return 1;
            }
        }


        public int solution(int[][] jobs) {
            int answer = 0;
            PriorityQueue<Job> q = new PriorityQueue<>();
            Queue<Integer> disk = new LinkedList<>();

            PriorityQueue<Job> waiting = new PriorityQueue<>(new Comparator<Job>() {
                @Override
                public int compare(Job o1, Job o2) {
                    if (o1.workTime < o2.workTime) return -1;
                    else
                        return 1;
                }
            });

            int i = 0, idx = 0, size = 0;

            for (i = 0; i < jobs.length; i++) {
                size += jobs[i][1];
                q.add(new Job(jobs[i][0], jobs[i][1]));
            }


            i = 0;
            while (true) {
                System.out.println("i = " + i);
                if (q.size() > 0 && q.peek().start == i) {
                    Job job = q.poll();
                    System.out.println(i + "요청시간 waiting add");
                    waiting.add(job);
                    if (!q.isEmpty() && q.peek().start == i) continue;
                }
                if (!disk.isEmpty()) {
                    System.out.println("디스크 작업 함");
                    disk.add(disk.poll() - 1);
                    answer++;
                    if (disk.peek() == 0) {
                        System.out.println("작업중인 디스크 작업이 0이되었습니다.");
                        disk.poll();

                        if (!waiting.isEmpty()) {
                            System.out.println("디스크 작업이 0이므로 새로운 작업리스트를 가져와서 디스크에 넣습니다.");
                            Job job = waiting.poll();
                            System.out.println(job.workTime);
                            disk.add(job.workTime);
                        }
                    }
                    if (!waiting.isEmpty()) {
                        answer += waiting.size();
                    }

                } else {
                    if (!waiting.isEmpty()) {
                        Job job = waiting.poll();
                        System.out.println("disk에 waiting 맨 처음꺼 빼서 넣음" + job.workTime);
                        disk.add(job.workTime);
                    }
                }
                i++;
                if (q.size() == 0 && disk.isEmpty()) {
                    break;
                }

            }

            System.out.println(answer);
            return answer / jobs.length;
        }
    }


}
