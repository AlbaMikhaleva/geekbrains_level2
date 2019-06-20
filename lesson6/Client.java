package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Client extends JFrame {

    private final String ADDRESS = "localhost";
    private final int PORT = 8888;
    private Socket socket;

    private DataInputStream reader;
    private DataInputStream in;
    private DataOutputStream out;
    private String message;


    public Client() {
        try {
            openConnection();
        } catch (IOException e) {
            System.out.println("Error connection");
            e.printStackTrace();
        }
    }

    private void openConnection() throws IOException {
        socket = new Socket(ADDRESS, PORT);
        Scanner reader = new Scanner(System.in);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        System.out.println("Введите сообщение:");
        new Thread(() -> {
            try {
                while (true) {
                     message = reader.nextLine();
                    out.writeUTF(message + "\n");
                    if (message.equalsIgnoreCase("/end")) {
                        closeConnection();
                        break;
                    }
                   String messageServer = in.readUTF();
                   System.out.println(messageServer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
//
    }

    private void closeConnection() {
        try {
            in.close();
        } catch (IOException e) {
            System.out.println("DataInputStream is already closed");
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            System.out.println("DataOutputStream is already closed");
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("Socket is already closed");
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        Client client = new Client();
    }
}


