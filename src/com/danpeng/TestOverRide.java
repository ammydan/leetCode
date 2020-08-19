package com.danpeng;

public class TestOverRide {
    public int test(Integer i,Integer j){
        return i+j;
    }
    public long test(long i, long j){
        return i+j+1;
    }

    public static void main(String[] args) {
        TestOverRide test = new TestOverRide();
        int i = 1;
        int j = 2;
        System.out.println(test.test(i,j));

    }
}
