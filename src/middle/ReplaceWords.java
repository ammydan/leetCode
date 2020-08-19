package middle;

import java.util.LinkedList;
import java.util.List;

public class ReplaceWords {
    class Node{
        Node[] subtree;
        boolean val;
        public Node(boolean val){
            subtree = new Node[26];
            this.val = val;
        }
        public Node(){
            subtree = new Node[26];
            this.val = false;
        }
    }
    private Node root = new Node();
    public void insert(String key){
        insert(root,key,0);
    }
    private Node insert(Node current, String key, int d){
        if(current==null)current = new Node();
        if(d==key.length()){
            current.val = true;
            return current;
        }
        int index = key.charAt(d)-'a';
        current.subtree[index] = insert(current.subtree[index],key,d+1);
        return current;
    }
    public String startWith(String key){
        int ans = startWith(root,key,0);
        if(ans<0)return key;
        return key.substring(0,ans);
    }

    private int startWith(Node current,String key, int d){
        if(current==null||d>=key.length())return -1;
        if(current.val)return d;
        int index = key.charAt(d)-'a';
        return startWith(current.subtree[index],key,d+1);
    }
    public String replaceWords(List<String> dict, String sentence){
        for(String str:dict){
            insert(str);
        }
        String[] list = sentence.split(" ");
        StringBuilder ans = new StringBuilder();
        for(String str: list){
            String temp = startWith(str);
            ans.append(temp+" ");
        }
        ans.deleteCharAt(ans.length()-1);
        return ans.toString();
    }

    public static void main(String[] args) {
        ReplaceWords test = new ReplaceWords();
        LinkedList<String> strs = new LinkedList<>();
        strs.add("cat");
        strs.add("bat");
        strs.add("rat");
        test.replaceWords(strs,"the cattle was rattled by the battery");
    }
}
