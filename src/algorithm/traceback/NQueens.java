package algorithm.traceback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens {
    private boolean[] cols;
    private boolean[] primPositive;
    private boolean[] primNegtive;
    private boolean[] assis;
    private List<List<String>> ans;
    private int n;
    public List<List<String>> solveNQueens(int n){
        this.cols = new boolean[n+1];
        this.primPositive = new boolean[n+1];
        this.primNegtive = new boolean[n+1];
        this.assis = new boolean[n*2+1];
        this.n = n;
        this.ans = new LinkedList<>();
        LinkedList<String> trace = new LinkedList<>();
        helper(0,trace);
        return ans;
    }
    private void helper(int row, LinkedList<String> trace){
        if(row==n){
            ans.add(new ArrayList<>(trace));
            return;
        }
        for(int i=1;i<=n;i++){
           if(!valid(row+1,i))continue;
           trace.add(paint(i));
           turn(row+1,i,true);
           helper(row+1,trace);
           trace.removeLast();
           turn(row+1,i,false);
        }
    }
    private boolean valid(int row, int col){
        if(cols[col])return false;
        int temp = row-col;
        boolean prim = temp<0?primNegtive[-temp]:primPositive[temp];
        if(prim||assis[row+col])return false;
        return true;
    }
    private String paint(int index){
        StringBuilder str = new StringBuilder();
        for(int i=1;i<=n;i++){
            if(i==index)str.append("Q");
            else str.append(".");
        }
        return str.toString();
    }
    private void turn(int row, int col, boolean flag){
        cols[col] = flag;
        int temp = row - col;
        if(temp<0)primNegtive[-temp] = flag;
        else primPositive[temp] = flag;
        assis[row+col] = flag;
    }

    public static void main(String[] args) {
        NQueens test = new NQueens();
        test.solveNQueens(4);
    }

}
