package middle;

import java.util.*;

public class MinimumPathSum {
    enum DIRECTION{
        DOWN(0,1),
        RIGHT(1,0);
        private int x;
        private int y;
        DIRECTION(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
    class Point implements Comparable<Point>{
        private int x;
        private int y;
        private int value;
        private int steps;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public int compareTo(Point o) {
            if(this.value>o.value) return 1;
            else if(this.value<o.value) return -1;
            else{
                if(this.steps>o.steps)return -1;
                else if(this.steps<o.steps)return 1;
                else return 0;
            }
        }

        @Override
        public boolean equals(Object obj) {
            Point cmp = (Point) obj;
            if(cmp.x==this.x && cmp.y==this.y)return true;
            return false;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + x;
            result = 31 * result + y;
            return result;
        }
    }
    public int minPathSum(int[][] grid) {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        Set<Point> set = new HashSet<>();
        int rows = grid.length;
        int cols = grid[0].length;
        Point source = new Point(0,0);
        Point target = new Point(cols-1,rows-1);
        source.value=grid[source.y][source.x];
        source.steps=0;
        queue.add(source);
        while(!queue.isEmpty()){
            Point current = queue.poll();
            set.add(current);
            int currentValue = current.value;
            if(current.equals(target)){
                target.value = current.value;
                break;
            }
            for(DIRECTION i: DIRECTION.values()){
                if(current.x+i.getX()>=0&&current.x+i.getX()<cols&&current.y+i.getY()>=0&&current.y+i.getY()<rows){
                    Point explore = new Point(current.x+i.getX(),current.y+i.getY());
                    explore.steps = current.steps+1;
                    explore.value = currentValue+grid[explore.y][explore.x];
                    if(!set.contains(explore))
                        queue.add(explore);
                }

            }
        }
        Point it = target;
        int sum = 0;
        return target.value;

    }

    public static void main(String[] args) {
        MinimumPathSum minimumPathSum = new MinimumPathSum();

//        int[][] grid = {
//                {0,0},
//                {0,0}
//        };
        int[][] grid = {
                {5,4,2,9,6,0,3,5,1,4,9,8,4,9,7,5,1},
                {3,4,9,2,9,9,0,9,7,9,4,7,8,4,4,5,8},
                {6,1,8,9,8,0,3,7,0,9,8,7,4,9,2,0,1},
                {4,0,0,5,1,7,4,7,6,4,1,0,1,0,6,2,8},
                {7,2,0,2,9,3,4,7,0,8,9,5,9,0,1,1,0},
                {8,2,9,4,9,7,9,3,7,0,3,6,5,3,5,9,6},
                {8,9,9,2,6,1,2,5,8,3,7,0,4,9,8,8,8},
                {5,8,5,4,1,5,6,6,3,3,1,8,3,9,6,4,8},
                {0,2,2,3,0,2,6,7,2,3,7,3,1,5,8,1,3},
                {4,4,0,2,0,3,8,4,1,3,3,0,7,4,2,9,8},
                {5,9,0,4,7,5,7,6,0,8,3,0,0,6,6,6,8},
                {0,7,1,8,3,5,1,8,7,0,2,9,2,2,7,1,5},
                {1,0,0,0,6,2,0,0,2,2,8,0,9,7,0,8,0},
                {1,1,7,2,9,6,5,4,8,7,8,5,0,3,8,1,5},
                {8,9,7,8,1,1,3,0,1,2,9,4,0,1,5,3,1},
                {9,2,7,4,8,7,3,9,2,4,2,2,7,8,2,6,7},
                {3,8,1,6,0,4,8,9,8,0,2,5,3,5,5,7,5},
                {1,8,2,5,7,7,1,9,9,8,9,2,4,9,5,4,0},
                {3,4,4,1,5,3,3,8,8,6,3,5,3,8,7,1,3}
        };
//        int[][] grid = {
//                {1,4,8,6,2,2,1,7},
//                {4,7,3,1,4,5,5,1},
//                {8,8,2,1,1,8,0,1},
//                {8,9,2,9,8,0,8,9},
//                {5,7,5,7,1,8,5,5},
//                {7,0,9,4,5,6,5,6},
//                {4,9,9,7,9,1,9,0}};
        int value = minimumPathSum.minPathSum(grid);
        System.out.println(value);


    }
}
