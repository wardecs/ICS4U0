import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The TextTest class is an extension of JPanel that allows users to calculate
 * the square of a number but typing an integer into the input box, then clicking
 * the Calculate button. It does error-trapping to ensure the user is aware of faulty
 * input, and to avoid crashing.
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * @author Daniel Voznyy
 * @version 1 03.20.19
 */
public class TextTest extends JPanel {
    /**
     *Draws the input prompt message, then the text fields and the button
     */
    public TextTest() {
        inputPrompt();
        outputResult();
    }

    /**
     * A label that asks the user to enter a value
     */
    public void inputPrompt(){
        JLabel enterValue;
        enterValue = new JLabel("Enter a value");
        enterValue.setFont(new Font("Serif", Font.PLAIN, 16));
        add(enterValue);
    }

    /**
     * Two text fields, the input field allows for an integer to be inputted.
     * After the Calculate button is pressed, the output field will display the
     * input field's squared value. If the input is improperly formatted, the
     * program will display a message in the output field and clear the input
     * field.
     */
    public void outputResult(){
        JButton calculate = new JButton("Calculate");
        JTextField inputField = new JTextField(20);
        JTextField outputField = new JTextField(25);
        add(inputField);
        add(outputField);
        add(calculate);
        calculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int number = Integer.parseInt(inputField.getText());
                    outputField.setText("The square is " + number * number);
                } catch(NumberFormatException nfe){
                    inputField.setText("");
                    outputField.setText("Sorry, that is not a valid value");
                }
            }
        });
    }
}
