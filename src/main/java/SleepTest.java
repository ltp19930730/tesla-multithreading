import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.SleepTest")
public class SleepTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {

                log.debug("Thread t1 interrupted: {}", Thread.currentThread().getState());
                e.printStackTrace();
            }
        });
        t1.start();
        log.debug("State of t1: {}", t1.getState());
        TimeUnit.SECONDS.sleep(1);
        log.debug("State of t1: {}", t1.getState());

        t1.interrupt();
    }
}
