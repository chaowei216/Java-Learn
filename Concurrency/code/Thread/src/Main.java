import java.util.Comparator;
import java.util.concurrent.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

class SharedResource {
    synchronized void access() {
        System.out.println(Thread.currentThread().getName() + " access");
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
    }
}

public class Main {

    public static void main(String[] args) {

//        var resource = new SharedResource();
//
//        Thread thread = new Thread() {
//            public void run() {
//                System.out.println("Thread name: " + Thread.currentThread().getName());
//            }
//        };
//
//        var t1 = new Thread(resource::access);
//        var t2 = new Thread(resource::access);
//
//        // get init state
//        System.out.println("NOT START - state: " + thread.getState());
//
//        // init new thread and execute run()
//        thread.start();
//
//        // run on main thread
//        thread.run();
//
//        // get state after starting
//        System.out.println("STARTED - state: " + thread.getState());
//
//        t1.start();
//        t2.start();
//
//        // get block state
//        try { Thread.sleep(100); } catch (InterruptedException e) {}
//        System.out.println(t2.getState());
//
//        // waiting state
////        Thread t3 = new Thread(() -> {
////            try {
////                Thread.currentThread().join(); // Chờ vô thời hạn
////            } catch (InterruptedException e) {}
////        });
////
////        t3.start();
////        try { Thread.sleep(100); } catch (InterruptedException e) {}
////        System.out.println(t3.getState());
//
//        // get timed_waiting state
//        Thread t4 = new Thread(() -> {
//            try {
//                Thread.sleep(5000); // Chờ 5 giây
//            } catch (InterruptedException e) {}
//        });
//
//        t4.start();
//        try { Thread.sleep(100); } catch (InterruptedException e) {}
//        System.out.println(t4.getState());
//
//        // get terminated state
//        System.out.println(thread.getState());
//
//        // time slicing
//        Thread t5 = new Thread(new Task(), "Thread-1");
//        Thread t6 = new Thread(new Task(), "Thread-2");
//
//        t5.start();
//        t6.start();
//
//        // reentrant
//        ReentrantExample obj = new ReentrantExample();
//        obj.methodA();
//
//        // reentrant with reentrant lock
//        ReentrantLockExample obj2 = new ReentrantLockExample();
//        obj2.methodA();
//
//        // wait, notify
//        AvoidDeadlockExample obj3 = new AvoidDeadlockExample();
//
//        Thread t7 = new Thread(obj3::methodA, "Thread-7");
//        Thread t8 = new Thread(obj3::methodB, "Thread-8");
//
//        t7.start();
//        t8.start();

//        // executorService
//        try (ExecutorService executorService = Executors.newFixedThreadPool(3)) {
//
//            // task
//            Callable<Integer> task = () -> {
//                Thread.sleep(2000);
//                return 10000;
//            };
//
//            // task
//            Runnable task1 = () -> {
//                System.out.println("Hello");
//            };
//
//            // submit task
//            Future<Integer> result = executorService.submit(task);
//
//            var result2 = executorService.submit(task1);
//
//            // get data
//            System.out.println(result.get());
//
//            executorService.shutdown();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }

//        // parallel
//        // normal stream
//        var nums = LongStream.range(1, 1_000_000).boxed().toList();
//
//        System.out.println(Runtime.getRuntime().availableProcessors());
//
//        var startTime = System.nanoTime();
//        System.out.println("Normal Stream: " + LongStream.range(1, 30_000_000).max());
//        System.out.println("Total time " + (System.nanoTime() - startTime) / 1_000_000 + "ms");
//
//        var startTime1 = System.nanoTime();
//        System.out.println("Normal Stream: " + LongStream.range(1, 30_000_000).parallel().max());
//        System.out.println("Total time " + (System.nanoTime() - startTime1) / 1_000_000.0 + "ms");
//
//        // ArrayBlockingQueue
//        ArrayBlockingQueue<Integer> ints = new ArrayBlockingQueue<>(2);
//
//        ints.add(1);
//        ints.add(2);
//        System.out.println(ints.offer(3));
//        try {
//            ints.put(4);
////            ints.take();
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
////        ints.put(4);
//        System.out.println("Capacity: " + ints.remainingCapacity());
    }
}