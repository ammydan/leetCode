package algorithm.subString;
/**
 * 创建时额外的时间花费：O(Rm)
 * 时间复杂度：O(n+m)——这里还有一个条件就是要求你匹配的基础的字符范围不能太大，否则空间消耗太大，时间复杂度也会随之上升。
 * 空间复杂度：O(RM)
 * */
public class KMP {
    private String pattern;
    private final int R=26;
    private int[][] map;

    public KMP(String pattern) {
        this.pattern = pattern;
        map = new int[R][pattern.length()];
        buildMap();
    }

    private void buildMap(){
        int len = pattern.length();
        map[pattern.charAt(0)-'a'][0] = 1;
        int x = 0;
        for(int i=1;i<len;i++){
            int c = pattern.charAt(i)-'a';
            for(int j=0;j<R;j++)map[j][i] = map[j][x];
            map[c][i]=i+1;
            x = map[c][x];
        }
    }
    public int search(String str ){
        int len = str.length();
        int lenP = pattern.length();
        int state = 0;
        int i=0;
        for(;i<len;i++){
            int c = str.charAt(i)-'a';
            state = map[c][state];
            if(state==lenP)return i-lenP+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        KMP test = new KMP("abac");
        System.out.println(test.search("abacaacabaccc"));
    }
}
