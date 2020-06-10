package dataStructure;

import java.util.HashMap;

/**
 * 原始的并查集是使用array作为底层实现的，这就可能出现一个很大的限制。
 * 限制：你必须将你的元素转换为int，我有一个想法是不如直接将array直接转换为hashmap，
 * 因为创建的类都会考虑实现hashcode,另外延展为comparable也是同理。
 *
 * 这个数据结构有一个巨大的缺陷，就是必须提前知道有多少个元素，元素是什么，否则无法进行下去。
 * **/
public class UnionFind <T extends Comparable>{
    /**
     * 原始的版本V1.0：p和q都有相同的id，那么他们俩为同一个set。
     * 这个版本缺点太大，那就是合并的动作需要的时间太多，每一个其他set的元素都要修改。
     * */
    private int[] id;
//    这里是提升UF时的添加的一个变量。
    private int[] size;
    public UnionFind(int N){
        id = new int[N];
        for(int i = 0;i<N;i++){
            id[i] = i;
        }
    }
    public void union(int a, int b){
        int valA = id[a];
        int valB = id[b];
        for(int i=0;i<id.length;i++){
            if(id[i]==valB)id[i] = valA;
        }
    }
    public boolean connected(int a, int b){
        return id[a]==id[b];
    }
    /**
     * 第二次升级版本V1.1：id[i] is parent of i
     * **/
    private int root(int a){
        int index = a;
        while(id[index]!=index)index = id[index];
        return index;
    }
    public void union1(int a, int b){
        int valA = root(a);
        int valB = root(b);
        id[valB] = valA;
    }
    public boolean connected1(int a, int b){
        return root(a)==root(b);
    }

    /**
     *性能提升的版本V1.2：避免树过高，我们将添加一个size数组记录对应元素的大小。
     * 这个版本的connected并不需要更改。
     * */
    public UnionFind(int N,int version){
        id = new int[N];
        size = new int[N];
        for(int i=0;i<N;i++){
            id[i] = i;
            size[i] = 1;

       }
    }
    public void union2(int a, int b){
        int valA = root(a);
        int valB = root(b);
        if(valA==valB)return;
        if(size[valA]>size[valB]){
            id[valB] = valA;
            size[valA]+=size[valB];
        }else{
            id[valA] = valB;
            size[valB]+=size[valA];
        }
    }

    /**
     * 性能提升V1.3：我们将高树打平，在哪里打平呢？——我们寻找root的时候是我们打平树的最佳时期。
     * */
    public int root3(int a){
        while(id[a]!=a){
            id[a] = id[id[a]];
            a = id[a];
        }
        return a;
    }

    /**
     * 数据结构更广泛V2.0：我们用hashmap作为实现的底层，提高该数据结构的适应性。
     * */
    HashMap<T,T> parent;
    HashMap<T,Integer> num;
    public UnionFind(){
       parent = new HashMap<>();
       num = new HashMap<>();
    }

    private T root20(T a){
        if(parent.get(a)==null){
            parent.put(a,a);
            num.put(a,1);
        }
        while(!a.equals(parent.get(a))){
            parent.put(a,parent.get(parent.get(a)));
            a = parent.get(a);

        }
        return a;
    }

    public boolean connected(T a, T b){
        return root20(a).equals(root20(b));
    }
    public void union20(T a, T b){
        T valA = root20(a);
        T valB = root20(b);
        if(valA.equals(valB))return;
        if(valA.compareTo(valB)>0){
            parent.put(valB,valA);
            num.put(valA,num.get(valB)+num.get(valA));
        }else{
            parent.put(valA,valB);
            num.put(valB,num.get(valA)+num.get(valB));
        }
    }

    public static void main(String[] args) {
        UnionFind test = new UnionFind();
        String[] list = new String[5];
        list[0] = "hello";
        list[1] = "hi!";
        list[2] ="SB";
        list[3] = "xixi";
        list[4] = "ai";
        System.out.println(test.connected(list[0],list[1]));
        test.union20(list[0],list[1]);
        System.out.println(test.connected(list[0],list[1]));
        System.out.println(test.connected(list[1],list[2]));

    }

}
