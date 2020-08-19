package dataStructure.segmenTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings){
//        int len = buildings.length;
//        List<List<Integer>> ans = new LinkedList<>();
//        if(len==0)return ans;
//        if(len==1){
//            List<Integer> list = new LinkedList<>();
//            list.add(buildings[0][0]);
//            list.add(buildings[0][1]);
//            ans.add(list);
//        }
//        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
//        int height = 0;
//        int left = buildings[0][0];
//        int right = 0;
//        for(int i=0;i<len;i++){
//            while(i<len&&left==buildings[i][0]){
//                if(buildings[i][2]>height){
//                    if(buildings[i][1]<right){
//                        int[] temp = new int[2];
//                        temp[0] = right;
//                        temp[1] = height;
//                        pq.add(temp);
//                        right = buildings[i][1];
//                        height = buildings[i][2];
//                    }
//                }else if(buildings[i][1]>right){
//                    int[] temp = new int[2];
//                    temp[0] = buildings[i][1];
//                    temp[1] = buildings[i][2];
//                    pq.add(temp);
//                }
//                i++;
//            }
//        }
    }
}
