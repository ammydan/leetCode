package algorithm.monotonousStack;

import java.util.LinkedList;
import java.util.List;

public class CreateMaximumNumber {
    private int len1,len2,len;
    public int[] maxNumber(int[] nums1, int[] nums2,int k){
        this.len1 = nums1.length;
        this.len2 = nums2.length;
        this.len = len1+len2;
        int[] ans = new int[k];
        for(int i=0;i<=k;i++){
            if(len1<i||len2<k-i)continue;
            int a = i;
            int b = k-i;
            int[]A = getThelargeNumber(a,nums1);
            int[]B = getThelargeNumber(b,nums2);
            int[]C = merge(A,B);
            if(bigger(C,ans,0,k-1,0,k-1))ans = C;
        }
        return ans;
    }
    private int[]getThelargeNumber(int k, int []nums){
        if(k==0)return new int[0];
        int delete = nums.length-k;
        LinkedList<Integer> stack = new LinkedList<>();
        int len = nums.length;
        for(int i=0;i<len;i++){
            int x = nums[i];
            if(delete==0){
                stack.add(x);
                continue;
            }
            while(!stack.isEmpty()&&stack.peekLast()<x&&delete>0){
                stack.removeLast();
                delete--;
            }
            stack.add(x);
        }
        while(delete>0){
            delete--;
            stack.removeLast();
        }
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = stack.removeFirst();
        }
        return ans;
    }
    private int[] merge(int[] a, int[]b){
        int lenA = a.length;
        int lenB = b.length;
        int[] list = new int[lenA+lenB];
        int indexA=0,indexB=0,index=0;
        while(indexA<lenA||indexB<lenB){
            if(indexA>=lenA)list[index++] = b[indexB++];
            else if(indexB>=lenB)list[index++] = a[indexA++];
            else if(bigger(a,b,indexA,lenA-1,indexB,lenB-1)){
                list[index++] = a[indexA++];
            } else{
                list[index++] = b[indexB++];
            }
        }
        return list;
    }
    private boolean bigger(int[] A, int[]B,int startA,int endA,int startB,int endB){
        int lenA = endA-startA+1;
        int lenB = endB-startB+1;
        int len = lenA>lenB?lenB:lenA;
        for(int i=0;i<len;i++){
            if(A[startA+i]>B[startB+i])return true;
            else if(A[startA+i]<B[startB+i])return false;
        }
        if(len==lenA)return false;
        else if(lenA!=lenB)return true;
        return false;
    }

    public static void main(String[] args) {
        CreateMaximumNumber test = new CreateMaximumNumber();
//        int[] num1 = {3,4,6,5};
//        int[] num2 = {9,1,2,5,8,3};
//        int[] num1 = {6,7};
//        int[] num2 = {6,0,4};
//        int[] num1 = {8,6,9};
//        int[] num2 = {1,7,5};
        int[] num1 = {5,6,8};
        int[] num2 = {6,4,0};
        test.maxNumber(num1,num2,3);
    }
}
