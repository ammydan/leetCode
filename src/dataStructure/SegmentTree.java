package dataStructure;

/**
 * 使用数组建立的线段数组，需要足够大的空间，数组n的四倍（先向上取2的次方，然后再乘以2）
 * 从0开始算起
 * */
public class SegmentTree {
     Node[] tree;
    private final int size;
    private int[] array;
    private int max;
    private class Node{
        int sum;
        long tag;
        public Node(){

        }
        public Node(int sum, long tag){
            this.sum = sum;
            this.tag = tag;
        }
    }
    public SegmentTree(int size, int[]array){
        this.size = size;
        this.array = array.clone();

        this.max = size*4;
        this.tree = new Node[max];
        for(int i = 0;i<max;i++){
            this.tree[i] = new Node();
        }
        buildTree(0,size-1,0);
    }
    private void buildTree(int left, int right,int node){
        if(left==right){
            tree[node].sum = array[left];
            return;
        }
        int mid = left+(right-left)/2;
        int left_node = node*2+1;
        int right_node = node*2+2;
        buildTree(left, mid,left_node);
        buildTree(mid+1,right,right_node);
        tree[node].sum = tree[left_node].sum+tree[right_node].sum;
    }
//   单点修改
    public void update_tree(int left,int right,int node,int index, int val ){
        if(left==right){
            array[index] = val;
            tree[node].sum = val;
            return;
        }
        int mid = left+(right-left)/2;
        int left_node = node*2+1;
        int right_node = node*2+2;
        if(index>=left&&index<=mid){
            update_tree(left,mid,left_node,index,val);
        }else{
            update_tree(mid+1,right,right_node,index,val);
        }
        tree[node].sum = tree[left_node].sum+tree[right_node].sum;
    }
//    区域修改(lazy模式，如果修改区间包括了某一个区间，那么我们就先做一个标记，然后等到查询操作时再进行修改。）
    public void update_tree(int left ,int right,int node, int l, int r, int val){
        if(l<=left&&r>=right){
             tree[node].sum += (right-left+1)*val;
             tree[node].tag += val;
             return;
        }else{
            if(tree[node].tag!=0)pushDown(node,left,right);
            int mid = (left+right)>>1;
            if(r<=mid) update_tree(left,mid,(node<<1|1),l,r,val);
            if(l>=mid+1)update_tree(mid+1,right,((node<<1)+2),l,r,val);
            tree[node].sum = tree[node<<1|1].sum+tree[node<<1+2].sum;
        }
    }
    private void pushDown(int node, int left, int right){
        long val = tree[node].tag;
        int mid = (left+right)/2;
        int l = node<<1|1;
        int r = (node<<1)+2;
        tree[l].sum +=val*(mid-left+1);
        tree[l].tag = val;
        tree[r].sum +=val*(right-mid);
        tree[r].tag = val;
        tree[node].tag = 0;

    }
    public int query_tree(int left,int right,int l, int r,int node){
        if(r<left||l>right )return 0;
        else if(left==right)return tree[node].sum;
        else if(left>=l&&right<=r)return tree[node].sum;
        if(tree[node].tag!=0)pushDown(node,left,right);
        int mid = left+(right-left)/2;
        int left_node = 2*node+1;
        int right_node = 2*node+2;
        int sum_left = query_tree(left,mid,l,r,left_node);
        int sum_right = query_tree(mid+1,right,l,r,right_node);
        return sum_left+sum_right;
    }
    private void pushUp(int index){
        tree[index].sum = tree[index*2+1].sum+tree[index*2+2].sum;
    }

    public static void main(String[] args) {
        int[] array = {1,3,5,7,9,11};
        int size = 6;
        SegmentTree test = new SegmentTree(size,array);
        for(Node i:test.tree){
            System.out.print(i.sum+" ");
        }
//        test.update_tree(0,5,0,4,6);
//        for(Node i:test.tree){
//            System.out.println(i.sum);
//        }
//        System.out.println(test.query_tree(0,5,2,5,0));
        System.out.println();
        test.update_tree(0,5,0,0,5,2);
        System.out.println(test.query_tree(0,5,2,5,0));
        for(Node i:test.tree){
            System.out.print(i.sum+" ");
        }
    }

}
