/*
 * Copyright (c) 2018. School project
 */

package View;

import javax.swing.*;
import java.awt.*;

public class FieldView extends JFrame {

    private GridLayout gridLayout;

    public FieldView() {
        setSize(500, 500);
        setMinimumSize(new Dimension(50, 50));
        setLocationRelativeTo(null);
    }

    public void setGridLayout(int number_of_cells) {
        gridLayout = new GridLayout(number_of_cells, number_of_cells);
        setLayout(gridLayout);
    }
}
