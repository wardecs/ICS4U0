import javax.swing.*;
import java.awt.*;

public class Envelope {

    public Envelope() {
        JFrame frame = new JFrame("Envelope");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setVisible(true);
        frame.add(new Drawing());
    }

    class Drawing extends JComponent {
        public void paint(Graphics g) {
            g.setColor(Color.RED);
            g.fillRect(10, 10, 50, 50);
            g.setColor(Color.BLACK);
            g.drawString("Daniel Voznyy", 75, 25);
            g.drawString("123 ABC street", 75, 45);

        }
    }

    public static void main(String[] args) {
        new Envelope();
    }
}
