package Controller;

import Common.CellState;
import Model.Cell;
import View.CellView;

import java.awt.*;
import java.awt.event.MouseListener;

public class CellController {

    private CellView view;
    private Cell cell;

    public CellController(double bombPercentage) {
        this.cell = new Cell();
        this.view = new CellView(this.cell);

        if (Math.random()*100 < bombPercentage) {
            this.cell.setState(CellState.BOMB);
            this.view.setBackground(Color.black);
        } else {
            this.cell.setState(CellState.DEFAULT);
        }

    }

    public CellState getCellState() {
        return this.cell.getState();
    }

    public void setCellBombNeighbors(int bombNeighbors) {
        this.cell.setBombNeighbors(bombNeighbors);
        view.setText(String.valueOf(this.cell.getBombNeighbors()));
    }

    public CellView getView() {
        return view;
    }
}