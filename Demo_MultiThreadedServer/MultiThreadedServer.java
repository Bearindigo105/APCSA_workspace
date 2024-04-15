import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedServer{
    private static int numClients = 0;

    public static void main(String[] args) throws IOException{
        int port = 9999;
        ServerSocket server = new ServerSocket(port);
        System.out.println("Clients: " + numClients);

        while(true){
            try {
                System.out.println("Listening...");
                Socket client = server.accept();
                System.out.println("New client connected");

                ClientHandler handler = new ClientHandler(client);
                Thread t = new Thread(handler);
                t.start();

            } catch (Exception e) {
                System.out.println("Oopies... Client connection error");
            }
        }
    }

    public static void addClient(){
        System.out.println("Clients: " + ++numClients);
    }

    public static void removeClient(){
        System.out.println("Clients: " + --numClients);
    }


}

class ClientHandler implements Runnable{

    private Socket client;
    private String name;

    public ClientHandler(Socket client){
        this.client = client;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            String message = in.readLine();
            name = message;
            System.out.println(name + "connected");
            MultiThreadedServer.addClient();

            message = in.readLine();

            while(message != null){
                System.out.println(name + ": " + message);
                out.println("Message recieved");
                in.readLine();
            }

            client.close();
            System.out.println(name + " disconnected");
            MultiThreadedServer.removeClient();
        } catch (Exception e) {
            System.out.println("Oopsie... IOException");
        }
    }

}