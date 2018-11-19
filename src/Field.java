import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Field extends JPanel {

    /**
     * Order of cells in the cell array (field): 00 01  02
     *                                           10 11  12
     *                                           20 21  22
     */

    public Cell[][] cells;
    private GridLayout gridLayout;
    private Random rnd;
    private int rndNumber;
    private CellState rndCellState;
    private int bombPercentage = 15;

    static int xPosCenterCell;
    static int yPosCenterCell;

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
                cells[i][j] = new Cell(rndCellState, new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        setNeighbors();
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
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

    public void reveal(Cell cell) {
        if (cell.getClickState() != CellClickState.PROTECTED) {

            xPosCenterCell = Integer.parseInt(cell.getId().substring(0, 1));
            yPosCenterCell = Integer.parseInt(cell.getId().substring(1, 2));

            try {
                if (cells[xPosCenterCell][yPosCenterCell].getState() != CellState.BOMB) {
                    if (cells[xPosCenterCell][yPosCenterCell].getBombNeighbors() == 0) {
                        fillNoBombNeighbours();
                    } else {
                        cells[xPosCenterCell][yPosCenterCell].reveal();
                        cells[xPosCenterCell][yPosCenterCell].setClickState(CellClickState.CLICKED);
                    }
                } else {
//                    gameover = true;
                    System.out.println("gameover");
                }
            } catch (ArrayIndexOutOfBoundsException aoobex) {
            }
        }
    }

    public void fillNoBombNeighbours() {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (cells[xPosCenterCell+i][yPosCenterCell+j].getBombNeighbors() == 0 && cells[xPosCenterCell][yPosCenterCell].getClickState() != CellClickState.CLICKED)
                    reveal(cells[xPosCenterCell+i][yPosCenterCell+j]);
            }
        }
    }

    public void setProtection(Cell cell) {
        if (cell.getClickState() == CellClickState.PROTECTED) {
            if (cell.getState() == CellState.BOMB) {
                cell.setClickState(CellClickState.NOT_CLICKED);
                cell.setBackground(Color.black);
            } else {
                cell.setClickState(CellClickState.NOT_CLICKED);
            }
        } else {
            cell.setClickState(CellClickState.PROTECTED);
        }
    }
}
