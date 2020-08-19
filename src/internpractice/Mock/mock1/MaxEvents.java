package internpractice.Mock.mock1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 1353 middle
 * 这道题其实是典型的贪心算法题目，为什么自己这么菜！！！！太难了！！！
 * */
public class MaxEvents {
//    class Event implements Comparable<Event>{
//        int start;
//        int end;
//        int period;
//        public Event(int start, int end){
//            this.start = start;
//            this.end = end;
//            period = end-start+1;
//        }
//
//        @Override
//        public int compareTo(Event o) {
//            if(this.end>o.end)return 1;
//            else if(this.end<o.end)return -1;
//            else if(this.period>o.period)return -1;
//            else if(this.period<o.period)return 1;
//            return 0;
//        }
//    }
    public int maxEvents(int[][] events){
//    自己的方法：复杂度O(n^2)超时了。
//        int len = events.length;
//        Event[] order = new Event[len];
//        for(int i=0;i<len;i++){
//            order[i] = new Event(events[i][0],events[i][1]);
//        }
//        Arrays.sort(order);
//        HashSet<Integer> set = new HashSet<>();
//        int ans = 0;
//        for(int i=0;i<len;i++){
//            for(int j = order[i].start;j<=order[i].end;j++){
//                if(!set.contains(j)){
//                    ans++;
//                    set.add(j);
//                    break;
//                }
//            }
//        }
//        return ans;
//        贪心+优先队列（这个方法需要考虑题目给的取值范围）
        int len = events.length;
        Arrays.sort(events,(o1,o2)->o1[0]-o2[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 0, day = 1, i=0;
        while(i<len||!pq.isEmpty()) {
//            添加候选会议
            while(i<len&&events[i][0]==day) {
                pq.add(events[i++][1]);
            }
//            清除过期会议
            while(!pq.isEmpty()&&pq.peek()<day){
                pq.remove();
            }
//            参加会议
            if(!pq.isEmpty()){
                pq.remove();
                ans++;
            }
            day++;
        }
        return ans;

    }

    public static void main(String[] args) {
        MaxEvents test = new MaxEvents();
        int[][] events = {{1,2},{2,3},{3,4},{1,2}};
        test.maxEvents(events);
    }
}
