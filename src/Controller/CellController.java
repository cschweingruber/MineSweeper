package Controller;

import Common.CellClickState;
import Common.CellState;
import Model.Cell;
import View.CellView;

import java.awt.*;
import java.awt.event.MouseListener;
import java.util.Random;

public class CellController {

    private Cell cell;
    private CellView view;

    private Random rnd;
    private int rndNumber;

    int xPosCenterCell;
    int yPosCenterCell;

    CellController(CellView view, Cell cell, String id, int bombPercentage) {
        this.cell = cell;
        this.view = view;

        initCell(id, bombPercentage);
    }

    private void initCell(String id, int bombPercentage) {
        cell.setId(id);
        rnd = new Random();
        rndNumber = rnd.nextInt(100);
        if (rndNumber < bombPercentage) {
            cell.setState(CellState.BOMB);
            view.setBackground(Color.black);
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
