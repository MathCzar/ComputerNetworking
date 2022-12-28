import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

    public static void main(String[] args) {

        ChatClient chatClient = new ChatClient();

    }

    public ChatClient() {

        try {

            //connect to the server
            Socket socket = new Socket("4.tcp.ngrok.io", 13100);

            //send messages to the server
            Sender sender = new Sender(socket);
            sender.start();

            //get messages from server
            Scanner scanner = new Scanner(socket.getInputStream());
            while (true) {

                if (scanner.hasNextLine()) {

                    System.out.println(scanner.nextLine());

                }

            }

        } catch (Exception e) {}

    }

    class Sender extends Thread {

        Scanner scanner;
        PrintWriter printWriter;

        public Sender(Socket socket) {

            try{

                printWriter = new PrintWriter(socket.getOutputStream());

            }
            catch(Exception e) {}


            scanner = new Scanner(System.in);

        }

        public void run() {

            while(true) {

                printWriter.println(scanner.nextLine());
                printWriter.flush();

            }

        }

    }

}
