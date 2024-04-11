import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        System.out.println("~~~~ECHO SERVER~~~~");
        
        int port = 9999;
        ServerSocket server = new ServerSocket(port);

        while(true){
            try{
                System.out.println("listening...");
                Socket client = server.accept();                                                            //block
                System.out.println("client connected");

                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);

                String message;

                message = in.readLine();                                                                    //block
                while(message != null && message != "exit"){
                    System.out.println("Message Recieved: \"" + message + "\"");
                    message = message.toUpperCase();
                    out.println(message);
                    message = in.readLine();                                                                //block
                }

                client.close();
            }catch (Exception e){
                System.out.println("Uh oh... Client Connection Issue");
            }
        }
    }
}
