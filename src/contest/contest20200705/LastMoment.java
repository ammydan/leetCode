package contest.contest20200705;
/**
 * middle 1503
 * 1、自己想法
 * 模拟，但是要记录的信息太多了，怎么看都得是一道hard题。
 * 2、参考思路
 * 两只蚂蚁逆向而行，碰到一起都改变方向，就相当于穿透！！！！
 *
 * 555555555，流下了无知得泪水。
 * */

public class LastMoment {
    public int getLastMoment(int n, int[]left, int[]right){
        int ans = 0;
        for(int i = 0;i<left.length;i++){
            ans = Math.max(ans,left[i]);
        }
        for(int i = 0;i<right.length;i++){
            ans = Math.max(ans,n-right[i]);
        }
        return ans;
    }
}
