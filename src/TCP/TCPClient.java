package TCP;

import ChatSystem.ChatController;
import java.io.*;
import java.net.Socket;

public class TCPClient {
    private Socket socket;
    private BufferedWriter bufferedWriter;
    private ChatController controller;
    private String serverAddress;
    private int serverPort;

    public TCPClient(String serverAddress, int serverPort, ChatController controller) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
        this.controller = controller;
    }

    public void connect() {
        try {
            socket = new Socket(serverAddress, serverPort);
            System.out.println("Connected to server at " + serverAddress);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String message) {
        try {
            bufferedWriter.write(message);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendFile(String filePath) {
        // Logic to send file content over the TCP connection
    }

    public void disconnect() {
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
