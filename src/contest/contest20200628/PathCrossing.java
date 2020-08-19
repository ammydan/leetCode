package contest.contest20200628;

import java.util.HashSet;
import java.util.Objects;

public class PathCrossing {
    class Pair{
        int x; int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x,y);
        }

        @Override
        public boolean equals(Object obj) {
            Pair cmp = (Pair)obj;
           if(cmp.x==x&&cmp.y==y)return true;
           return false;
        }
    }
    public boolean isPathCrossing(String path){
        HashSet<Pair> set = new HashSet<>();
        Pair pre = new Pair(0,0);
        set.add(pre);
        for(int i=0;i<path.length();i++){
            char temp = path.charAt(i);
            Pair current=null;
            switch (temp){
                case 'N':
                    current = new Pair(pre.x,pre.y+1);
                    break;
                case 'S':
                    current = new Pair(pre.x,pre.y-1);
                    break;
                case 'W':
                    current = new Pair(pre.x-1,pre.y);
                    break;
                default:
                    current = new Pair(pre.x+1,pre.y);
            }
            if(set.contains(current))return true;
            else {
                set.add(current);
                pre = current;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PathCrossing test = new PathCrossing();
        test.isPathCrossing("NESWW");
    }
}
