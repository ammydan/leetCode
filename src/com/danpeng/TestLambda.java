package com.danpeng;

public class TestLambda {
    public static void main(String[] args) {
        Test test = (int x,int y)-> {
            int temp = x+y;
            return 100+temp;
        };
        System.out.println(test.getAns(3,4));
    }
}
interface Test{
    public int getAns(int i, int j);
}
