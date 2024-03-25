package ViewModel;

public class ChatView {
    private ChatModel model;

    public ChatView(ChatModel model) {
        this.model = model;
    }

    public void displayMessages() {
        for (String message : model.getMessages()) {
            System.out.println(message);
        }
    }
}
