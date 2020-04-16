package easy;
/**
 * We are supposed to consider the array range when we want we abtain the value of an array.
 *
 * ***/
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int total = m+n;
        int mPointer=m-1;
        int nPointer=n-1;
        int i=total-1;
        while(i>=0){
            while(mPointer>=0&&nPointer>=0&&nums1[mPointer]>=nums2[nPointer]){
                nums1[i--]=nums1[mPointer];
                mPointer--;
            }
            while(mPointer<0&&nPointer>=0&&nPointer>=0)nums1[i--]=nums2[nPointer--];
            while(nPointer>=0&&nums1[mPointer]<nums2[nPointer]){
                nums1[i--]=nums2[nPointer];
                nPointer--;
            }
            while(nPointer<0&&mPointer>=0)nums1[i--]=nums1[mPointer--];
        }
    }

    public static void main(String[] args) {
        MergeSortedArray test = new MergeSortedArray();
//        int[] nums1 = {1,2,3,0,0,0};
//        int[] nums2 = {2,5,6};
//        test.merge(nums1, 3,nums2,3);
        int[] nums1 = {1};
        int[] nums2 = {};
        test.merge(nums1, 1,nums2,0);
        System.out.println("hi");
    }
}
