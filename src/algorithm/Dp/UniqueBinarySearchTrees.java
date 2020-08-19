package algorithm.Dp;

/**
 * 96 middle
 *1、 自己的想法
 * 一开始就陷入了分层计算的泥沼里，然后其实有想到是不是要拿取其中一个数，然后分开计算个数，随后自己抛弃想法觉得肯定超时了。
 * 但是其实按照树的定义，每个子树都可以是另起的一棵树，完全可以重复利用，记忆方法即可。
 * 2、参考思想
 * ①动态规划：从要其中选一个作为根节点，然后分成两边相乘然后累加不同点作为根节点的个数来计算。
 * */
public class UniqueBinarySearchTrees {
    public int numTrees(int n){
        int[] record = new int[n+1];
        record[0] = 1;
        record[1] = 1;
        for(int size=2;size<=n;size++){
            for(int i=1;i<=size;i++){
                record[size] += record[i-1]*record[size-i];
            }
        }
        return record[n];
    }
}
