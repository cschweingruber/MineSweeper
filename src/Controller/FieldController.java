package Controller;

import Model.Field;
import View.FieldView;

public class FieldController {

    private FieldView view;
    private Field field;

    public FieldController(int numberOfCells) {
        view = new FieldView();
        field = new Field(numberOfCells);
    }
}