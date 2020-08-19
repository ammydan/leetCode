package everyday;


/***
 * middle 1014
 * 1、自己的想法
 * 一开始当然是暴力破解O(n^2)，但是显然超时，如果只进行暴力破解其实应该只能算一个简单的题目.
 * 2、参考思路
 * 将原来的计算式子拆开，A[i]+i, A[j]-j。累计计算A[i]+i获取最大值与你选定j无关，只需要从头
 * 到尾直接遍历过去就行。
 * */
public class BestSightseeingPair {
    public int maxScoreSightseeingPair(int[] A){
        int maxPre = A[0];
        int maxAns = Integer.MIN_VALUE;
        for(int i=1;i<A.length;i++){
            int temp = A[i]-i;
            if(temp+maxPre>maxAns)maxAns = temp+maxPre;
            if(A[i]+i>maxPre)maxPre = A[i]+i;
        }
        return maxAns;
    }
}
