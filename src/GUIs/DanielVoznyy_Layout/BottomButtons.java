package GUIs.DanielVoznyy_Layout;

import javax.swing.*;
import java.awt.*;

public class BottomButtons {

    public BottomButtons(){
        JFrame frame = new JFrame("Bottom Buttons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new BorderLayout());
        frame.add(new JButton("top"), BorderLayout.NORTH);

        JPanel borderPane = new JPanel();
        borderPane.setLayout(new GridLayout(1, 3));
        borderPane.add(new JButton("Yes"));
        borderPane.add(new JButton("No"));
        borderPane.add(new JButton("??"));
        frame.add(borderPane, BorderLayout.SOUTH);

        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new BottomButtons();
    }
}
