package internpractice.Netease.AutumnRecruit;

import java.util.Scanner;
/**
 * 一开始还想着模拟，但是写着写着发现模拟过程中的各个条件考核太过于复杂。
 * 发现又是一个二分查找的题（只怪自己太憨憨了）
 * */
public class Problm1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long[] questions = new long[5];
        long sum = 0;
        for(int i=0;i<5;i++){
            questions[i] = in.nextLong();
            sum+=questions[i];
        }
        long low = 0, high = sum/3;
        long ans = 0;
        while(low<=high){
            long mid = low+(high-low)/2;
            if(valid(questions,mid)){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        System.out.println(ans);
    }
    private static boolean valid(long[]questions, long target){
        long[] array = questions.clone();
        if(array[0]<target){
            array[1] = array[1]-(target-array[0]);
            array[0] = target;
        }
        if(array[4]<target){
            array[3] = array[3]-(target-array[4]);
            array[4] = target;
        }
        if(array[2]<target){
            long sum = array[1]+array[3];
            if(sum>target-array[2])array[2] = target;
            else return false;
        }
        for(int i=0;i<5;i++){
            if(array[i]<0)return false;
        }
        return true;
    }
}
