package GUI_interface;

import javax.swing.*;

public class GUI_interface extends JFrame{
    private JComboBox comboBoxList;
    private JLabel labelComboBoxList;
    private JLabel labelTitleTargetUser;
    private JLabel labelTargetUser;
    private JLabel labelR;
    private JLabel labelS;
    private JTextArea textAreaR;
    private JTextArea textAreaS;
    private JButton buttonS;
    private JPanel jpanelInterface;

    public GUI_interface() {
        initComponents();
    }

    public void initComponents() {
        JFrame frame = new JFrame("Interface");
        frame.setContentPane(jpanelInterface);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }



}
