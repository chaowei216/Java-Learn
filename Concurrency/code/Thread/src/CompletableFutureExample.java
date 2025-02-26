import java.util.concurrent.*;

public class CompletableFutureExample {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);
        // chaining
        // future
//        Future<String> future = executor.submit(() -> {
//            Thread.sleep(2000);
//            return "Hello World";
//        });
//
//        String result = null;
//        try {
//            result = future.get(); // Blocking
//        } catch (InterruptedException | ExecutionException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println(result);
//        executor.shutdown();

        // completableFuture
//        CompletableFuture.supplyAsync(() -> {
//            System.out.println("Task 1 - Thread: " + Thread.currentThread().getName());
//            return "Hello";
//        }).thenApply(result -> {
//            System.out.println("Task 2 - Thread: " + Thread.currentThread().getName());
//            return result + " World";
//        }).thenAccept(System.out::println);
//
//        CompletableFuture.supplyAsync(() -> {
//            System.out.println("Task 1 - Thread: " + Thread.currentThread().getName());
//            return "Hello";
//        }, executor).thenApply(result -> {
//            System.out.println("Task 2 - Thread: " + Thread.currentThread().getName());
//            return result + " World";
//        }).thenAccept(System.out::println);
//
//        executor.shutdown();

        CompletableFuture<Void> tasks = CompletableFuture.allOf(
          CompletableFuture.runAsync(() -> {
              try {
                  System.out.println(Thread.currentThread().getName());
                  System.out.println("Get data");
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }
          }),
                CompletableFuture.runAsync(() -> {
                    try {
                        System.out.println(Thread.currentThread().getName());
                        System.out.println("Write data");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }),
                CompletableFuture.runAsync(() -> {
                    try {
                        System.out.println(Thread.currentThread().getName());
                        System.out.println("Save data");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })
        );
        tasks.join();

    }
}
