package TCP;

import ChatSystem.ChatController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private ChatController controller;

    public ClientHandler(Socket clientSocket, ChatController controller) {
        this.clientSocket = clientSocket;
        this.controller = controller;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received message: " + message);
                controller.handleMessage(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}