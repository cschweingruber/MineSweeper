package Controller;

import Model.Field;
import View.FieldView;

public class FieldController {

    private FieldView view;
    private Field field;

    public FieldController(int numberOfCells, double bombPercentage) {
        field = new Field(numberOfCells, bombPercentage);
        view = new FieldView(field.getFieldSize(), field.getGameField());
    }

}