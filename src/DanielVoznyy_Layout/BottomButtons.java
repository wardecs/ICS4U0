import javax.swing.*;
import java.awt.*;

public class BottomButtons {

    public BottomButtons() {
        JFrame frame = new JFrame("Bottom Buttons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new BorderLayout());


        JPanel topPane = new JPanel();
        topPane.setLayout(new FlowLayout());
        topPane.add(new JButton("top"));
        frame.add(topPane, BorderLayout.NORTH);

        JPanel bottomPane = new JPanel();
        bottomPane.setLayout(new GridLayout(1, 3));
        bottomPane.add(new JButton("Yes"));
        bottomPane.add(new JButton("No"));
        bottomPane.add(new JButton("??"));
        frame.add(bottomPane, BorderLayout.SOUTH);

        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new BottomButtons();
    }
}
