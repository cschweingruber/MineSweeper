/*
 * Copyright (c) 2018. School project
 */

package Controller;

import Common.CellClickState;
import Common.CellState;
import Model.Cell;
import View.CellView;
import View.FieldView;

import java.awt.*;
import java.awt.event.MouseListener;
import java.util.Random;

public class CellController {

    private Cell cell;
    private CellView cellView;

    private Random rnd;
    private int rndNumber;

    public CellController(int bombPercentage, String id, MouseListener cellClickedListener) {
        generateCell(bombPercentage, id, cellClickedListener);
    }

    public void generateCell(int bombPercentage, String id, MouseListener cellClickedListener) {
        //MODEL
        cell = new Cell();
        rnd = new Random();
        rndNumber = rnd.nextInt(100);
        if (rndNumber <= bombPercentage) {
            cell.setState(CellState.BOMB);
        } else {
            cell.setState(CellState.DEFAULT);
        }
        cell.setId(id);
        //VIEW
        cellView = new CellView(cellClickedListener);
    }

    public CellView getCellView() {
        return this.cellView;
    }

    public void setCellBackground(Color color) {
        this.cellView.setBackground(color);
    }

    public void setCellClickState(CellClickState cellClickState) {
        this.cell.setClickState(cellClickState);
    }

    public void revealCell() {
        this.cellView.reveal(this.cell.getBombNeighbors());
        this.cell.setClickState(CellClickState.CLICKED);
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

    public void setBombNeighbors(int bombNeighbors) {
        this.cell.setBombNeighbors(bombNeighbors);
    }
}
