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
        setNeighbors();
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

    private void setNeighbors() {
        int bombCounter = 0;
        //FOR EVERY CELL
        for (int col = 0; col < cells.length; col++) {
            for (int row = 0; row < cells.length; row++) {
                //CHECK FIELD OF 9
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        try {
                            if (i == 0 && j == 0) {}
                            else if (cells[col - i][row - j].getState() == CellState.BOMB) {
                                bombCounter++;
                            }
                        } catch (ArrayIndexOutOfBoundsException aoobex) {
                        }
                    }
                }
                //END CHECK FIELD OF 9
                if (cells[col][row].getState() != CellState.BOMB) {
                    cells[col][row].setBombNeighbors(bombCounter);
                }
                bombCounter = 0;
            }
        }
        //END FIELD
    }
}
