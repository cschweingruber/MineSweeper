import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Field extends JPanel {
    private Cell[][] cells;

    public Field(int size) {
        cells = new Cell[size][size];
        generateField();
    }

    private void generateField() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                cells[i][j] = new Cell();
                add(cells[i][j]);
            }
        }
    }
}
