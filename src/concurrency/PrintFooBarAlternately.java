package concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1115 middle
 * */
public class PrintFooBarAlternately {

}
class FooBar{
//    private int n;
//    private int flag;
//    private Object lock = new Object();
//    public FooBar(int n){
//        this.n = n;
//    }
//
//    public void foo(Runnable printFoo) throws InterruptedException {
//        for(int i=0;i<n;i++){
//            synchronized (lock){
//                while(flag!=0)lock.wait();
//                printFoo.run();
//                flag = 1;
//                lock.notifyAll();
//            }
//        }
//    }
//    public void bar(Runnable printBar) throws InterruptedException {
//        for(int i =0;i<n;i++){
//            synchronized (lock){
//                while(flag!=1)lock.wait();
//                printBar.run();
//                flag = 0;
//                lock.notifyAll();
//            }
//        }
//    }
    private ReentrantLock lock = new ReentrantLock();
    private Condition fooCondition = lock.newCondition();
    private Condition barCondition = lock.newCondition();
    private int count;
    private int n;
    public FooBar(int n){
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for(int i=0;i<n;i++){
            lock.lock();
            while(count!=0) {
                fooCondition.await();
            }
            printFoo.run();
            count = 1;
            barCondition.signalAll();
            lock.unlock();

        }
    }
    public void bar(Runnable printBar) throws InterruptedException {
        for(int i=0;i<n;i++){
            lock.lock();
            while(count!=1){
                barCondition.await();
            }
            printBar.run();
            count = 0;
            fooCondition.signalAll();
            lock.unlock();
        }
    }
}
