package ChatSystem;

import ViewModel.ChatView;
import ViewModel.ChatModel;

public class ChatController {
    private ChatModel model;
    private ChatView view;

    public ChatController(ChatModel model, ChatView view) {
        this.model = model;
        this.view = view;
    }

    public void sendMessage(String message) {
        model.addMessage(message);
    }

    public void receiveMessage(String message) {
        model.addMessage(message);
    }

    public void sendFile(String file) {
        model.addFile(file);
    }

    public void receiveFile(String file) {
        model.addFile(file);
    }

    public void displayMessages() {
        view.displayMessages();
    }
}
