package GUI_connection;

import ChatSystem.ChatController;

import javax.swing.*;
import java.net.UnknownHostException;
import java.net.InetAddress;

public class GUI_connection {
    private JPanel jpanelConnection;
    private JLabel labelTitleConnection;
    private JTextField textFieldUsername;
    private JButton buttonConnection;
    private ChatController controller;

    public GUI_connection(ChatController controller) {
        this.controller = controller;
        initComponents();
    }

    public void initComponents() {
        JFrame frame = new JFrame("Connection");
        frame.setContentPane(jpanelConnection);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        buttonConnection.addActionListener(e -> {
            if (textFieldUsername.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a username");
                return;
            }

            String username = textFieldUsername.getText();
            String address;
            try {
                address = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException unknownHostException) {
                JOptionPane.showMessageDialog(null, "Could not get local IP address");
                return;
            }

            int port = 12345;
            controller.userConnected(username, address, port);
            GUI_interface.GUI_interface gui_interface = new GUI_interface.GUI_interface(controller);
            frame.dispose();
        });
    }

}
