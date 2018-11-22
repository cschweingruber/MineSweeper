package Controller;

import Model.Field;
import View.FieldView;

public class FieldController {

    private FieldView view;
    private Field field;

    public FieldController(int numberOfCells) {
        field = new Field(numberOfCells);
        view = new FieldView(field.getFieldSize(), field.getGameField());
    }
}