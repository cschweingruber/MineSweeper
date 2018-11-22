package View;
import Controller.CellController;

import javax.swing.*;
import java.awt.*;

public class FieldView extends JFrame {
    public FieldView(int numberOfCells, CellController[][] cellControllers) {
        setSize(500, 500);
        setMinimumSize(new Dimension(50, 50));
        setLocationRelativeTo(null);

        for (int col = 0; col < cellControllers.length; col++) {
            for (int row = 0; row < cellControllers.length; row++) {
                add(cellControllers[col][row].getView());
            }
        }

        setLayout(new GridLayout(numberOfCells, numberOfCells));

        setVisible(true);
    }
}