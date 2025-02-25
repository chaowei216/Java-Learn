public class AvoidDeadlockExample {

    private boolean flag = false;

    public synchronized void methodA() {

        while (flag) {

            System.out.println(Thread.currentThread().getName() + " is waiting lock for Method A...");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        flag = true;
        System.out.println(Thread.currentThread().getName() + " is holding lock for Method A...");

        // release
        flag = false;
        notify();
    }

    public synchronized void methodB() {

        while (flag) {

            System.out.println(Thread.currentThread().getName() + " is waiting lock for Method A...");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        flag = true;
        System.out.println(Thread.currentThread().getName() + " is holding lock for Method A...");

        // release
        flag = false;
        notify();
    }
}
