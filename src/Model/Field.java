/*
 * Copyright (c) 2018. School project
 */

package Model;

import Common.CellClickState;
import Common.CellState;
import Model.Cell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Field {

    /**
     * Order of cells in the cell array (field): 00 01  02
     *                                           10 11  12
     *                                           20 21  22
     */

    private GridLayout gridLayout;

    public Field(int NUMBER_OF_CELLS) {
        gridLayout = new GridLayout(NUMBER_OF_CELLS, NUMBER_OF_CELLS);
    }

}
