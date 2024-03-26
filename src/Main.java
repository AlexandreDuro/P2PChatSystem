import ChatSystem.ChatController;
import ViewModel.ChatModel;
import ViewModel.ChatView;

import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ChatModel model = new ChatModel();
        ChatView view = new ChatView(model);

        ChatController controller = new ChatController(model, view);

        String peerAddress = "localhost";
        int peerPort = 12345;

        try {
            controller.connectToPeer(peerAddress, peerPort);
        } catch (Exception e) {
            System.out.println("Failed to connect to peer: " + e.getMessage());
            return;
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter command (send_message, send_file, display_messages, quit):");
            String command = scanner.nextLine();

            if (command.equals("send_message")) {
                System.out.println("Enter message:");
                String message = scanner.nextLine();
                try {
                    controller.sendMessage(message);
                } catch (Exception e) {
                    System.out.println("Failed to send message: " + e.getMessage());
                }
            } else if (command.equals("send_file")) {
                System.out.println("Enter file path:");
                String filePath = scanner.nextLine();
                try {
                    controller.sendFile(filePath);
                } catch (Exception e) {
                    System.out.println("Failed to send file: " + e.getMessage());
                }
            } else if (command.equals("display_messages")) {
                for (String message : model.getMessages()) {
                    System.out.println(message);
                }
            } else if (command.equals("quit")) {
                controller.stopServer();
                break;
            } else {
                System.out.println("Unknown command.");
            }
        }

        try {
            controller.disconnectFromPeers();
        } catch (Exception e) {
            System.out.println("Failed to disconnect from peers: " + e.getMessage());
        }

        scanner.close();
    }
}