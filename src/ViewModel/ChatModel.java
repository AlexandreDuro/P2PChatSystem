package ViewModel;

import java.util.List;

public class ChatModel {
    private List<String> messages;
    private List<String> users;

    public ChatModel(List<String> messages, List<String> users) {
        this.messages = messages;
        this.users = users;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void addUserToList(String user) {
        users.add(user);
    }

    public void removeUserFromList(String user) {
        users.remove(user);
    }

    public void addMessage(String message) {
        messages.add(message);
    }

    public void addFile(String file) {
        messages.add(file);
    }

    public List<String> getUsers() {
        return users;
    }
}
