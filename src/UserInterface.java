import javax.swing.*;
import java.awt.*;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UserInterface extends JFrame {

    private Field field;
    private int NUMBER_OF_CELLS;
    //BEST SHIET EVER
    private GridLayout layout;

    public UserInterface() {
        layout = new GridLayout();
        setLayout(layout);
        setSize(1200, 500);
        setMinimumSize(new Dimension(50, 50));

        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.print("Fieldsize: ");
        NUMBER_OF_CELLS = scanner.nextInt();

        field = new Field(NUMBER_OF_CELLS);
        add(field);
        setVisible(true);
    }

}
