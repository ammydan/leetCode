package contest.contest20200816;

import java.util.Arrays;
import java.util.HashMap;

/**
 * hard 1553
 * 这道题是比较简单的DP题目，但是关键在于空间的限制。
 * 限制了空间，说明我们只能减少一些状态，那么哪些状态需要删减了（即永远不能到达最优的路径进行剪枝）
 * 可能有贪心算法。
 * */
public class MinDays {
    HashMap<Integer,Integer> map = new HashMap<>();
    public int minDays(int n){
//        int len = n;
//        int[][] opt = new int[len+1][3];
//        for(int i=0;i<=len;i++){
//            Arrays.fill(opt[i],Integer.MAX_VALUE);
//        }
//        Arrays.fill(opt[0],0);
//        for(int i=1;i<=len;i++){
//            if(i>=2&&i%2==0){
//                int pre = i-i/2;
//                opt[i][1] = Math.min(opt[i][1],opt[pre][0]+1);
//                if(pre!=0&&pre%2==0) opt[i][1] = Math.min(opt[i][1],opt[pre][1]+1);
//                if(pre!=0&&pre%3==0) opt[i][1] = Math.min(opt[i][1],opt[pre][2]+1);
//            }
//            if(i>=3&&i%3==0){
//                int pre = i-i*2/3;
//                opt[i][2] = Math.min(opt[i][2],opt[pre][0]+1);
//                if(pre!=0&&pre%3==0) opt[i][2] = Math.min(opt[i][2],opt[pre][2]+1);
//                if(pre!=0&&pre%2==0) opt[i][2] = Math.min(opt[i][2],opt[pre][1]+1);
//            }
//            int p = i-1;
//            opt[i][0] = Math.min(opt[i][1],opt[p][0]+1);
//            if(p!=0&&p%3==0)opt[i][0] = Math.min(opt[i][0],opt[p][2]+1);
//            if(p!=0&&p%2==0)opt[i][0] = Math.min(opt[i][0],opt[p][1]+1);
//
//        }
//        int ans =Integer.MAX_VALUE;
//        for(int i=0;i<3;i++){
//            if(opt[len][i]==0)continue;
//            ans = Math.min(ans,opt[len][i]);
//        }
//        return ans;
//        超出了空间限制
//        if(n==0)return 0;
//        map.put(0,0);
//        for(int i=1;i<=n;i++){
//            map.put(i,map.get(i-1)+1);
//            if(i%2==0){
//                map.put(i,Math.max(map.get(i),map.get(i-i/2)+1));
//            }
//            if(i%3==0){
//                map.put(i,Math.max(map.get(i),map.get(i-2*(i/3))+1));
//            }
//        }
//        return map.get(n);
        return helper(n);

    }
    private int helper(int n){
        if(n==0)return 0;
        if(n==1)return 1;
        if(n==2) return 2;
        if(n==3)return 2;
        Integer ans = map.get(n);
        if(ans!=null)return ans;

        int m2 = helper(n/2)+n%2;
        int m3 = helper(n/3)+n%3;
        ans = Math.max(m2,m3)+1;
        return ans;
    }

    public static void main(String[] args) {
        MinDays test = new MinDays();
        test.minDays(1);
    }
}
