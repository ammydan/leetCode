package everyday;


/***
 * middle 309
 * 看着题目描述就知道要使用DP(因为涉及了子问题和遍历的问题）
 * 1、自己的想法
 * 我想了很久都没想出来合适的状态方程，只是想着既然需要休息一天，那么我是不是可以把以某个结尾的作为分界点。
 * 但是以结尾作为分界点的话，还需要考虑从哪一天买入的情况，不能直接沿用起始位置了；哪怕考虑了起始和终止的位置，我们也只能算一次的买入和卖出。
 * 可能在这个范围中出现多次买入和卖出或者根本没有买入卖出。
 * 因此可能想着某个结尾来区分的思路就不对。——然后就卡住了。
 * 2、参考思路
 * ①直接记录所有的情况
 * 外层是从第i天购入,内层是到j卖出。opt记录是从第0天到j天的最优解，因为opt本身是实时更新的，因为后面加上了前面几次的购买和卖出的钱。
 * 时间复杂度O(n^2)
 * 空间复杂度O(n)
 * ②增加状态
 * 分为三个状态：持有股份、冻结期、没有股份。
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 * ③提升空间使用
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 * */
public class BestTimetoBuyandSellStockwithCooldown {
    public int maxProfix(int[] prices) {
//        1、参考思路1：最初版DP
//        int len = prices.length;
//        if (len == 0) return 0;
//        int[] opt = new int[len];
//        int ans = 0;
//        for (int i = 0; i < len; i++) {
//            if(i>0)opt[i] = Math.max(opt[i],opt[i-1]);
//            for (int j = i + 1; j < len; j++) {
//                if (i - 2 < 0) {
//                    opt[j] = Math.max(opt[j], prices[j] - prices[i]);
//                } else {
//                    opt[j] = Math.max(opt[j], opt[i - 2] + prices[j] - prices[i]);
//                }
//                ans = Math.max(ans, opt[j]);
//            }
//        }
//        return ans;
//        2、参考思路2：升级版本
//        int len = prices.length;
//        if(len==0)return 0;
//        int[][] opt = new int[len][3];
//        for(int i=0;i<len;++i){
//            if(i==0){
//                opt[i][2] = -prices[i];
//                continue;
//            }else if(i==0){
//                opt[i][1] = opt[i-1][2]+prices[i];
//                opt[i][2] = Math.max(opt[i-1][0]-prices[i],opt[i-1][2]);
//            }
//            opt[i][0] = Math.max(opt[i-1][1],opt[i-1][0]);
//            opt[i][1] = opt[i-1][2]+prices[i];
//            opt[i][2] = Math.max(opt[i-1][2],opt[i-1][0]-prices[i]);
//            continue;
//        }
//        return Math.max(opt[len-1][0],opt[len-1][1]);
//        3、DP最终版本：空间优化
        int len = prices.length;
        if(len<=1)return 0;
        int state1, state2,state3;
        state1 = 0;
        state2 = prices[1]-prices[0];
        state3 = Math.max(-prices[0],-prices[1]);
        int newState1, newState2, newState3;
        for(int i=2;i<len;++i){
            newState1 = Math.max(state2,state1);
            newState2 = state3+prices[i];
            newState3 = Math.max(state3,state1-prices[i]);
            state1 = newState1;
            state2 = newState2;
            state3 = newState3;
        }
        return Math.max(state1,state2);
    }
    public static void main(String[] args) {
        BestTimetoBuyandSellStockwithCooldown test = new BestTimetoBuyandSellStockwithCooldown();
        test.maxProfix(new int[]{6,1,6,4,3,0,2});
    }
}
