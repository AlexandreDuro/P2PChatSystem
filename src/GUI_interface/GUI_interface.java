package GUI_interface;

import ChatSystem.ChatController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GUI_interface extends JFrame{
    private JComboBox<String> comboBoxList;
    private JLabel labelComboBoxList;
    private JLabel labelTitleTargetUser;
    private JLabel labelTargetUser;
    private JLabel labelR;
    private JLabel labelS;
    private JTextArea textAreaR;
    private JTextArea textAreaS;
    private JButton buttonS;
    private JPanel jpanelInterface;
    private ChatController controller;

    public GUI_interface(ChatController controller) {
        this.controller = controller;
        initComponents();
    }

    public void initComponents() {
        JFrame frame = new JFrame("Interface");
        frame.setContentPane(jpanelInterface);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        buttonS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedUser = (String) comboBoxList.getSelectedItem();
                String message = textAreaS.getText();
                controller.sendMessage(selectedUser, message);
            }
        });
    }

    public void updateUsers(List<String> users) {
        comboBoxList.removeAllItems();
        for (String user : users) {
            comboBoxList.addItem(user);
        }
    }
}