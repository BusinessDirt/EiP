import java.util.LinkedList;
import java.util.List;

public class MultiThreading {
    public static void main(String[] args) {
        List<CounterThread> threads = new LinkedList<>();
        for (int i = 0; i < 5; i++) threads.add(new CounterThread(i));
        while (CounterThread.counter < 42 || !threads.stream().allMatch(CounterThread::terminated)) ;
        System.out.println("Done");
    }
}
