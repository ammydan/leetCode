package contest.contest20200816;

import java.util.LinkedList;

public class ThreeConsecutiveOdds {
    class MyQueue{
        LinkedList<Integer> list;
        int size;
        int num;
        public MyQueue(int size){
            this.size = size;
            list = new LinkedList<>();
        }
        public void insert(int x){
            if(x%2!=0){
                list.add(x);
                num++;
            }
        }
        public void remove(int x){
            if(list.isEmpty())return;
            if(x==list.peekFirst()){
                list.removeFirst();
                num--;
            }
        }
        public boolean finish(){
            return size==num;
        }
    }
    public boolean threeConsecutiveOdds(int[] arr){
        int len = arr.length;
        if(len<3)return false;
        MyQueue queue = new MyQueue(3);
        queue.insert(arr[0]);
        queue.insert(arr[1]);
        queue.insert(arr[2]);
        if(queue.finish())return true;
        for(int i=3;i<len;i++){
            queue.remove(arr[i-3]);
            queue.insert(arr[i]);
            if(queue.finish())return true;
        }
        return false;
    }
}
