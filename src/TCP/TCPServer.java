package TCP;

import ChatSystem.ChatController;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedWriter;

public class TCPServer {
    private ServerSocket serverSocket;
    private ChatController controller;
    private int serverPort;

    public TCPServer(int serverPort, ChatController controller) {
        this.serverPort = serverPort;
        this.controller = controller;
    }

    public void startListening() {
        new Thread(() -> {
            try {
                serverSocket = new ServerSocket(serverPort);
                System.out.println("Server is listening on port " + serverPort);

                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Client connected from " + clientSocket.getInetAddress().getHostAddress());

                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                    writer.write("Welcome, you are connected to the server.");
                    writer.newLine();
                    writer.flush();

                    new Thread(new ClientHandler(clientSocket, controller)).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void stopListening() {
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}