package dataStructure;

/***
 * 堆
 * 这个数据结构也是比较常用的，经常有些算法想要每次取最大值或者最小值（最短路径、最小生成树等）
 *
 * ***/
public class MinHeap<Key extends Comparable<Key>> {
    private Key[] heap;
    private int size;
    private int n;

    private void swap(int i,int j){
        Key temp = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = temp;
    }
    private void swim(int index){
        if(index<=1) return;
        for(int i = index;i/2>0;i/=2){
            if(this.heap[i].compareTo(this.heap[i/2])==1)break;
            this.swap(i,i/2);
        }
    }
    private void sink(int index){
        if(index*2>this.n) return;
        for(int i = index;i*2<=this.n;i*=2){
            int small =0;
            if(i*2+1<=this.n) small = this.heap[i*2].compareTo(this.heap[i*2+1])==-1 ? i*2:i*2+1;
            else
                small = i*2;
            if(this.heap[i].compareTo(this.heap[small])==-1)break;
            swap(i,small);
        }
    }

    //    我们在这里推移一个元素，这样方便算法实现
    public MinHeap(Key[] list){
        this.size = list.length;
        this.n = this.size;
        this.heap = (Key[]) new Comparable[this.size+1];
        for(int i=1;i<=this.n;i++){
            this.heap[i] = list[i-1];
        }
        for(int i=this.n/2;i>=1;i--){
            this.sink(i);
        }
    }
    public MinHeap(int size){
        this.size = size;
        this.n = 0;
        this.heap = (Key[]) new Comparable[this.size+1];
    }

    /**
     * 算法：
     * 将最后一个元素放入第一个元素的位置，然后进行sink
     * **/
    public Key deleteMin(){
        Key temp = this.heap[1];
        this.heap[1] = this.heap[this.n--];
        this.sink(1);
        this.heap[n+1] = null;
        return temp;
    }

    public static void main(String[] args) {
        Integer[] list = {33,4,3,7,1,23};
        MinHeap<Integer> test = new MinHeap<Integer>(list);
        test.deleteMin();
        test.deleteMin();
        Comparable[] temp =  test.heap;
        for(Comparable i :temp){
            System.out.println(i);
        }
//        Comparable[] temp =  test.heap;
//        for(Comparable i :temp){
//            System.out.println(i);
//        }
    }
}