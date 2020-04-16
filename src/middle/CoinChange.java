package middle;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int bestCost[] = new int[amount+1];
        int len = coins.length;
        bestCost[0] = 0;
        for(int i=1;i<=amount;i++){
            bestCost[i] = Integer.MAX_VALUE;
        }
        for(int i=1;i<=amount;i++){
            for(int j=0;j<len;j++){
                if(i>=coins[j]&&bestCost[i-coins[j]]<Integer.MAX_VALUE){
                    bestCost[i] = bestCost[i]<=maxPlusOne(bestCost[i-coins[j]])?bestCost[i]:maxPlusOne(bestCost[i-coins[j]]);
                }
            }
        }
        if(bestCost[amount]==Integer.MAX_VALUE) return-1;
        return bestCost[amount];

    }
    private int maxPlusOne(int origin){
        if(origin==Integer.MAX_VALUE)return Integer.MAX_VALUE;
        return origin+1;
    }

    public static void main(String[] args) {
        CoinChange test = new CoinChange();
        int[] coins = {186,419,83,408};
        System.out.println(test.coinChange(coins,6249));
//        System.out.println(Integer.MIN_VALUE+1);
    }
}
