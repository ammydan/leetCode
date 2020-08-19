package com.danpeng;

public class Noname {
    private boolean flag = false;
    public int method(){
        return 1;
    }


}
class Hello{
    public void hello() {
        Noname test = new Noname(){
            public int method(){
                return 2;
            }
        };
        System.out.println("hello");
        System.out.println(test.method());
    }
}
class Main{
    public static void main(String[] args) {
        Hello test = new Hello();
        test.hello();
    }
}
