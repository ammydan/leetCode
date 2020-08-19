package dataStructure.graph;

import javax.sound.sampled.Line;
import java.util.*;

public class ReconstructItinerary {
    private HashMap<String, LinkedList<String>> map = new HashMap<>();
    private int max;
    private LinkedList<String > ans;
    public List<String> findItinerary(List<List<String>> tickets) {
        max = 0;
        for (List<String> ticket : tickets) {
            max++;
            LinkedList list = map.getOrDefault(ticket.get(0), new LinkedList<String>());
            list.add(ticket.get(1));
            map.put(ticket.get(0), list);
        }
        for(LinkedList<String > list: map.values()){
            Collections.sort(list);
        }
        ans = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        ans.add("JFK");
        set.add("JFK");
        if(dfs("JFK",set,0)) return ans;
        return new LinkedList<>();
    }
    private boolean dfs(String current, HashSet<String> set,int index){
        if(index==max)return true;
        LinkedList<String>list = map.get(current);
        if(list ==null)return false;
        LinkedList<String> tempList = (LinkedList<String>) list.clone();
        for(String str: tempList){
            list.remove(str);
            ans.offerLast(str);
            if(dfs(str,set,index+1))return true;
            ans.removeLast();
            list.add(str);
        }
        return false;
    }

    public static void main(String[] args) {
        ReconstructItinerary test = new ReconstructItinerary();
//        List<List<String>> list= new LinkedList<>();
//        LinkedList<String> list1 = new LinkedList<>();
//        list1.add("MUC");
//        list1.add("LHR");
//        LinkedList<String> list2 = new LinkedList<>();
//        list2.add("JFK");
//        list2.add("MUC");
//        LinkedList<String> list3 = new LinkedList<>();
//        list3.add("SFO");
//        list3.add("SJC"); //        LinkedList<String> list4 = new LinkedList<>();
//        list4.add("LHR");
//        list4.add("SFO");
//        list.add(list1);
//        list.add(list2);
//        list.add(list3);
//        list.add(list4);
//        List<List<String>> list= new LinkedList<>();
//        LinkedList<String> list1 = new LinkedList<>();
//        list1.add("JFK");
//        list1.add("SFO");
//        LinkedList<String> list2 = new LinkedList<>();
//        list2.add("JFK");
//        list2.add("ATL");
//        LinkedList<String> list3 = new LinkedList<>();
//        list3.add("SFO");
//        list3.add("ATL");
//        LinkedList<String> list4 = new LinkedList<>();
//        list4.add("ATL");
//        list4.add("JFK");
//        LinkedList<String> list5 = new LinkedList<>();
//        list5.add("ATL");
//        list5.add("SFO");
//        list.add(list1);
//        list.add(list2);
//        list.add(list3);
//        list.add(list4);
//        list.add(list5);
        List<List<String>> list= new LinkedList<>();
        LinkedList<String> list1 = new LinkedList<>();
        list1.add("JFK");
        list1.add("KUL");
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("JFK");
        list2.add("NRT");
        LinkedList<String> list3 = new LinkedList<>();
        list3.add("NRT");
        list3.add("JFK");
        list.add(list1);
        list.add(list2);
        list.add(list3);
        test.findItinerary(list);
    }
}