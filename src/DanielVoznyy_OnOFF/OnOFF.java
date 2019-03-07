import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OnOFF implements ActionListener {

    JButton onButton = new JButton("On");
    JButton offButton = new JButton("Off");
    JFrame frame = new JFrame("Bottom Buttons");

    public OnOFF() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new FlowLayout());
        onButton.addActionListener(this);
        frame.add(onButton);
        offButton.addActionListener(this);
        frame.add(offButton);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new OnOFF();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == onButton)
            frame.getContentPane().setBackground(Color.WHITE);
        if (e.getSource() == offButton)
            frame.getContentPane().setBackground(Color.BLACK);
    }
}
