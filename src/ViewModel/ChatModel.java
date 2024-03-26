package ViewModel;

import java.util.ArrayList;
import java.util.List;

public class ChatModel {
    private List<String> messages;
    private List<String> files;
    private List<String> users;

    public ChatModel() {
        this.messages = new ArrayList<>();
        this.files = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public List<String> getMessages() {
        return messages;
    }

    public void addUser(String user) {
        users.add(user);
    }

    public void removeUser(String user) {
        users.remove(user);
    }

    public void addMessage(String message) {
        messages.add(message);
    }

    public void addFile(String file) {
        files.add(file);
    }

    public List<String> getUsers() {
        return users;
    }

    public String getPeerAddress(String peerUsername) {
        return "localhost";
    }
}
