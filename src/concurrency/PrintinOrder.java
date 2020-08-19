package concurrency;
/**
 * easy 1114
 * */
public class PrintinOrder {
}
class Foo{
    private boolean first;
    private boolean second;
    private Object lock = new Object();
    public Foo(){

    }

    public void first(Runnable printFirst){
        synchronized (lock){
            printFirst.run();
            first = true;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock){
            while(!first){
                lock.wait();
            }
            printSecond.run();
            second = true;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock){
            while(!first||!second){
                lock.wait();
            }
            printThird.run();
        }
    }
}
