package ChatSystem;

import GUI_interface.GUI_interface;
import Network.Communication;
import ViewModel.ChatView;
import ViewModel.ChatModel;
import TCP.TCPClient;
import TCP.TCPServer;

import javax.swing.*;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class ChatController {
    private ChatModel model;
    private ChatView view;
    private Communication communication;
    private HashMap<String, String> users;
    private Socket socket;

    public ChatController(ChatModel model, ChatView view) {
        this.model = model;
        this.view = view;
        this.users = new HashMap<>();
        this.communication = new Communication(this);
    }

    public void sendMessage(String username, String message) {
        model.addMessage("You to " + username + ": " + message);
        view.displayMessage("You to " + username + ": " + message);
        communication.send(username, message);
    }

    public void receiveMessage(String message) {
        model.addMessage("Other: " + message);
        view.displayMessage("Other: " + message);
        view.updateUsers(new ArrayList<>(users.keySet()));
    }

    public void sendFile(String username, String filePath) {
        model.addFile(filePath);
        view.displayFile(filePath);
        communication.sendFile(username, filePath);
    }

    public void receiveFile(String filePath) {
        model.addFile(filePath);
        view.displayFile(filePath);
    }

    public void displayMessages() {
        view.displayAllMessages();
    }

    public void handleMessage(String message) {
        String[] parts = message.split(":", 2);
        if (parts.length >= 2) {
            String username = parts[0];
            String msg = parts[1];

            model.addMessage(username + ": " + msg);
            view.displayMessage(username + ": " + msg);

            GUI_interface gui = new GUI_interface(this);
            gui.textAreaR.setText(msg);
        }
    }

    public void stopServer() {
        communication.disconnect();
    }

    public void connectToPeer(String address, int port) {
        communication.connect(address, port);
    }

    public void disconnectFromPeers() {
        communication.disconnect();
    }

    public void userConnected(String username, String address, int port) {
        users.put(username, address);
        communication.connect(address, port);
        view.userConnected(username);
    }
}