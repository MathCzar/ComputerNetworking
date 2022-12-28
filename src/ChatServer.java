import javax.sound.midi.Receiver;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatServer {

    public static void main(String[] args) {

        ChatServer chatServer = new ChatServer();

    }

    public ChatServer() {

        try {

            //open up our server on 12345
            ServerSocket serverSocket = new ServerSocket(12345);

            //wait for client to connect
            Socket socket = serverSocket.accept();

            //recieve messages from client
            Receiver receiver = new Receiver(socket);
            receiver.start();

            //send messages to client
            Scanner scanner = new Scanner(System.in);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            while (true) {

                String input = scanner.nextLine();
                printWriter.println(input);
                printWriter.flush();

            }

        } catch (Exception e) {}
    }

        class Receiver extends Thread {

            Scanner scanner;

            public Receiver(Socket socket) {


                try {
                    scanner = new Scanner(socket.getInputStream());
                }
                catch(Exception e) {}
            }
            public void run() {

                while(true) {

                    if(scanner.hasNextLine()) {

                        System.out.println(scanner.nextLine());

                    }

                }

            }


        }

    }
