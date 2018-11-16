import javax.swing.*;
import java.awt.*;

public class Field extends JPanel{

    /**
     * Order of cells in the cell array (field): 00 01  02
     *                                           10 11  12
     *                                           20 21  22
     */

    public Cell[][] cells;
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
                cells[i][j] = new Cell();
                cells[i][j].setId(String.valueOf(i) + String.valueOf(j));
                add(cells[i][j]);
            }
        }
    }

//    public Cell getCellById(String cellId) {
//        Cell cell = new Cell();
//        for (int i = 0; i < cells.length; i++) {
//            for (int j = 0; j < cells.length; j++) {
//                if (cells[i][j].getId().equals(cellId)) {
//                    cell = cells[i][j];
//                    break;
//                }
//            }
//        }
//        return cell;
//    }
}
