/*
 * Copyright (c) 2018. School project
 */

package Controller;

import View.FieldView;

public class GameController {

    public GameController(int number_of_cells) {
        new FieldView(number_of_cells);
    }
}
