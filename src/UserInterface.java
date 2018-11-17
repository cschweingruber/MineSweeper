import javax.swing.*;
import java.awt.*;

public class UserInterface extends JFrame {

    private Field field;
    //BEST SHIET EVER
    private GridLayout layout;

    public UserInterface(int number_of_cells) throws InterruptedException {
        layout = new GridLayout();
        setLayout(layout);
        setSize(500, 500);
        setMinimumSize(new Dimension(50, 50));

        field = new Field(number_of_cells);
        add(field);
        setVisible(true);
    }

}
