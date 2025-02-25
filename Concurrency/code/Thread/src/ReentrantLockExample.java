import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private final ReentrantLock lock = new ReentrantLock();

    public void methodA() {
        lock.lock();
        try {
            System.out.println("Method A đang chạy...");
            methodB(); // Gọi methodB() bên trong methodA()
        } finally {
            lock.unlock();
        }
    }

    public void methodB() {
        lock.lock();
        try {
            System.out.println("Method B đang chạy...");
        } finally {
            lock.unlock();
        }
    }

}
