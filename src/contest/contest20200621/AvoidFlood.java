package contest.contest20200621;

import java.util.*;

/**
 * 一开始看到题目的时候，第一反应就是要推迟抽水策略，毕竟你要抽水还要看哪个湖满了并且不抽就要溢出来了。
 * 但是当时做题的我忽略了很重要的地方，那就是抽水的环境信息（抽水的日期不能早于湖满的日期），所以试了两次都有错误答案，这里写下题解来完善我的方法。
 *1、自己思路
 * ①我们当然要准备一个数据结构来保存抽水的日期（因为我们无法当时就做出决策，必须保留这个信息）candidates,我用的是LinkedList。
 * ②我们还需要保存水涨的湖水号码以及对应的涨水日期（日期用来和抽水日期作比较）map，因为我们待会儿是会按照日期顺序遍历各个序号湖水降雨，所以我们需要通过湖水序号快速找到降雨的日期。
 * ③我们遍历rains,并有以下逻辑：
 *      1)如果rains[i]>0
 *          Ⅰ如果已经涨水，那么我们需要从candidates中寻找是否可以解决的方案，如果有则更新我们的ans[i]=-1;ans[index]=rains[i]以及map并且删除相应的抽水日期，没有就返回空数组。（index为所找到的抽水日期）
 *          Ⅱ如果没有涨水，那么我们只需要更新map和ans[i]=-1.
 *      2)如果rains[i]==0
 *          我们在candidates添加一个新的日期。
 *
 * **/
public class AvoidFlood {
    public int[] avoidFlood(int[] rains){
//        准备好数据结构
        int[] ans = new int[rains.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        LinkedList<Integer> candidates = new LinkedList<>();
//        这里填充，是因为答案中不允许出现<=0的值，所以对于那些没有用到的抽水日期，随意填充>0的数字即可。
        Arrays.fill(ans,1);

//        遍历rains
        for(int i=0;i<rains.length;i++){
//            判断是否是下雨的日子
            if(rains[i]>0){
//                判断该湖是否已经涨水
                if(map.containsKey(rains[i])){
//                    判断是否有解决方法
                    int tempIndex = 0;
                    if((tempIndex=hasSolution(candidates,map.get(rains[i])))<0)return new int[0];
                    else{
                        ans[tempIndex] = rains[i];
                        map.put(rains[i],i);
                        ans[i] = -1;
                    }
                }else{
                    map.put(rains[i],i);
                    ans[i] = -1;
                }
            }else{
                candidates.add(i);
            }
        }
        return ans;
    }
    private int hasSolution(LinkedList candidates, int index){
        if(candidates.size()==0)return -1;
        ListIterator iterator = candidates.listIterator();
//        这里的顺序是有讲究的，抽水的日子越在后面，那么这个抽水的日子越好（因为能抽水的湖越多，例如，你抽水日子在第一天，那么这是完全没有用的，因为那时候根本没有湖涨水）.
//        因此，我们需要从前到后寻找（其实这里直接二分法就可，因为返回的序号刚好是比对应值大一点或者相等的值的序号。)
        while(iterator.hasNext()){
            int i = (int) iterator.next();
            if(i>index){
                iterator.remove();
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        AvoidFlood test = new AvoidFlood();
//        int[] nums = {10,20,20};
        int[] nums = {69,0,0,0,69};
//        int[] nums = {1,2,0,0,2,1};
//        int[] nums = {1,0,2,0};
//        int[] nums = {0,1,1};
//        int[] nums = {1,0,2,3,0,1,2};
        int[] ans = test.avoidFlood(nums);
        System.out.println(Arrays.toString(ans));
        int[] array = {1,3,4,7,9,12,15};
        int i = Arrays.binarySearch(array,8);
        System.out.println(-i-1);

    }

}
