package Controller;

import Common.CellState;
import Model.Field;
import View.FieldView;

public class FieldController {

    private FieldView view;
    private Field field;
    private CellController[][] gameField;

    public FieldController(int numberOfCells, double bombPercentage) {
        field = new Field(numberOfCells, bombPercentage);


        this.gameField = new CellController[this.field.getFieldSize()][this.field.getFieldSize()];
        for (int col= 0; col < this.field.getFieldSize(); col++) {
            for (int row = 0; row < this.field.getFieldSize(); row++) {
                this.gameField[col][row] = new CellController(bombPercentage);
            }
        }

        for (int col= 0; col < this.field.getFieldSize(); col++) {
            for (int row = 0; row < this.field.getFieldSize(); row++) {
                CellController[][] neighbors = new CellController[3][3];
                for (int x = 0; x < 3; col++) {
                    for (int y = 0; y < 3; row++) {
                        try {
                            neighbors[x][y] = gameField[row-1+x][col-1+y];
                        } catch (ArrayIndexOutOfBoundsException aaobex) {}
                    }
                }
                gameField[row][col].setNeighbors(neighbors);
            }
        }

        view = new FieldView(field.getFieldSize(), this.gameField);
    }

}