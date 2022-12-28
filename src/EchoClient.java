import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

    public static void main(String[] args) {

        // connect to a server
        try {

            Socket socket = new Socket("localhost", 12345);
            System.out.println("Connected to the Server!");

            Scanner scanner = new Scanner(socket.getInputStream());
            if(scanner.hasNextLine()) {

                System.out.println(scanner.nextLine());

            }

        } catch (Exception e) {

        }

    }

}
