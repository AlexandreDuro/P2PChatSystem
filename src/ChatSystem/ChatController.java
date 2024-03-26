package ChatSystem;

import GUI_interface.GUI_interface;
import ViewModel.ChatView;
import ViewModel.ChatModel;
import TCP.TCPClient;
import TCP.TCPServer;

public class ChatController {
    private ChatModel model;
    private ChatView view;
    private TCPClient tcpClient;
    private TCPServer tcpServer;

    public ChatController(ChatModel model, ChatView view, TCPClient tcpClient, TCPServer tcpServer) {
        this.model = model;
        this.view = view;
        this.tcpClient = tcpClient;
        this.tcpServer = tcpServer;
    }

//    public void sendMessage(String message) {
//        model.addMessage("You: " + message);
//        view.displayMessage("You: " + message);
//        tcpClient.send(message);
//    }
//
//    public void receiveMessage(String message) {
//        model.addMessage("Other: " + message);
//        view.displayMessage("Other: " + message);
//    }
//
//    public void sendFile(String filePath) {
//        model.addFile(filePath);
//        view.displayFile(filePath);
//        tcpClient.sendFile(filePath);
//    }
//
//    public void receiveFile(String filePath) {
//        model.addFile(filePath);
//        view.displayFile(filePath);
//    }
//
//    public void displayMessages() {
//        view.displayAllMessages();
//    }
//
//    public void stopServer() {
//        tcpServer.stopListening();
//    }
//
//    public void connectToPeer(String address, int port) {
//        tcpServer = new TCPServer(port, this);
//        tcpServer.startListening();
//        tcpClient = new TCPClient(address, port, this);
//        tcpClient.connect();
//    }
//
//    public void disconnectFromPeers() {
//        tcpClient.disconnect();
//        tcpServer.stopListening();
//    }
}
