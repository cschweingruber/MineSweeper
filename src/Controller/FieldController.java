
package Controller;

import Common.CellClickState;
import Common.CellState;
import Model.Cell;
import Model.Field;
import View.CellView;
import View.FieldView;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FieldController {

    private Field field;
    private FieldView view;

    private CellController controller;

    private int xPosCenterCell;
    private int yPosCenterCell;

    FieldController(FieldView view, Field field) {
        this.view = view;
        this.field = field;

        initField(view.getFieldSize());

        view.setGridLayout();
        view.setVisible(true);
    }

    private void initField(int numberOfCells) {
        this.field.setFieldSize(numberOfCells);
        //
        field.setBombPercentage(15);
        //

        for (int col = 0; col < field.getFieldSize(); col++) {
            for (int row = 0; row < field.getFieldSize(); row++) {
                Cell cell = new Cell();
                CellView cellView = new CellView(cell);
                controller = new CellController(cellView, cell, String.valueOf(col) + String.valueOf(row), field.getBombPercentage());
                CellController finalController = controller;
                cellView.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        CellView sourceCell = (CellView) e.getSource();
                        if (SwingUtilities.isLeftMouseButton(e)) {
                            revealCell(sourceCell);
                        } else {
//                            finalController.setProtection(sourceCell);
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

                view.addCellView(cellView);
            }
        }
        setBombNeighbours();
    }

    public void revealCell(CellView sourceCell) {
        CellView[][] field = view.getField();
        if (sourceCell.getCellClickState() != CellClickState.PROTECTED) {

            xPosCenterCell = Integer.parseInt(sourceCell.getId().substring(0, 1));
            yPosCenterCell = Integer.parseInt(sourceCell.getId().substring(1, 2));

            try {
                if (field[xPosCenterCell][yPosCenterCell].getCellState() != CellState.BOMB) {
                    if (field[xPosCenterCell][yPosCenterCell].getCellBombNeighbors() == 0) {
                        fillNoBombNeighbours();
                    } else {
                        field[xPosCenterCell][yPosCenterCell].revealCell();
                        field[xPosCenterCell][yPosCenterCell].setCellClickState(CellClickState.CLICKED);
                    }
                } else {
                    System.out.println("gameover");
                }
            } catch (ArrayIndexOutOfBoundsException aoobex) {
            }
        }
    }

    private void setBombNeighbours() {
        CellView[][] field = view.getField();
        int bombCounter = 0;
        //FOR EVERY CELL
        for (int col = 0; col < field.length; col++) {
            for (int row = 0; row < field.length; row++) {
                //CHECK FIELD OF 9
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        try {
                            if (i == 0 && j == 0) {}
                            else if (field[col - i][row - j].getCellState() == CellState.BOMB) {
                                bombCounter++;
                            }
                        } catch (ArrayIndexOutOfBoundsException aoobex) {
                        }
                    }
                }
                //END CHECK FIELD OF 9
                if (field[col][row].getCellState() != CellState.BOMB) {
                    field[col][row].setCellBombNeighbors(bombCounter);
                }
                bombCounter = 0;
            }
        }
        //END FIELD
    }

    public int getBombPercentage() {
        return this.field.getBombPercentage();
    }

    public void setBombPercentage(int bombPercentage) {
        this.field.setBombPercentage(bombPercentage);
    }


//    public void createField(CellView[][] cellViews) {
//        for (int i = 0; i < cellViews.length; i++) {
//            for (int j = 0; j < cellViews.length; j++) {
//                int finalJ = j;
//                int finalI = i;
//                cellViews[i][j] = new CellView(getBombPercentage(), String.valueOf(i) + String.valueOf(j), new MouseListener() {
//                    @Override
//                    public void mouseClicked(MouseEvent e) {
//                        if (SwingUtilities.isLeftMouseButton(e)) {
//                            System.out.println("click");
//                            CellView cellView = (CellView) e.getSource();
//                            cellView.reveal(cellViews);
//                        } else {
//                            cellViews[finalI][finalJ].setProtection();
//                        }
//                    }
//
//                    @Override
//                    public void mousePressed(MouseEvent e) {
//
//                    }
//
//                    @Override
//                    public void mouseReleased(MouseEvent e) {
//
//                    }
//
//                    @Override
//                    public void mouseEntered(MouseEvent e) {
//
//                    }
//
//                    @Override
//                    public void mouseExited(MouseEvent e) {
//
//                    }
//                });
//                cellViews[i][j].setNeighbours(cellViews);
//                view.add(cellViews[i][j]);
//            }
//        }
//    }

}
