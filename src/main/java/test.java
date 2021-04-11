import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.test")
public class test {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                log.debug("Testing in a thread");
            }
        };

        Runnable runnable = () -> log.debug("Testing in runnable thread");
        Thread t2 = new Thread(runnable, "Lambda thread");

        t.start();
        t2.start();
        log.debug("Testing in the main thread");
    }
}
