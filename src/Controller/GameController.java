package Controller;

import Model.Field;
import View.FieldView;

public class GameController {

    public GameController(int numberOfCells) {
        FieldView view = new FieldView();
        Field field = new Field();
        FieldController controller = new FieldController(view, field, numberOfCells);
    }
}
