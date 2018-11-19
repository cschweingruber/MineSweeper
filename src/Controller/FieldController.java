
package Controller;

import Common.CellClickState;
import Common.CellState;
import View.CellView;
import View.FieldView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FieldController {

    FieldView field;
    private CellController[][] cellControllers;
    private int bombPercentage = 15;
    private int xPosCenterCell;
    private int yPosCenterCell;

    public FieldController(int number_of_cells) {
        field = new FieldView();
        cellControllers = new CellController[number_of_cells][number_of_cells];
        for (int i = 0; i < cellControllers.length; i++) {
            for (int j = 0; j < cellControllers.length; j++) {
                int finalI = i;
                int finalJ = j;
                cellControllers[i][j] = new CellController(bombPercentage, String.valueOf(i) + String.valueOf(j), new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (SwingUtilities.isLeftMouseButton(e)) {
                            System.out.println("click");
                            reveal((CellView) e.getSource());
                        } else {
                            setProtection(cellControllers[finalI][finalJ]);
                        }
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
                field.add(cellControllers[i][j].getCellView());
            }
        }
        field.setGridLayout(number_of_cells);
        setNeighbors();
        field.setVisible(true);
    }

    private void setNeighbors() {
        int bombCounter = 0;
        //FOR EVERY CELL
        for (int col = 0; col < cellControllers.length; col++) {
            for (int row = 0; row < cellControllers.length; row++) {
                //CHECK FIELD OF 9
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        try {
                            if (i == 0 && j == 0) {}
                            else if (cellControllers[col - i][row - j].getCellState() == CellState.BOMB) {
                                bombCounter++;
                            }
                        } catch (ArrayIndexOutOfBoundsException aoobex) {
                        }
                    }
                }
                //END CHECK FIELD OF 9
                if (cellControllers[col][row].getCellState() != CellState.BOMB) {
                    cellControllers[col][row].setCellBombNeighbors(bombCounter);
                }
                bombCounter = 0;
            }
        }
        //END FIELD
    }

    public void reveal(CellView cell) {
        if (cell.getCellClickState() != CellClickState.PROTECTED) {

            xPosCenterCell = Integer.parseInt(cell.getCellId().substring(0, 1));
            yPosCenterCell = Integer.parseInt(cell.getCellId().substring(1, 2));

            try {
                if (cellControllers[xPosCenterCell][yPosCenterCell].getCellState() != CellState.BOMB) {
                    if (cellControllers[xPosCenterCell][yPosCenterCell].getCellBombNeighbors() == 0) {
                        fillNoBombNeighbours();
                    } else {
                        cellControllers[xPosCenterCell][yPosCenterCell].revealCell();
                        cellControllers[xPosCenterCell][yPosCenterCell].setCellClickState(CellClickState.CLICKED);
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
                if (cellControllers[xPosCenterCell+i][yPosCenterCell+j].getCellView().getCellBombNeighbours() == 0 && cellControllers[xPosCenterCell+i][yPosCenterCell+j].getCellView().getCellClickState() != CellClickState.CLICKED)
                    reveal(cellControllers[xPosCenterCell+i][yPosCenterCell+j].getCellView());
            }
        }
    }

    public void setProtection(CellController cellController) {
        if (cellController.getCellClickState() == CellClickState.PROTECTED) {
            if (cellController.getCellState() == CellState.BOMB) {
                cellController.setCellClickState(CellClickState.NOT_CLICKED);
                cellController.setCellBackground(Color.black);
            } else {
                cellController.setCellClickState(CellClickState.NOT_CLICKED);
            }
        } else {
            cellController.setCellClickState(CellClickState.PROTECTED);
        }
    }

}
