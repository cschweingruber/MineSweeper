/*
 * Copyright (c) 2018. School project
 */

package Controller;

public class GameController {

    private FieldController fieldController;

    public GameController(int number_of_cells) {
        fieldController = new FieldController(number_of_cells);
    }
}
