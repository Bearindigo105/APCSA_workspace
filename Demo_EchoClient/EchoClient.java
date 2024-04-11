import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient{

    public static void main(String[] args) throws UnknownHostException, IOException {
        Scanner sysIn = new Scanner(System.in);
        System.out.println("~~~~ECHO CLIENT~~~~");
        System.out.print("ip address: ");
        String ip = sysIn.nextLine(); // 10.30.28.158, Mr. Ellis
        System.out.print("port: ");
        int port = sysIn.nextInt(); //9999 default
        sysIn.nextLine();

        Socket client = new Socket(ip,port);

        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);

        
        System.out.print("enter message: ");
        String message = sysIn.nextLine();
        System.out.println("bla");
        while(!message.equals("done")){
            out.println(message);
            String received = in.readLine();
            System.out.println("message received: " + received);
            System.out.print("enter next message: ");
            message = sysIn.nextLine();
        }

        client.close();
        sysIn.close();
    }
}