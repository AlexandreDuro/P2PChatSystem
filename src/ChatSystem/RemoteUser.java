package ChatSystem;

public class RemoteUser {
    private int userID;
    private String username;

    public RemoteUser(int userID, String username) {
        this.userID = userID;
        this.username = username;
    }

    public void sendMessage(String message) {
        // Send message to user
    }

    public void receiveMessage(String message) {
        // Receive message from user
    }

    public void sendFile(String file) {
        // Send file to user
    }

    public void receiveFile(String file) {
        // Receive file from user
    }
}
