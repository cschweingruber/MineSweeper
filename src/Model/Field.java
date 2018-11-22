package Model;

import Common.CellState;
import Controller.CellController;
import View.CellView;

import java.awt.event.MouseListener;

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

        //Sets the Bombneighbors in Cell for each
        int bombCounter = 0;
        //FOR EVERY CELL
        for (int col = 0; col < fieldSize; col++) {
            for (int row = 0; row < fieldSize; row++) {
                //CHECK FIELD OF 9
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        try {
                            if (i == 0 && j == 0) {}
                            else if (gameField[col - i][row - j].getCellState() == CellState.BOMB) {
                                bombCounter++;
                            }
                        } catch (ArrayIndexOutOfBoundsException aoobex) {
                        }
                    }
                }
                //END CHECK FIELD OF 9
                if (gameField[col][row].getCellState() != CellState.BOMB) {
                    gameField[col][row].setCellBombNeighbors(bombCounter);
                }
                bombCounter = 0;
            }
        }
        //END FIELD


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