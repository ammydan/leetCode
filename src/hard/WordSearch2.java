package hard;

import java.util.*;

public class WordSearch2 {
    private int rows, cols;
    private char[][] board;
    private String[] words;
    private boolean[][] marked;
    private int[][] direct = {{0,1,0,-1},{-1,0,1,0}};
    public List<String> findWords(char[][]board, String[]words){
        this.rows = board.length;
        this.cols = board[0].length;
        int nums = words.length;
        this.board = board;
        this.words = words;
        marked = new boolean[rows][cols];

        LinkedList<String> ans = new LinkedList<>();
        boolean flag = false;
        for(int k = 0;k<nums;k++){
            for(int i =0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    if(dfs(i,j,k,0)){
                        ans.add(words[k]);
                        flag = true;
                        break;
                    }
                }
                if(flag)break;
            }
            flag = false;
            marked = new boolean[rows][cols];
        }
        return ans;
    }
    private boolean dfs(int row, int col, int num,int index){
        if(index==words[num].length()-1){
            if(board[row][col]==words[num].charAt(index))return true;
            return false;
        }
        if(board[row][col]==words[num].charAt(index)){
            marked[row][col] = true;
            for(int i=0;i<4;i++){
                int newRow = row+direct[0][i];
                int newCol = col+direct[1][i];
                if(valid(newRow,newCol)){
                    if(dfs(newRow,newCol,num,index+1))return true;
                }
            }
            marked[row][col] = false;
        }
        return false;
    }
    private boolean valid(int row, int col){
        return row<rows&&row>=0&&col<cols&&col>=0&&!marked[row][col];
    }
}
class WordSearch2v2{
    private int rows, cols;
    private char[][] board;
    private Node root;
    private int[][] direct = {{0,1,0,-1},{-1,0,1,0}};
    private LinkedList<String> ans;
//    private HashSet<String> ans;
    private boolean[][]marked;

    class Node{
        HashMap<Character,Node> children;
        String word;
        public Node(String word){
            this.children = new HashMap<>();
            this.word = word;
        }
        public Node(){
            this.children = new HashMap<>();
            this.word = null;
        }
    }
    private void delete(String str){
        delete(root,str,0);
    }
    private Node delete(Node current,String str, int d){
        if(current==null)return null;
        if(d==str.length()){
            if(current.children.isEmpty()) return null;
            current.word = null;
            return current;
        }
        char c = str.charAt(d);
        Node next = delete(current.children.get(c),str,d+1);
        current.children.put(c,next);
        if(next==null&&current.word==null&&current.children.size()<=1) return null;
        return current;
    }
    private void insert(String str){
        insert(root,str,0);
    }
    private Node insert(Node current,String str, int d){
        if(current==null)current = new Node();
        if(d==str.length()){
            current.word = str;
            return current;
        }
        char c = str.charAt(d);
        current.children.put(c, insert(current.children.get(c),str,d+1));
        return current;
    }

    public List<String> findWords(char[][]board,String[]words){
        this.rows = board.length;
        this.cols = board[0].length;
        this.board = board;
        this.root = new Node();
//        this.ans = new HashSet<>();
        this.ans = new LinkedList<>();
        this.marked = new boolean[rows][cols];
        int len = words.length;

        for(int i=0;i<len;i++){
            insert(words[i]);
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                char c = board[i][j];
                if(root.children.get(c)!=null)dfs(i,j,root.children.get(c));
            }
        }
//        LinkedList<String> list = new LinkedList<>();
//        for(String str: this.ans){
//            list.add(str);
//        }
//        return list;
        return this.ans;
    }
    private void dfs(int row, int col, Node current){
        if(current==null)return;
        if(current.word!=null){
            this.ans.add(current.word);
            delete(current.word);
        }
        if(current.children.isEmpty())return;
        marked[row][col] = true;
        for(int i=0;i<4;i++){
            int newRow = row+direct[0][i];
            int newCol = col+direct[1][i];
            if(valid(newRow,newCol)){
                char c =board[newRow][newCol];
                if(current.children.get(c)!=null)dfs(newRow,newCol,current.children.get(c));
            }
        }
        marked[row][col]=false;
    }
    private boolean valid(int row, int col){
        return row<rows&&row>=0&&col<cols&&col>=0&&!marked[row][col];
    }

    public static void main(String[] args) {
        WordSearch2v2 test = new WordSearch2v2();
        char[][] board = {{'a','b'},{'c','d'}};
        String[] strs =   { "ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb" };

        test.findWords(board,strs);
    }


}
