import com.zyf.concurrent.chapter01.TicketWindowRunnable;

/**
 * @author Hero
 * @description PACKAGE_NAME
 * @date 2019/7/22
 */
public class TicketWindowTest {
    public static void main(String[] args) {
        final TicketWindowRunnable task = new TicketWindowRunnable();

        Thread windowThread1 = new Thread(task, "一号窗口");

        Thread windowThread2 = new Thread(task, "二号窗口");

        Thread windowThread3 = new Thread(task, "三号窗口");

        Thread windowThread4 = new Thread(task, "四号窗口");

        windowThread1.start();
        windowThread2.start();
        windowThread3.start();
        windowThread4.start();
    }
}
