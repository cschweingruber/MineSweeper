package Model;

import Controller.CellController;
import View.CellView;

public class Field {

    private float bombPercentage;
    private int fieldSize;
    private CellController[][] gameField;

    public Field(int fieldSize) {
        this.fieldSize = fieldSize;
        this.gameField = new CellController[this.fieldSize][this.fieldSize];
        for (int col= 0; col < this.fieldSize; col++) {
            for (int row = 0; row < this.fieldSize; row++) {
                this.gameField[col][row] = new CellController();
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

    public float getBombPercentage() {
        return bombPercentage;
    }

    public void setBombPercentage(float bombPercentage) {
        this.bombPercentage = bombPercentage;
    }
}