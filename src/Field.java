import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Field extends JPanel {

    /**
     * Order of cells in the cell array (field): 00 01  02
     *                                           10 11  12
     *                                           20 21  22
     */

    public static Cell[][] cells;
    private GridLayout gridLayout;
    private Random rnd;
    private int rndNumber;
    private CellState rndCellState;
    private int bombPercentage = 15;

    public Field(int NUMBER_OF_CELLS) {
        gridLayout = new GridLayout(NUMBER_OF_CELLS, NUMBER_OF_CELLS);
        cells = new Cell[NUMBER_OF_CELLS][NUMBER_OF_CELLS];
        generateField();
    }

    private void generateField() {
        setLayout(gridLayout);
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                rnd = new Random();
                rndNumber = rnd.nextInt(100);
                if (rndNumber <= bombPercentage) {
                    rndCellState = CellState.BOMB;
                } else {
                    rndCellState = CellState.DEFAULT;
                }
                cells[i][j] = new Cell(rndCellState);
                cells[i][j].setId(String.valueOf(i) + String.valueOf(j));
                add(cells[i][j]);
            }
        }
    }
}
