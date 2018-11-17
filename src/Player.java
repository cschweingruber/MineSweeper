import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class Player extends MouseAdapter {

    private Cell cell;

    public boolean gameover;

    @Override
    public void mouseClicked(MouseEvent e) {
        /*
         * Cell which has been clicked
         */
        cell = (Cell) e.getSource();
        if (SwingUtilities.isLeftMouseButton(e)) {
            if (cell.getClickState() != CellClickState.PROTECTED) {

                int xPosCenterCell = Integer.parseInt(cell.getId().substring(0, 1));
                int yPosCenterCell = Integer.parseInt(cell.getId().substring(1, 2));

                //check if directly hit a bomb
//                if (Field.cells[xPosCenterCell][yPosCenterCell].getState() == CellState.BOMB) {
//                    //TODO: gameover
//                    System.out.println("gameOver!!");
//                    gameover = true;
//                }

                try {
                    if (Field.cells[xPosCenterCell][yPosCenterCell].getState() != CellState.BOMB) {
                        if (Field.cells[xPosCenterCell][yPosCenterCell].getBombNeighbors() == 0 && Field.cells[xPosCenterCell][yPosCenterCell].getClickState() != CellClickState.CLICKED) {
                            for (int i = -1; i <= 1; i++) {
                                for (int j = -1; j <= 1; j++) {
                                    if (Field.cells[xPosCenterCell + i][yPosCenterCell + j].getBombNeighbors() == 0) {
                                        Field.cells[(xPosCenterCell + i) + i][(yPosCenterCell + j) + j].reveal();
                                        Field.cells[(xPosCenterCell + i) + i][(yPosCenterCell + j) + j].setClickState(CellClickState.CLICKED);
                                    }
                                }
                            }
                        } else {
                            System.out.println("else x: " + xPosCenterCell);
                            System.out.println("else y: " + yPosCenterCell);
                            Field.cells[xPosCenterCell][yPosCenterCell].reveal();
                            Field.cells[xPosCenterCell][yPosCenterCell].setClickState(CellClickState.CLICKED);
                        }
                    } else {
                        gameover = true;
                        System.out.println("gameover");
                    }
                } catch (ArrayIndexOutOfBoundsException aoobex) {
                }
            }
        } else {
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
}

