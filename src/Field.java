import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {
    private Cell[][] cells;
    private GridLayout gridLayout;

    public Field(int NUMBER_OF_CELLS) {
        gridLayout = new GridLayout(NUMBER_OF_CELLS, NUMBER_OF_CELLS);
        cells = new Cell[NUMBER_OF_CELLS][NUMBER_OF_CELLS];
        generateField();
    }

    private void generateField() {
        setLayout(gridLayout);
        System.out.println("cells length: " + cells.length);
        System.out.println("getWidth(): " + getWidth());
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                cells[i][j] = new Cell(String.valueOf(i) + String.valueOf(j));
                add(cells[i][j]);
            }
        }
    }
}
