package com.danpeng;

import java.util.ArrayList;
import java.util.HashMap;

public class Outer {
    private int num;
    private boolean flag;
    private Inner in;
    public Outer(){
        this.num = 1;
        this.flag = true;
        this.in = new Inner();
    }
    public void methodLocal(){
        int localVariable = 10;
        class Local{
            private int x = localVariable;
            public String hello(){
                return "hello";
            }
            public boolean getOutFlag(){
                return flag;
            }
        }
        Local local = new Local();
        local.hello();

    }
    private class Inner{
        Inner(){
            this.num = 2;
            this.x = 4;
        }
        private int num;
        private int x;
        public  boolean valid(){
            return flag;
        }
    }
    public int getX(){
        return in.x;
    }

    public static void main(String[] args) {

    }
}
