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

            bufferedWriter.write("Hello, I am connected to you.");
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String address, String message) {
        try (Socket socket = new Socket(address, serverPort);
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            System.out.println("Connected to server at " + address);
            bufferedWriter.write(message);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendFile(String address, String filePath) {
        try (Socket socket = new Socket(address, serverPort);
             OutputStream outputStream = socket.getOutputStream();
             FileInputStream fileInputStream = new FileInputStream(filePath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
