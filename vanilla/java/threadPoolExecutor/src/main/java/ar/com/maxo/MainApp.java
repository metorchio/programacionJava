package ar.com.maxo;

/**
 * Created by enano on 2/19/2019.
 */
import ar.com.maxo.concurrent.ThreadPoolManager;

import javax.xml.ws.Endpoint;
import java.util.concurrent.TimeUnit;


//Thread Pool Executor
public class MainApp {

    public static void main(String[] args) {
        ThreadPoolManager tpm = ThreadPoolManager.getInstance();

        tpm.getExecutor().execute(() -> System.out.println("Hello World"));

        tpm.getExecutor().submit(() -> {
            System.out.println(Thread.currentThread().getName() + ": 1...start");
            Thread.sleep(10000);
            System.out.println(Thread.currentThread().getName() + ": 1...end" );
            return null;
        });
        tpm.getExecutor().submit(() -> {
            System.out.println(Thread.currentThread().getName() + ": 2...start");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + ": 2...end");
            return null;
        });
        tpm.getExecutor().submit(() -> {
            System.out.println(Thread.currentThread().getName() + ": 3...start" );
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + ": 3...end");
            return null;
        });
        tpm.getExecutor().submit(() -> {
            System.out.println(Thread.currentThread().getName() + ": 4...start");
            Thread.sleep(10000);
            System.out.println(Thread.currentThread().getName() + ": 4...end");
            return null;
        });

        //no new tasks will be accepted.
        tpm.getExecutor().shutdown();
        //this task will never executed.
        //tpm.getExecutor().execute(() -> System.out.println("Good bye world"));
        try {
            //await for tasks termination
            tpm.getExecutor().awaitTermination(60, TimeUnit.SECONDS);
        }catch (InterruptedException ie){
            System.out.println("Error occurred..");
        }
        System.out.println("Finished...");
    }

}

