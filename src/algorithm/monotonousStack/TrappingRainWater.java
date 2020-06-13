package algorithm.monotonousStack;

import java.util.LinkedList;

/**
 * Hard 42
 *1、 自己的思路：
 * 这道题关键在于如何计算存储水的面积：我们将其拆分来计算（一层一层计算，按照两根柱子的差值作为高度）
 * ①我们用一个栈Stack存储一个index（该index的柱子要比后面一个高），另一个lowStation存储一个index（该index的柱子是前面较高的柱子的一个矮柱子）。
 * 记录这两个信息我们就很方便判断下一个柱子是否需要开始计算储水和出水的面积。
 * ②遍历的时候，当遇到比lowStation.peek()所在的柱子要高时，我们此时可以开始计算储水的面积，而且可能要多次（因为可能有多个lowStation所在的柱子都比该柱子矮一些）。
 * 而且遇到了当前遍历的柱子虽然比lowStation要高，但是比stack中的柱子要小时，我们应该做处理将其添加到两个栈中。
 * 时间复杂度：O(n)
 * 空间复杂度O(n)
 *
 * 2、参考思路
 * ①暴力破解：
 * 计算每个柱子上应该可以存储的雨水大小。（找出左右两侧最高的柱子，然后取较矮的一根，然后减去这个柱子的高度就可以得到想要的答案。
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * ②动态规划：
 * 我们在暴力破解的基础上可以存储值来加快速度，比如存储左右两侧的最大值或最小值。
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * ③单调栈
 * ④双指针
 * 其实是在动态规划的基础上进行优化，因为存储的左右两侧最大值都只用了一次，所以我们完全可以使用两个变量就可以存储。
 * 但是这里其实存在一个技巧的，是需要两侧进行同时遍历，比如在左侧只能找到其左部的最大值，这时如果右侧最大值比左侧大，那么我们可以直接使用左侧的，
 * 否则要换到另一侧执行。
 * */
public class TrappingRainWater {
    public int trap(int[] height){
//        1、自己的解法
//        if(height.length<=1)return 0;
//        LinkedList<Integer> stack = new LinkedList<>();
//        LinkedList<Integer> lowStation = new LinkedList<>();
//        int area = 0;
//        for(int i=0;i<height.length;i++){
//            while(!stack.isEmpty()&&!lowStation.isEmpty()&&height[lowStation.peek()]<height[i]){
//                int indexL = stack.pop();
//                int indexM = lowStation.pop();
//                int width = i-indexL-1;
//                int onehigh = height[indexL]>height[i]?height[i]:height[indexL];
//                int hi = onehigh-height[indexM];
//                area = area+width*hi;
//                if(height[indexL]>height[i]){
//                    stack.push(indexL);
//                    lowStation.push(i);
//                }
//            }
//            if(i<height.length-1&&height[i+1]<height[i]){
//                stack.push(i);
//                lowStation.push(i+1);
//            }
//        }
//        return area;
//        2、较好的单调栈
//        if(height==null||height.length<=1)return 0;
//        LinkedList<Integer> stack = new LinkedList<>();
//        int area= 0;
//        stack.push(0);
//        for(int i=1;i<height.length;i++){
//            while(height[i]>height[stack.peek()]){
//                int index = stack.pop();
//                if(stack.isEmpty())break;
//                int preIndex = stack.peek();
//                int hi = Math.min(height[preIndex],height[i])-height[index];
//                int width = i-preIndex-1;
//                area = area+hi*width;
//            }
//            stack.push(i);
//        }
//        return area;
//        3、双指针
        int left =0, right = height.length-1;
        int leftMost = 0, rightMost = height.length-1, area = 0;
        while(left<=right){
            if(height[leftMost]<height[rightMost]){
                if(height[left]>=height[leftMost]){
                    leftMost = left;
                    left++;
                }else{
                    area+= height[leftMost]-height[left];
                    left++;
                }
            }else{
                if(height[right]>=height[rightMost]){
                    rightMost = right;
                    right--;
                }else{
                    area+= height[rightMost]-height[right];
                    right--;
                }
            }
        }
        return area;

    }

    public static void main(String[] args) {
        TrappingRainWater test = new TrappingRainWater();
//        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
//        int[] height = {4,2,0,3,2,5};
        int[] height = {4,2,3};
        System.out.println(test.trap(height));
    }
}
