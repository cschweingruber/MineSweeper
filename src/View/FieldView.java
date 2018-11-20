package View;

import javax.swing.*;
import java.awt.*;

public class FieldView extends JFrame {

    public FieldView() {
        setSize(500, 500);
        setMinimumSize(new Dimension(50, 50));
        setLocationRelativeTo(null);
    }

    public void setGridLayout(int numberOfCells) {
        GridLayout gridLayout = new GridLayout(numberOfCells, numberOfCells);
        setLayout(gridLayout);
    }


}
