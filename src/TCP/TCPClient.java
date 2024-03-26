package TCP;

import ChatSystem.ChatController;
import GUI_connection.GUI_connection;
import GUI_interface.GUI_interface;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient {
    private String serverAddress;
    private int serverPort;

    public TCPClient(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;

        try {
            InetAddress serverAddress2 = InetAddress.getByName(serverAddress);
            Socket socket = new Socket(serverAddress2, serverPort);
            System.out.println("Connected to server at " + serverAddress);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            GUI_interface gui_interface = new GUI_interface(bufferedReader, bufferedWriter);

            String response = bufferedReader.readLine();
            System.out.println("Server responded: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
