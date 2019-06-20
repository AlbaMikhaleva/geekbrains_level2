package lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chat extends JFrame {

    JButton btn1;
    JTextArea textArea;

    public Chat() {
        setBounds(300, 200, 600, 400);
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        add(textArea, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 80));
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        JTextField textField = new JTextField();
        panel.add(textField);
        btn1 = new JButton("Enter");
        panel.add(btn1);
        add(panel, BorderLayout.SOUTH);

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append(textField.getText() + "\n");
                textField.setText("");
            }
        };


        btn1.addActionListener(al);
        textField.addActionListener(al);

        setVisible(true);
    }

}


