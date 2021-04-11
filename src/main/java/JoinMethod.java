import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.JoinMethod")
public class JoinMethod {
    private static int r = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r = 10;
        });

        t.start();
        t.join(3000);
        log.debug("r : {}", r);
    }
}
