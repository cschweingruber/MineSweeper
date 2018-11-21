package View;

import javax.swing.*;
import java.awt.*;

public class FieldView extends JFrame {

    private int fieldSize;

    CellView[][] field;
    int rowCounter = 0;
    int colCounter = 0;

    public FieldView(int fieldSize) {
        this.fieldSize = fieldSize;
        field = new CellView[this.fieldSize][this.fieldSize];
        setSize(500, 500);
        setMinimumSize(new Dimension(50, 50));
        setLocationRelativeTo(null);
    }

    public void addCellView(CellView cellView) {
        this.field[colCounter][rowCounter] = cellView;
        add(this.field[colCounter][rowCounter]);
        colCounter++;
        if (colCounter == fieldSize) {
            colCounter = 0;
            rowCounter++;
        }
    }

    public void setGridLayout() {
        GridLayout gridLayout = new GridLayout(this.fieldSize, this.fieldSize);
        setLayout(gridLayout);
    }

    public CellView[][] getField() {
        return field;
    }

    public int getFieldSize() {
        return fieldSize;
    }

    public void setFieldSize(int fieldSize) {
        this.fieldSize = fieldSize;
    }
}
