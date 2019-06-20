package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.util.Scanner;


public class Server {

    public static void main(String[] args) {
        Socket socket;
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            System.out.println("Сервер запущен, ждёт подключения...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            while (true) {
                String message = in.readUTF();
                System.out.println("Client: " + LocalDate.now() + " " + message);
                Scanner reader = new Scanner(System.in);
                String messageServer = reader.nextLine();
                if (messageServer.equalsIgnoreCase("/end")) {
                    break;
                }
                out.writeUTF("Server:" + LocalDate.now() + " " + messageServer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}