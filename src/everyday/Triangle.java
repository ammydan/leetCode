package everyday;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
/**
 * middle 120 Triangle
 * 1、自己的想法
 * 这道题没有啥好说的就是动态规划，顺着下来需要做选择，似乎看起来没有可以存储的方法。
 * 但是逆向来看，其实每次选择最小的那个就可以得到最终答案。
 * */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle){
        int len = triangle.size();
        int[] opt = new int[len+1];
        ListIterator listIterator = triangle.listIterator();
        while(listIterator.hasNext()){
            listIterator.next();
        }
        while(listIterator.hasPrevious()){
            List list = (List) listIterator.previous();
            int i = 0;
            for(Object o: list){
                Integer value = (Integer)o;
                opt[i] = Math.min(opt[i],opt[i+1])+value;
                i++;
            }
        }
        return opt[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> list1 = new LinkedList<>();
        list1.add(2);
        List<Integer> list2 = new LinkedList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new LinkedList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new LinkedList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        Triangle test = new Triangle();
        test.minimumTotal(list);
    }
}
