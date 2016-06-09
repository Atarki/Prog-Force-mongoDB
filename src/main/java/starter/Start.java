package starter;


import java.util.logging.Level;
import java.util.logging.Logger;

public class Start {
    public static final Logger LOG = Logger.getLogger(InitializerFoodStore.class.getName());

    public static void main(String[] args) throws InterruptedException {
        Logger mongoLogger = Logger.getLogger("org.mongodb");
        mongoLogger.setLevel(Level.WARNING);
        LOG.info("Start program...");

        InitializerFoodStore foodStore = new InitializerFoodStore();
        InitializerGadgedStore gadgedStore = new InitializerGadgedStore();
        LogJobThread logJobThread = new LogJobThread();

        Thread t1 = new Thread(foodStore);
        Thread t2 = new Thread(gadgedStore);
        Thread t3 = new Thread(logJobThread);

        t1.start();
        Thread.currentThread().sleep(1000);
        t2.start();
        t2.join();
        t3.start();
    }
}
