package contest.contest20200705;

import java.util.Arrays;

public class CanMakeArithmeticProgression {
    public boolean canMakeArithmeticProgression(int[]arr){
        int len = arr.length;
        if(len<=1)return true;
        Arrays.sort(arr);
        int delta = arr[1]-arr[0];
        for(int i=2;i<len;i++){
            if(arr[i]-arr[i-1]!=delta)return false;
        }
        return true;
    }
}
