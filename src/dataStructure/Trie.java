package dataStructure;

import java.util.ArrayList;

public class Trie {
    private int total;
    private ArrayList<int []> tree;
    private ArrayList<Integer> sum;
    public Trie(){
        tree = new ArrayList<>();
        tree.add(new int[26]);
        total=0;
        sum = new ArrayList<>();
        sum.add(0);
    }
    public void insert(String str){
        int len = str.length();
        int root = 0;
        for(int i=0;i<len;i++){
            int index = str.charAt(i)-'a';
            if(tree.get(root)[index]==0){
                tree.get(root)[index] = ++total;
                tree.add(new int[26]);
                sum.add(0);
            }
            sum.set(root,sum.get(root)+1);
            root = tree.get(root)[index];
        }
    }
    public boolean find(String str){
        int len = str.length();
        int root = 0;
        for(int i=0;i<len;i++){
            int index = str.charAt(i)-'a';
            if(tree.size()<root+1)return false;
            if(tree.get(root)[index]==0)return false;
            root = tree.get(root)[index];
        }
        return true;
    }
    public int commonPrefixTimes(String str){
        int len = str.length();
        int root =0;
        for(int i=0;i<len;i++){
            int index = str.charAt(i)-'a';
            if(tree.size()<root+1)return -1;
            if(tree.get(root)[index]==0)return -1;
            root = tree.get(root)[index];
        }
        return sum.get(root);
    }

    public static void main(String[] args) {
        Trie tree = new Trie();
        tree.insert("hello");
        tree.insert("hero");
        tree.insert("hex");
        tree.insert("heat");
        tree.insert("he");

        System.out.println(tree.commonPrefixTimes("he"));
    }
}
