import javax.swing.*;
import java.text.NumberFormat;

public class StartScreen extends JFrame {

    private int fieldSize;

    public StartScreen() {
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(500, 500);
        setResizable(false);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Willkommen zu Minesweeper!", SwingConstants.CENTER);
        add(label);

        JLabel descr = new JLabel("Linksklick zum Aufdecken, Rechtsklick zum Schützen einer Zelle");
        add(descr);

        JFormattedTextField textField = new JFormattedTextField(NumberFormat.getNumberInstance());
        textField.setValue(10d);
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
