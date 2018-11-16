import javax.swing.*;

public class UserInterface extends JFrame {

    private Field field;

    public UserInterface() {
        field = new Field(10);
        add(field);
        setVisible(true);
    }
}
