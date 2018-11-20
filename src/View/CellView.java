/*
 * Copyright (c) 2018. School project
 */

package View;

import Common.CellClickState;
import Common.CellState;
import Controller.CellController;
import Model.Cell;

import javax.swing.*;
import java.awt.event.MouseListener;

public class CellView extends JButton {

    private CellController controller;
    private Cell cell;

    public CellView(int bombPercentage, String id, MouseListener clickListener) {
        controller = new CellController(bombPercentage, id,  clickListener, this, cell);
        addMouseListener(clickListener);
    }

    public void setProtection(CellView view) {
        this.controller.setProtection(view);
    }

    public void setNeighbours(CellView[][] views) {
        this.controller.setNeighbors(views);
    }

    public void reveal(CellView[][] views) {
        this.controller.revealCells(views);
    }

    public void setCellBombNeighbors(int bombNeighbours) {
        this.cell.setBombNeighbors(bombNeighbours);
    }

    public int getCellBombNeighbors() {
        return this.cell.getBombNeighbors();
    }

    public CellState getCellState() {
        return this.cell.getState();
    }

    public void revealCell() {
        this.controller.revealCell();
    }

    public void setCellClickState(CellClickState clickState) {
        this.cell.setClickState(clickState);
    }

    public CellClickState getCellClickState() {
        return this.cell.getClickState();
    }

    public String getCellId() {
        return this.cell.getId();
    }

    public int getCellBombNeighbours() {
        return this.cell.getBombNeighbors();
    }

//    public CellClickState getCellClickState() {
//        return this.cell.getClickState();
//    }
}
