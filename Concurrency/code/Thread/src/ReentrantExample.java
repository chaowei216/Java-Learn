public class ReentrantExample {
    public synchronized void methodA() {
        System.out.println("Method A đang chạy...");
        methodB(); // Gọi methodB() bên trong methodA()
    }

    public synchronized void methodB() {
        System.out.println("Method B đang chạy...");
    }
}
