import java.util.concurrent.ArrayBlockingQueue;

class Producer implements Runnable {
    private final ArrayBlockingQueue<Integer> queue;

    public Producer(ArrayBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                System.out.println("Producer sản xuất: " + i);
                queue.put(i); // Chờ nếu queue đầy
                Thread.sleep(1000); // Giả lập thời gian sản xuất
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private final ArrayBlockingQueue<Integer> queue;

    public Consumer(ArrayBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer item = queue.take(); // Chờ nếu queue rỗng
                System.out.println("Consumer tiêu thụ: " + item);
                Thread.sleep(1500); // Giả lập thời gian tiêu thụ
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ArrayBlockingQueueExample {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

        Thread producerThread = new Thread(new Producer(queue));
        Thread consumerThread = new Thread(new Consumer(queue));

        producerThread.start();
        consumerThread.start();
    }
}