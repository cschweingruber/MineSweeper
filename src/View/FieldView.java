/*
 * Copyright (c) 2018. School project
 */

package View;

import Controller.FieldController;

import javax.swing.*;
import java.awt.*;

public class FieldView extends JFrame {

    private int numberOfCells;
    private GridLayout gridLayout;
    private FieldController controller;
    private CellView[][] cellViews;

    public FieldView(int number_of_cells) {
        setSize(500, 500);
        setMinimumSize(new Dimension(50, 50));
        setLocationRelativeTo(null);

        this.numberOfCells = number_of_cells;
        controller = new FieldController(this);
        cellViews = new CellView[this.numberOfCells][this.numberOfCells];

        controller.createField(cellViews);

        setGridLayout();
        setVisible(true);
    }

    private void setGridLayout() {
        gridLayout = new GridLayout(numberOfCells, numberOfCells);
        setLayout(gridLayout);
    }


}
