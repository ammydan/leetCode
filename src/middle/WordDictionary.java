package middle;
/**
 * middle 211
 * Trie结构练习题
 * */
public class WordDictionary {
    class Node{
        private Node[] subtree;
        private boolean val;
        public Node(boolean val){
            subtree = new Node[26];
            this.val = val;
        }
        public Node(){
            subtree = new Node[26];
            this.val = false;
        }
    }
    private Node root;
    public WordDictionary(){
        root = new Node();
    }
    public void addWord(String word){
        addWord(root,word,0);
    }
    private Node addWord(Node current, String key, int d){
        if(current==null)current = new Node();
        if(d == key.length()){
            current.val = true;
            return current;
        }
        int index = key.charAt(d)-'a';
        current.subtree[index] = addWord(current.subtree[index],key,d+1);
        return current;
    }
    public boolean search(String word){
        return search(root,word,0);
    }
    private boolean search(Node current, String key, int d){
        if(current==null||d>key.length())return false;
        if(key.length()==d)return current.val;
        char c = key.charAt(d);
        if(c=='.'){
            boolean flag=false;
            for(Node i:current.subtree){
                if(i!=null){
                    flag = search(i,key,d+1);
                }
                if(flag==true)return true;
            }
        }
        int index = c -'a';
        return search(current.subtree[index],key,d+1);
    }
}
