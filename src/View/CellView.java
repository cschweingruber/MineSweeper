/*
 * Copyright (c) 2018. School project
 */

package View;

import Common.CellClickState;
import Common.CellState;
import Model.Cell;

import javax.swing.*;

public class CellView extends JButton {

    private Cell cell;

    public CellView(Cell cell) {
        this.cell = cell;
    }

    public String getId() {
        return this.cell.getId();
    }

    public CellClickState getCellClickState() {
        return this.cell.getClickState();
    }

    public CellState getCellState() {
        return this.cell.getState();
    }

    public void setCellBombNeighbors(int bombNeighbors) {
        this.cell.setBombNeighbors(bombNeighbors);
    }
}
