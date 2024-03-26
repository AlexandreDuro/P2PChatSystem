package ViewModel;

import ViewModel.ChatModel;

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
}