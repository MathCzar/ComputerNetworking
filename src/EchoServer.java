import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) {

        try {

            //open server on 12345
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server up on port " + serverSocket.getLocalPort());

            //wait for client to connect
            Socket socket = serverSocket.accept();
            System.out.println("Client Connected!");

            //say hi
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.println("Hi");
            printWriter.flush();

        }
        catch(Exception e) {



        }

    }

}
