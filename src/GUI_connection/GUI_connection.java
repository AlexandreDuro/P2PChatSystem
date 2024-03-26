package GUI_connection;

import javax.swing.*;

public class GUI_connection {
    private JPanel jpanelConnection;
    private JLabel labelTitleConnection;
    private JTextField textFieldUsername;
    private JButton buttonConnection;

    public GUI_connection() {
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

//            GUI_interface.GUI_interface gui_interface = new GUI_interface.GUI_interface();
//            frame.dispose();
        });
    }
}
