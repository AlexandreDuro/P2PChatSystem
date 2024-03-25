package TCP;

import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;

public class TCPServer {

    public static void main(String[] args){
        final int PORT =12345;
        try (ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("Server waiting on port " + PORT);

            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected :" + socket.getInetAddress().getHostAddress());

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                new Main(bufferedReader, bufferedWriter);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Server error: " + e.getMessage());
        }
    }
}
