package TCP;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost";
        final int SERVER_PORT = 12345;

        try {
            InetAddress serverAddress = InetAddress.getByName(SERVER_ADDRESS);
            Socket socket = new Socket(serverAddress, SERVER_PORT);
            System.out.println("Connected to server at " + serverAddress.getHostAddress());

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

//            new Communication(bufferedReader, bufferedWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

