package everyday;
/**
 * middle 96
 * 没啥好说的，直接中间分开，然后左右两侧都分为小的。
 * */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] opt = new int[n + 1];
        opt[0] = 1;
        for (int nums = 1; nums <= n; nums++) {
            for (int i = 1; i <= nums; i++) {
                int left = i - 1;
                int right = nums - i;
                opt[nums] += (opt[left] * opt[right]);
            }
        }
        return opt[n];
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees test = new UniqueBinarySearchTrees();
        test.numTrees(3);
    }
}
