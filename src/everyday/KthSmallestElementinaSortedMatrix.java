package everyday;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementinaSortedMatrix {
    public int kthSmallest(int[][]matrix, int k){
//        1、参考方法①：归并
//        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0]-o2[0];
//            }
//        });
//        int len = matrix.length;
//        for(int i = 0;i<len;i++){
//            pq.add(new int[]{matrix[i][0],i,0});
//        }
//        for(int i=0;i<k-1;i++){
//            int[] current = pq.remove();
//            if(current[2]<len-1){
//                pq.add(new int[]{matrix[current[1]][current[2]+1],current[1],current[2]+1});
//            }
//        }
//        return pq.peek()[0];
//        2、参考方法②：找规律
        int len = matrix.length;
        int max = matrix[len-1][len-1];
        int min = matrix[0][0];
        while(min<max){
            int mid = min+((max-min)>>1);
            if(check(matrix,k,mid)){
                max = mid;
            }else{
                min = mid+1;
            }
        }
        return min;

    }
    private boolean check(int[][]matrix, int k, int mid){
        int i = matrix.length-1;
        int j = 0;
        int num = 0;
        while(i>=0&&j<matrix.length){
            if(matrix[i][j]<=mid){
                num = num+i+1;
                j++;
            }else{
                i--;
            }
        }
        return num>=k;
    }

    public static void main(String[] args) {
       KthSmallestElementinaSortedMatrix test = new KthSmallestElementinaSortedMatrix();
        int[][]matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}};
//        int[][]matrix = {
//                {1,2},
//                {1,3}
//        };
//        int [][]matrix ={
//                {1,2},{1,3}
//        };
        int i = test.kthSmallest(matrix,8);
        System.out.println(i);
    }
}
