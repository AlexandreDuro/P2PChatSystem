package Network;

import ChatSystem.ChatController;
import TCP.TCPClient;
import TCP.TCPServer;

import java.util.HashMap;

public class Communication {
    private ChatController controller;
    private TCPClient tcpClient;
    private TCPServer tcpServer;
    private HashMap<String, String> users;

    public Communication(ChatController controller) {
        this.controller = controller;
        this.users = new HashMap<>();
        this.tcpServer = new TCPServer(12345, controller);
        this.tcpServer.startListening();
    }

    public void connect(String serverAddress, int serverPort) {
        tcpClient = new TCPClient(serverAddress, serverPort, controller);
        tcpClient.connect();
    }

    public void disconnect() {
        tcpClient.disconnect();
        tcpServer.stopListening();
    }

    public void send(String username, String message) {
        tcpClient.send(users.get(username), message);
    }

    public void sendFile(String username, String filePath) {
        controller.sendFile(username, filePath);
    }

}