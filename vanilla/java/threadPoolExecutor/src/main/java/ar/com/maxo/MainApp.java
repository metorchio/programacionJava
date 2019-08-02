package ar.com.maxo;

/**
 * Created by enano on 2/19/2019.
 */
import ar.com.maxo.concurrent.ThreadPoolManager;

import javax.xml.ws.Endpoint;



//Thread Pool Executor
public class MainApp {

    public static void main(String[] args) {
        ThreadPoolManager tpm = ThreadPoolManager.getInstance();

        tpm.getExecutor().execute(null);
    }

}

