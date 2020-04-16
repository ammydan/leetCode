package easy;

public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] L = new int[prices.length+1];
        int[] P = new int[prices.length+1];
        L[0] = Integer.MAX_VALUE;
        P[0] = 0;
        for(int i=1;i<=len;i++){
            L[i] = Math.min(L[i-1],prices[i-1]);
            P[i] = Math.max(P[i-1],prices[i-1]-L[i]);
        }
        return P[len];
    }

}
