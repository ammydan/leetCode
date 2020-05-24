package sort;

import middle.LongestIncreasingSubsequence;

import java.util.*;

/****
 * middle 面试题
 * 这道题是在最长递增子序列上进行拓展。
 * 先按升高排序，次按体重排序。
 * 然后按照体重选择查找最长递增子序列。
 * 这道题栽在了比较的实现上面，耽误了超多的时间，发现错误的时候气得吐血。
 * **/
public class CircusTowerLCCI {
    public int bestSeqAtIndex(int[] height, int[] weight) {
        int len = height.length;
        if(len==0)return 0;
        if(len<=1) return 1;
        ArrayList<Pair> list = new ArrayList<>();
        for(int i=0;i<len;i++){
            Pair temp = new Pair(height[i],weight[i]);
            list.add(temp);
        }

        Collections.sort(list);
        int[] tail = new int[len];
        int j=0;
//        tail[0] = list.get(0).getWeight();
        for(int i=0;i<len;i++){
//            if(tail[j]<list.get(i).getWeight())tail[++j] = list.get(i).getWeight();
//            else{
//                int index = Arrays.binarySearch(tail,0,j,list.get(i).getWeight());
//                if(index<0)tail[-index-1] = list.get(i).getWeight();
//            }
            int index = Arrays.binarySearch(tail,0,j,list.get(i).getWeight());
            if(index<0)index = -index-1;
            tail[index] = list.get(i).getWeight();
            if(j==index)j++;
        }
        return j;
    }

    public class Pair implements Comparable<Pair>
    {
        private int height;
        private int weight;
        public Pair(int height, int weight){
            this.height = height;
            this.weight = weight;
        }
        public int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Pair o) {
//            if(height>o.height)return 1;
//            else if(height<o.height)return -1;
//            else if(weight<o.weight)return 1;
//            else if(weight>o.height) return -1;
//            return 0;
            if (height == o.height) {
                return o.weight - weight;
            }
            return height - o.height;
        }

        @Override
        public String toString() {
            return height+","+weight+" ";
        }
    }


}





