package com.danpeng;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.concurrent.locks.ReentrantLock;


public class TestThreadException implements Runnable{

    @Override
    public void run() {
        try {
            InputStream inputStream = new FileInputStream("hell");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Runnable test = new TestThreadException();
        test.run();
    }

}
