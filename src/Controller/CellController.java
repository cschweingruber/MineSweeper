package Controller;

import Common.CellState;
import Model.Cell;
import View.CellView;
import java.awt.*;

public class CellController {

    private CellView view;
    private Cell cell;
    private CellController[][] neighbors;

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

    public void setNeighbors(CellController[][] neighbors) {
        this.neighbors = neighbors;
        int bombNeighbors = 0;
        for (int col = 0; col < this.neighbors.length; col++) {
            for (int row = 0; row < this.neighbors.length; row++) {
                try {
                    if (this.neighbors[row][col].getState() == CellState.BOMB) {
                        bombNeighbors++;
                    }
                } catch (Exception e) {}
            }
        }
        this.cell.setBombNeighbors(bombNeighbors);
        view.setText(String.valueOf(this.cell.getBombNeighbors()));

    }

    public CellState getState() {
        return this.cell.getState();
    }


    public CellView getView() {
        return view;
    }
}