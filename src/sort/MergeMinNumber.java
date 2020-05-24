package sort;

import easy.MergeSortedArray;

import java.util.Arrays;

/****
 * middle 面试题
 * 自己的思路：
 * 这里我们很容易知道，如果只有一位数字的话，我们只需要进行排序就可以获取这道题的答案，但是这里存在两位到三位的数字。
 * 我们可以改变比较的策略，在实现compareTo的时候，我们只需要补齐较短的数字。补什么呢？我们很容易想到可以补最高位。
 * 因为后面不可能再出现比第一位数字还低的数了。
 * 那么补齐之后还有一个问题，如果出现了补齐相等的情况怎么办？
 * 我们可以想象，如果较长的数字的后面从第二高位开始，如果比添加的数字大，那么我们把较长数字放在前面，反之，则把较长数字放在后面。
 * 参考思路：(这样更加简洁）
 * 若拼接字符串 x + y > y + xx+y>y+x ，则 m > nm>n ；
 * 反之，若 x + y < y + xx+y<y+x ，则 n < mn<m ；
 *
 * 技巧学习：
 * 在某个算法中需要进行补位比较的时候，我们其实完全可以使用String类型
 * **/
public class MergeMinNumber {
    public String minNumber(int[] nums) {
        int len = nums.length;
        if(len==0)return "";
        if(len==1)return Integer.toString(nums[0]);
        Number[] numbers = new Number[len];
        for(int i=0;i<len;i++){
            numbers[i] = new Number(nums[i]);
        }
        Arrays.sort(numbers);
        StringBuilder str = new StringBuilder();
        for(Number i: numbers){
            str.append(i.num);
        }
        return str.toString();

    }
    private class Number implements Comparable<Number>{
        int num;
        public Number(int num){
            this.num = num;
        }

        @Override
        public int compareTo(Number o) {
            int[] cmp = complete(num,o.num);
            if(cmp[0]>cmp[1])return 1;
            else if(cmp[0]<cmp[1])return -1;
            return cmp[2];

        }
        private int[] complete(int a ,int b){
            int timesA=0;
            int timesB=0;
            int highA=0,highB=0;
            int reserveA = a,reserveB = b;
            boolean flaga = true;
            boolean flagb = true;
            while(a>0 || b>0){
                if(a/10>0&&b/10<=0)timesB++;
                else if(a/10<=0&&b/10>0)timesA++;
                if(a/10==0&&flaga){
                    highA = a;
                    flaga = false;
                }
                if(b/10==0&&flagb){
                    highB = b;
                    flagb = false;
                }
                a/=10;
                b/=10;
            }
            int[] ans = new int [3];

            for(int i=0;i<timesA;i++){
                reserveA*=10;
                reserveA+=highA;
            }
            int tempA = reserveA;
            while(timesA==0&&tempA!=0){
                if(tempA%10>highB){
                    ans[2] = -1;
                    break;
                }else if(tempA%10<highB){
                    ans[2] = 1;
                    break;
                }
                tempA/=10;
            }
            for(int i=0;i<timesB;i++){
                reserveB*=10;
                reserveB+=highB;
            }
            int tempB = reserveB;
            while(timesB==0&&tempB!=0){
                if(tempB%10>highA){
                    ans[2] = 1;
                    break;
                }else if(tempB%10<highA){
                    ans[2] = -1;
                    break;
                }
                tempB/=10;
            }
            ans[0] = reserveA;
            ans[1] = reserveB;
            return ans;
        }
    }

    public static void main(String[] args) {
        MergeMinNumber test = new MergeMinNumber();
        int [] nums = {12,121};
        System.out.println(test.minNumber(nums));
    }
}
