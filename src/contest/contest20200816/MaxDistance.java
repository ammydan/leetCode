package contest.contest20200816;

import java.util.Arrays;

public class MaxDistance {
    public int maxDistance(int[] position, int m){
        int len = position.length;
        if(len<=1)return 0;
        if(len==2)return Math.abs(position[0]-position[1]);
        Arrays.sort(position);
        int low = 1, high =position[len-1]-position[0];
        int ans = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(canFinish(position,mid,m)){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
    private boolean canFinish(int[] position, int distance, int m){
        int nums = 1;
        int pre = position[0];
        int len = position.length;
        for(int i =1;i<len;i++){
            if(position[i]-pre<distance)continue;
            nums++;
            if(nums>=m)return true;
            pre = position[i];
        }
        return nums>=m;
    }

    public static void main(String[] args) {
        MaxDistance test = new MaxDistance();
        int[] positions = {5,4,3,2,1,1000000000};
        test.maxDistance(positions,2);
    }


}
