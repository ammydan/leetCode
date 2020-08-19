package com.danpeng;

import java.io.*;

public class TestTrace {
    public void test(int a){
         assert a==0:"expects a == 0";
    }

    public static void main(String[] args) {
        TestTrace test = new TestTrace();
        test.test(1);
        System.out.println("I can still go the next step.");
    }
}
