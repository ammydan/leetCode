package internpractice.Netease;

import java.util.Scanner;

public class Netease2020_1 {
    private int[] arr = new int[151];
    private final int MAX = 150;
    private int lowbit(int x){
        return x&-x;
    }
    private void update(int index){
        int x = index;
        while(x<=150){
            arr[x]++;
            x +=lowbit(x);
        }
    }
    private int sum(int index){
        int x = index;
        int ans = 0;
        while(x>0){
            ans+=arr[x];
            x -=lowbit(x);
        }
        return ans;
    }

    public static void main(String[] args) {
//        Double a = 231.23542;
//        DecimalFormat decimalFormat = new DecimalFormat("#.##");
//        System.out.println(decimalFormat.format(a));
//        System.out.printf("%.2f",a);
        Netease2020_1 test = new Netease2020_1();
//        test.update(1);
//        test.update(1);
//        test.update(1);
//        test.update(6);
//        test.update(4);
//        test.update(9);
//        System.out.println(test.sum(10));
//        System.out.println(test.sum(5));
//        System.out.println(test.sum(8));
        Scanner in = new Scanner(System.in);
        long startTime = System.currentTimeMillis();
        while(in.hasNext()){
//            int total = 0;
//            if(in.hasNext())total = in.nextInt();
//            else return;
            int total = in.nextInt();
            int[] record = new int[total+1];
            for(int i=0;i<total;i++){
                int temp = in.nextInt();
                record[i+1]=temp;
                test.update(temp);
            }
//            int nums = 0;
//            if(in.hasNext()) nums = in.nextInt();
//            else return;
            int nums = in.nextInt();
            for(int i=0;i<nums;i++){
                int temp = in.nextInt();
                int sum = test.sum(record[temp]);
                Double ans = (sum-1.0)/total*100;
                System.out.printf("%.6f%n",ans);
            }
        }
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
    }
}
