package Controller;

import Common.CellClickState;
import Common.CellState;
import Model.Cell;
import View.CellView;

import java.util.Random;

public class CellController {

    private Cell cell;
    private CellView view;

    private Random rnd;
    private int rndNumber;

    int xPosCenterCell;
    int yPosCenterCell;

    public CellController(CellView view, Cell cell, String id, int bombPercentage) {
        this.cell = cell;
        this.view = view;

        initCell(id, bombPercentage);
    }

    private void initCell(String id, int bombPercentage) {
        rnd = new Random();
        rndNumber = rnd.nextInt();
        if (rndNumber < bombPercentage) {
            cell.setState(CellState.BOMB);
        } else {
            cell.setState(CellState.DEFAULT);
        }
    }


    public void reveal() {

    }


    public void setClickState(CellClickState cellClickState) {
        this.cell.setClickState(cellClickState);
    }

    public void setBombNeighbours(int bombNeighbours) {
        this.cell.setBombNeighbors(bombNeighbours);
    }

    public CellState getCellState() {
        return this.cell.getState();
    }

    public CellClickState getCellClickState() {
        return this.cell.getClickState();
    }

    public String getCellId() {
        return this.cell.getId();
    }

    public int getCellBombNeighbors() {
        return this.cell.getBombNeighbors();
    }

    public void setCellBombNeighbors(int bombNeighbors) {
        this.cell.setBombNeighbors(bombNeighbors);
    }


    //    private void initCell(int bombPercentage, String id) {  //TODO: REMOVE
//        rnd = new Random();
//        rndNumber = rnd.nextInt(100);
//        if (rndNumber <= bombPercentage) {
//            cell.setState(CellState.BOMB);
//        } else {
//            cell.setState(CellState.DEFAULT);
//        }
//        cell.setId(id);
//    }

//    public void setNeighbors(CellView[][] cellViews) {    //TODO: REMOVE
//        int bombCounter = 0;
//        //FOR EVERY CELL
//        for (int col = 0; col < cellViews.length; col++) {
//            for (int row = 0; row < cellViews.length; row++) {
//                //CHECK FIELD OF 9
//                for (int i = -1; i <= 1; i++) {
//                    for (int j = -1; j <= 1; j++) {
//                        try {
//                            if (i == 0 && j == 0) {}
//                            else if (cellViews[col - i][row - j].getCellState() == CellState.BOMB) {
//                                bombCounter++;
//                            }
//                        } catch (ArrayIndexOutOfBoundsException aoobex) {
//                        }
//                    }
//                }
//                //END CHECK FIELD OF 9
//                if (cellViews[col][row].getCellState() != CellState.BOMB) {
//                    cellViews[col][row].setCellBombNeighbors(bombCounter);
//                }
//                bombCounter = 0;
//            }
//        }
//        //END FIELD
//    }

//    public void revealCells(CellView[][] cellViews) {
//        if (cell.getClickState() != CellClickState.PROTECTED) {
//
//            xPosCenterCell = Integer.parseInt(cell.getId().substring(0, 1));
//            yPosCenterCell = Integer.parseInt(cell.getId().substring(1, 2));
//
//            try {
//                if (cellViews[xPosCenterCell][yPosCenterCell].getCellState() != CellState.BOMB) {
//                    if (cellViews[xPosCenterCell][yPosCenterCell].getCellBombNeighbors() == 0) {
//                        fillNoBombNeighbours();
//                    } else {
//                        cellViews[xPosCenterCell][yPosCenterCell].revealCell();
//                        cellViews[xPosCenterCell][yPosCenterCell].setCellClickState(CellClickState.CLICKED);
//                    }
//                } else {
//                    System.out.println("gameover");
//                }
//            } catch (ArrayIndexOutOfBoundsException aoobex) {
//            }
//        }
//    }

//    public void fillNoBombNeighbours() {
//        for (int i = -1; i <= 1; i++) {
//            for (int j = -1; j <= 1; j++) {
//                if (cell.getBombNeighbors() == 0 && cell.getClickState() != CellClickState.CLICKED)
//                    revealCells(cellControllers[xPosCenterCell+i][yPosCenterCell+j].getCellView());
//            }
//        }
//    }
//
//    public void setProtection(CellView cellView) {
//        if (cellView == CellClickState.PROTECTED) {
//            if (cellView.getCellState() == CellState.BOMB) {
//                cellView.setCellClickState(CellClickState.NOT_CLICKED);
//                cellView.setCellBackground(Color.black);
//            } else {
//                cellView.setCellClickState(CellClickState.NOT_CLICKED);
//            }
//        } else {
//            cellView.setCellClickState(CellClickState.PROTECTED);
//        }

}
