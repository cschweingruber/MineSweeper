
package Controller;

import Common.CellClickState;
import Common.CellState;
import Model.Field;
import View.CellView;
import View.FieldView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FieldController {

    private FieldView view;
    private Field field;

    private int xPosCenterCell;
    private int yPosCenterCell;

    public FieldController(FieldView view) {
        field = new Field();
        this.view = view;
    }

    public void createField(CellView[][] cellViews) {
        for (int i = 0; i < cellViews.length; i++) {
            for (int j = 0; j < cellViews.length; j++) {
                int finalJ = j;
                int finalI = i;
                cellViews[i][j] = new CellView(getBombPercentage(), String.valueOf(i) + String.valueOf(j), new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (SwingUtilities.isLeftMouseButton(e)) {
                            System.out.println("click");
                            CellView cellView = (CellView) e.getSource();
                            cellView.reveal(cellViews);
                        } else {
                            cellViews[finalI][finalJ].setProtection();
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
                cellViews[i][j].setNeighbours(cellViews);
                view.add(cellViews[i][j]);
            }
        }
    }


    public int getBombPercentage() {
        return bombPercentage;
    }

    public void setBombPercentage(int bombPercentage) {
        this.bombPercentage = bombPercentage;
    }

}
