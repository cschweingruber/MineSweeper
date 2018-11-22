package Controller;

import Model.Cell;
import View.CellView;

public class CellController {
    private CellView view;
    private Cell cell;

    public CellController() {
        view = new CellView();
        cell = new Cell();
    }
}