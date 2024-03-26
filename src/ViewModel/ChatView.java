package ViewModel;

import ViewModel.ChatModel;

import java.util.List;

public class ChatView {
    private ChatModel model;

    public ChatView(ChatModel model) {
        this.model = model;
    }

    public void displayMessage(String message) {
        System.out.println("Message: " + message);
    }

    public void displayFile(String filePath) {
        System.out.println("File received: " + filePath);
    }

    public void displayAllMessages() {
        for (String message : model.getMessages()) {
            System.out.println(message);
        }
    }

    public void userConnected(String username) {
        System.out.println("User connected: " + username);
    }

    public void displayUsers(List<String> usernames) {
        System.out.println("Connected users: " + String.join(", ", usernames));
    }

    public void updateUsers(List<String> usernames) {
        System.out.println("Updated user list: " + String.join(", ", usernames));
    }
}