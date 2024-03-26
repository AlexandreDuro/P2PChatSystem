package GUI_interface;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class GUI_interface extends JFrame implements Runnable{
    private BufferedWriter writer;
    private BufferedReader reader;
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

    public GUI_interface(BufferedReader reader, BufferedWriter writer) {
        this.reader = reader;
        this.writer = writer;
        initComponents();

        Thread readerThread = new Thread(this);
        readerThread.start();
    }

    public void initComponents() {
        JFrame frame = new JFrame("Interface");
        frame.setContentPane(jpanelInterface);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // List
        String[] list = {"Alexandre", "Matthieu", "Option 3"};

        comboBoxList.setModel(new DefaultComboBoxModel(list));
        comboBoxList.setSelectedIndex(0);
        comboBoxList.addActionListener(e -> {
            JComboBox cb = (JComboBox)e.getSource();
            String selectedOption = (String)cb.getSelectedItem();
            System.out.println(selectedOption);
            //Set labelTargetUser
            labelTargetUser.setText(selectedOption + " [192.168.1.2]");
        });

        // Button S
        buttonS.addActionListener(e -> {
            try {
                writer.write(textAreaS.getText());
                writer.newLine();
                writer.flush();
                textAreaS.setText("");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    public void run() {
        while (true) {
            try {
                String line = reader.readLine();
                if (line != null) {
                    textAreaR.setText(line);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
