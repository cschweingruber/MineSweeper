package Controller;

import Common.CellState;
import Model.Cell;
import View.CellView;

import java.awt.*;

public class CellController {

    private CellView view;
    private Cell cell;

    public CellController(double bombPercentage) {
        view = new CellView();
        cell = new Cell();

        if (Math.random()*100 < bombPercentage) {
            this.cell.setState(CellState.BOMB);
            this.view.setBackground(Color.black);
        } else {
            this.cell.setState(CellState.DEFAULT);
        }
    }

    public CellView getView() {
        return view;
    }
}