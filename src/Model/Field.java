package Model;

import Controller.CellController;

public class Field {
    private int fieldSize;
    private int bombPercentage;

    public CellController[][] getCellControllers() {
        return cellControllers;
    }

    public void setCellControllers(CellController[][] cellControllers) {
        this.cellControllers = cellControllers;
    }

    private CellController[][] cellControllers;

    public int getFieldSize() {
        return fieldSize;
    }

    public void setFieldSize(int fieldSize) {
        this.fieldSize = fieldSize;
    }

    public int getBombPercentage() {
        return bombPercentage;
    }

    public void setBombPercentage(int bombPercentage) {
        this.bombPercentage = bombPercentage;
    }
}
