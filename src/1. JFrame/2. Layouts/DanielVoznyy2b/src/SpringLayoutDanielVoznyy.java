import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * @author Daniel Voznyy
 * @version 1 03.29.19
 */
public class SpringLayoutDanielVoznyy extends JPanel {
    int pad = 100;

    public SpringLayoutDanielVoznyy() {
        SpringLayout layout = new SpringLayout();
        setLayout(layout);

        JButton anchor = new JButton("SpringLayout anchor");
        add(anchor);

        JPanel moveButtons = new JPanel(new GridLayout(1, 2));
        JButton increase = new JButton("Increase pad");
        increase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pad += 50;
                layout.putConstraint(SpringLayout.WEST, moveButtons, pad, SpringLayout.EAST, anchor);
                increase.revalidate();
                increase.repaint();
            }
        });
        JButton decrease = new JButton("Decrease pad");
        decrease.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pad -= 50;
                layout.putConstraint(SpringLayout.WEST, moveButtons, pad, SpringLayout.EAST, anchor);
                increase.revalidate();
                increase.repaint();
            }
        });

        moveButtons.add(decrease);
        moveButtons.add(increase);
        add(moveButtons);

        layout.putConstraint(SpringLayout.WEST, moveButtons, pad, SpringLayout.EAST, anchor);
    }
}
