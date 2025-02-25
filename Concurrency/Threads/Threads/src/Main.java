import lpa.CustomThread;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        // get current thread
        var currentThread = Thread.currentThread();

        System.out.println(currentThread);
        printThreadState(currentThread);

        // set
        currentThread.setName("MainGuy");
        currentThread.setPriority(Thread.MAX_PRIORITY);
        printThreadState(currentThread);

        // call custom thread
        CustomThread customThread = new CustomThread();
        customThread.start();

        // run method: synchronously
        // start method: asynchronously

        Runnable myRunnable = () -> {

            for (int i = 1; i <= 8; i++) {
                System.out.print(" 2 ");
                try {
                    TimeUnit.MILLISECONDS.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread myThread = new Thread(myRunnable);
        myThread.start();

        for (int i = 1; i <= 3; i++) {
            System.out.print(" 0 ");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printThreadState(Thread thread) {

        System.out.println("------------------");
        System.out.println("Thread ID: " + thread.threadId());
        System.out.println("Thread Name: " + thread.getName());
        System.out.println("Thread Priority: " + thread.getPriority());
        System.out.println("Thread State: " + thread.getState());
        System.out.println("Thread Group: " + thread.getThreadGroup());
        System.out.println("Thread Is Alive: " + thread.isAlive());
        System.out.println("------------------");
    }
}