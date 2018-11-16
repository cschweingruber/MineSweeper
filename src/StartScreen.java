import javax.swing.*;
import java.text.NumberFormat;

public class StartScreen extends JFrame {

    private int fieldSize;

    public StartScreen() {
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(500, 500);
        setResizable(false);

        JLabel label = new JLabel("Willkommen zu Minesweeper!", SwingConstants.CENTER);
        add(label);

        JLabel descr = new JLabel("lorem ipsum dolor si amet .....");
        add(descr);

        JTextField textField = new JFormattedTextField(NumberFormat.getNumberInstance());
        ((JFormattedTextField) textField).setValue(new Double(10));
        textField.setColumns(10);
        add(textField);

        JButton button = new JButton("Zum Spiel");
        add(button);
        button.addActionListener(e -> {
            try {
                this.fieldSize = Integer.parseInt(textField.getText());
                this.setVisible(false);
                UserInterface ui = new UserInterface(this.fieldSize);
                ui.setVisible(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        setVisible(true);
    }
}
