package dataStructure.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class EvaluateDivision {
//    HashMap<String,String > parents = new HashMap<>();
//    HashMap<String, Double> values = new HashMap<>();
//
//    private String root(String x){
//        if(!parents.containsKey(x))return null;
//        while(!x.equals(parents.get(x))){
//            Double temp1 = values.get(x);
//            Double temp2 = values.get(parents.get(x));
//            Double temp = temp1*temp2;
//            parents.put(x, parents.get(parents.get(x)));
//            values.put(x,temp);
//            x = parents.get(x);
//        }
//        return x;
//    }
//    private boolean connexted(String x, String y){
//        String rootX = root(x);
//        String rootY = root(y);
//        if(rootX.equals(rootY))return true;
//        return false;
//    }
//
//    private void union(String x, String y,Double value){
//        init(x);
//        init(y);
//        String rootX = root(x);
//        String rootY = root(y);
//        Double numX = cal(x);
//        Double numY = cal(y);
//        parents.put(rootX,rootY);
//        values.put(rootX,value*(numY/numX));
//    }
//    private void init(String x){
//        if(parents.containsKey(x))return;
//        parents.put(x, x);
//        values.put(x,1.0);
//    }
//    private Double cal(String x){
//        Double val = 1.0;
//        while(!x.equals(parents.get(x))){
//            val*=values.get(x);
//            x = parents.get(x);
//        }
//        return val;
//    }
//    public Double query(String x, String y){
//        if(!parents.containsKey(x))return -1.0;
//        if(!parents.containsKey(y))return -1.0;
//        if(!connexted(x,y))return -1.0;
//        Double numX = cal(x);
//        Double numY = cal(y);
//        return numX/numY;
//    }
//    public double[] calcEquation(List<List<String>> equations, double[] values,  List<List<String>> queries){
//        int index = 0;
//        for(List<String> nums: equations){
//            String x = nums.get(0);
//            String y = nums.get(1);
//            Double val = values[index++];
//            union(x,y,val);
//        }
//        double [] ans = new double[queries.size()];
//        index = 0;
//        for(List<String > nums: queries){
//            String x = nums.get(0);
//            String y = nums.get(1);
//            ans[index++] = query(x,y);
//        }
//        return ans;
//    }
//
    public static void main(String[] args) {
        EvaluateDivision test = new EvaluateDivision();
        List<List<String>> equations = new LinkedList<>();
        List<String> str1 = new LinkedList<>();
        str1.add("a");
        str1.add("b");
        equations.add(str1);
        List<String> str2 = new LinkedList<>();
        str2.add("b");
        str2.add("c");
        equations.add(str2);
        double[]values= new double[2];
        values[0] = 2.0;
        values[1] = 3.0;
        List<List<String>> queries = new LinkedList<>();
        List<String> query1 = new LinkedList<>();
        query1.add("a");
        query1.add("c");
        queries.add(query1);

        test.calcEquation(equations,values,queries);
    }
    public double[] calcEquation(List<List<String>> equations, double[] values,  List<List<String>> queries){
        int len = equations.size();
        int max = 0;
        HashMap<String,Integer> map = new HashMap<>();
        for(List<String> str:equations){
            if(!map.containsKey(str.get(0)))map.put(str.get(0),max++);
            if(!map.containsKey(str.get(1)))map.put(str.get(1),max++);
        }
        double[][]vals = new double[max][max];
        int index = 0;
        for(List<String> str:equations){
            int x = map.get(str.get(0));
            int y = map.get(str.get(1));
            vals[x][y] = values[index];
            vals[y][x] = 1.0/values[index++];
        }
        for(int k=0;k<max;k++){
            for(int i=0;i<max;i++){
                for(int j=0;j<max;j++){
                    if(i!=j&&vals[i][j]==0&&vals[i][k]!=0&&vals[k][j]!=0)
                        vals[i][j] = vals[i][k]*vals[k][j];
                }
            }
        }
        double[] ans = new double[queries.size()];
        index = 0;
        for(List<String> str:queries){
            if(!map.containsKey(str.get(0))||!map.containsKey(str.get(1))){
                ans[index++] = -1.0;
                continue;
            }
            int x = map.get(str.get(0));
            int y = map.get(str.get(1));
            if(x==y)ans[index++] = 1;
            else if(vals[x][y]==0) ans[index++] = -1;
            else ans[index++] = vals[x][y];
        }
        return ans;
    }
}
