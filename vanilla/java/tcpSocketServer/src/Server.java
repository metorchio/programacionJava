// A Java program for a Server
import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class Server
{
    //initialize socket and input stream
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in =  null;
	private ExecutorService executor = null;

    // constructor with port
    public Server(int port)
    {
        // starts server and waits for a connection
        try(ServerSocket server = new ServerSocket(port))
        {
			executor = Executors.newFixedThreadPool(5);
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

			while(true){
				
				socket = server.accept();
				Runnable worker = new RequestHandler(socket);
				executor.execute(worker);
			}

            // close connection
            //socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        } finally {
			if( executor != null ){
				executor.shutdown();
			}
		}		
    }

    public static void main(String args[])
    {
        Server server = new Server(5000);
    }
}