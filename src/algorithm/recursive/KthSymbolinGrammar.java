package algorithm.recursive;



public class KthSymbolinGrammar {
    public int kthGrammar(int N,int k){
        if(k==1)return 0;
        int index = (k%2)^1;
        if(k%2>0)k = k+1;
        return index^kthGrammar(N,k/2);
    }

    public static void main(String[] args) {
        int i = 0;
        int j = 1;
        System.out.println(i^1);
        System.out.println(~j);
    }
}
