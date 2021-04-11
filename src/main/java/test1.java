import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j(topic = "c.test1")
public class test1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                log.debug("In the future task");
                Thread.sleep(2000);
                return 100;
            }
        });

        Thread t = new Thread(task);
        t.start();
        log.debug("Main thread");
        log.debug("Task result: {}", task.get());
    }
}
