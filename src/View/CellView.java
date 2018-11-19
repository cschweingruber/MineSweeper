/*
 * Copyright (c) 2018. School project
 */

package View;

import Common.CellClickState;
import Model.Cell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class CellView extends JButton {

    Cell cell;

    public CellView(MouseListener clickListener, Cell cell) {
        this.cell = cell;
        addMouseListener(clickListener);
    }

    public void reveal(int bombNeighbors) {
        if (bombNeighbors == 0) {
            setText("");
        } else {
            setText("" + bombNeighbors);
        }
        setBackground(Color.GRAY);
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
