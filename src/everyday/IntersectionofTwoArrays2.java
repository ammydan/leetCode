package everyday;

import java.util.Arrays;
import java.util.LinkedList;
/**
 * easy 350
 * 1、自己的想法
 * 排序统计，这个真的没啥好说的。
 * 时间复杂度：O(nlogn+mlogm)
 * 空间复杂度：O(n+m)
 * 2、参考思路
 * ①哈希列表
 * 时间复杂度：O(n+m)
 * 空间复杂度：O(n)
 * */
public class IntersectionofTwoArrays2 {
    public int[] intersect(int[] nums1, int[]nums2){
//        int len1 = nums1.length;
//        int len2 = nums2.length;
//        int max1 = 0;
//        int start1 = -1;
//        for(int i=len1-1;i>=0;i--){
//            int len = Math.min(len1-i,len2);
//            int tempMax = 0;
//            int tempStart = i;
//            for(int j=0;j<len;j++){
//                if(nums1[i+j]==nums2[j])tempMax++;
//                else{
//                    if(tempMax>max1){
//                        max1 = tempMax;
//                        start1 = tempStart;
//                        tempStart = i+j+1;
//                    }
//                }
//            }
//            if(tempMax>max1){
//                max1 = tempMax;
//                start1 = tempStart;
//            }
//        }
//        int max2 = 0;
//        int start2 = -1;
//        for(int i=len2-1;i>=0;i--){
//            int len = Math.min(len2-i,len1);
//            int tempMax = 0;
//            int tempStart = i;
//            for(int j=0;j<len;j++){
//                if(nums2[i+j]==nums1[j])tempMax++;
//                else{
//                    if(tempMax>max2){
//                        max2 = tempMax;
//                        start2 = tempStart;
//                        tempStart = i+j+1;
//                    }
//                }
//            }
//            if(tempMax>max2){
//                max2 = tempMax;
//                start2 = tempStart;
//            }
//        }
//        int[] ans;
//        if(max1>max2){
//            ans = new int[max1];
//            int j=0;
//            for(int i = start1;i<start1+max1;i++){
//                ans[j++] = nums1[i];
//            }
//        }else{
//            ans = new int[max2];
//            int j=0;
//            for(int i = start2;i<start2+max2;i++){
//                ans[j++] = nums2[i];
//            }
//        }
//        return ans;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len = Math.min(nums1.length,nums2.length);
        int[] ans;
        LinkedList<Integer> list = new LinkedList<>();
        int i=0,j=0, index=0;
        while(i<nums1.length&&j<nums2.length)
        {
            if(nums1[i]==nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i]>nums2[j])j++;
            else i++;
        }
        ans = new int[list.size()];
        i = 0;
        for(int num: list){
            ans[i++] = num;
        }
        return ans;
    }

    public static void main(String[] args) {
        IntersectionofTwoArrays2 test = new IntersectionofTwoArrays2();
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        test.intersect(nums1,nums2);
    }
}
