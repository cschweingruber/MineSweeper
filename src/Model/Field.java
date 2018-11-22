package Model;

import Controller.CellController;

public class Field {

    private double bombPercentage;
    private int fieldSize;
    private CellController[][] gameField;

    public Field(int fieldSize, double bombPercentage) {
        this.fieldSize = fieldSize;
        this.bombPercentage = bombPercentage;
        this.gameField = new CellController[this.fieldSize][this.fieldSize];
        for (int col= 0; col < this.fieldSize; col++) {
            for (int row = 0; row < this.fieldSize; row++) {
                this.gameField[col][row] = new CellController(bombPercentage);
            }
        }
    }

    public int getFieldSize() {
        return fieldSize;
    }

    public void setFieldSize(int fieldSize) {
        this.fieldSize = fieldSize;
    }

    public CellController[][] getGameField() {
        return gameField;
    }

    public void setGameField(CellController[][] gameField) {
        this.gameField = gameField;
    }

    public double getBombPercentage() {
        return bombPercentage;
    }

    public void setBombPercentage(double bombPercentage) {
        this.bombPercentage = bombPercentage;
    }
}