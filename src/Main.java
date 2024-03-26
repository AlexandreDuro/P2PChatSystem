import ChatSystem.ChatController;
import GUI_connection.GUI_connection;
import GUI_interface.GUI_interface;
import ViewModel.ChatModel;
import ViewModel.ChatView;

import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ChatModel model = new ChatModel();
        ChatView view = new ChatView(model);

        ChatController controller = new ChatController(model, view);

        GUI_connection gui_connection = new GUI_connection(controller);
    }
}