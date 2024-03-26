package ChatSystem;

public class DistantUser {
    private int userID;
    private String username;
    private String ip;

    public DistantUser(int userID, String username, String ip) {
        this.userID = userID;
        this.username = username;
        this.ip = ip;
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

    public String getIp() {
        return ip;
    }
}
