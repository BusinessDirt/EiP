public class CounterThread extends Thread {

    public static volatile int counter = 0;

    public CounterThread(int id) {
        super("thread-" + id);
        start();
    }

    public boolean terminated() {
        return this.getState() == State.TERMINATED;
    }

    @Override
    public synchronized void start() {
        super.start();
    }

    @Override
    public void run() {
        while (counter < 42) {
            try {
                counter++;
                System.out.printf("Counter: %s, Name: %s\n", counter, this.getName());
                sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
