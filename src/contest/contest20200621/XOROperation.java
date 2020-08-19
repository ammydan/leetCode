package contest.contest20200621;

public class XOROperation {
    public int xorOperation(int n, int start){
        int[] nums = new int[n];
        int ans=0;
        for(int i=0;i<n;i++){
            nums[i] = start+2*i;
        }
        ans = nums[0];
        for(int i=1;i<n;i++){
            ans^=nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        XOROperation test = new XOROperation();
        int x = test.xorOperation(1000,1000);
        System.out.println(x);
    }
}
