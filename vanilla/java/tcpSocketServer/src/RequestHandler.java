// A Java program for a Server
import java.net.*;
import java.io.*;

public class RequestHandler implements Runnable
{
    private final Socket client;
    ServerSocket serverSocket = null;

    public RequestHandler(Socket client){
        this.client = client;
    }

    public void run(){
        System.out.println("Client accepted");

        // takes input from the client socket
        try{
            DataInputStream in = new DataInputStream(
                    new BufferedInputStream(client.getInputStream()));

            String line = "";

            // reads message from client until "Over" is sent
            while (!line.equals("Over"))
            {
                try
                {
                    line = in.readUTF();
                    System.out.println(">>>> Receive message from: " + Thread.currentThread().getName() + " >> " + line);

                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");
            in.close();
            client.close();
        } catch (IOException i){
            System.out.println("IOException: " + i);
        } finally {

        }
    }

}