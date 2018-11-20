
package Controller;

import Model.Cell;
import Model.Field;
import View.CellView;
import View.FieldView;

public class FieldController {

    private Field field;
    private FieldView view;

    private int xPosCenterCell;
    private int yPosCenterCell;

    FieldController(FieldView view, Field field, int numberOfCells) {
        this.view = view;
        this.field = field;

        initField(numberOfCells);

        view.setGridLayout(numberOfCells);
        view.setVisible(true);
    }

    private void initField(int numberOfCells) {
        this.field.setFieldSize(numberOfCells);
        for (int col = 0; col < field.getFieldSize(); col++) {
            for (int row = 0; row < field.getFieldSize(); row++) {
                CellView cellView = new CellView();
                Cell cell = new Cell();
                new CellController(cellView, cell, String.valueOf(col) + String.valueOf(row), field.getBombPercentage(), bombNeighbours);

                view.add(cellView);
            }
        }
    }




    public int getBombPercentage() {
        return this.field.getBombPercentage();
    }

    public void setBombPercentage(int bombPercentage) {
        this.field.setBombPercentage(bombPercentage);
    }


//    public void createField(CellView[][] cellViews) {
//        for (int i = 0; i < cellViews.length; i++) {
//            for (int j = 0; j < cellViews.length; j++) {
//                int finalJ = j;
//                int finalI = i;
//                cellViews[i][j] = new CellView(getBombPercentage(), String.valueOf(i) + String.valueOf(j), new MouseListener() {
//                    @Override
//                    public void mouseClicked(MouseEvent e) {
//                        if (SwingUtilities.isLeftMouseButton(e)) {
//                            System.out.println("click");
//                            CellView cellView = (CellView) e.getSource();
//                            cellView.reveal(cellViews);
//                        } else {
//                            cellViews[finalI][finalJ].setProtection();
//                        }
//                    }
//
//                    @Override
//                    public void mousePressed(MouseEvent e) {
//
//                    }
//
//                    @Override
//                    public void mouseReleased(MouseEvent e) {
//
//                    }
//
//                    @Override
//                    public void mouseEntered(MouseEvent e) {
//
//                    }
//
//                    @Override
//                    public void mouseExited(MouseEvent e) {
//
//                    }
//                });
//                cellViews[i][j].setNeighbours(cellViews);
//                view.add(cellViews[i][j]);
//            }
//        }
//    }

}
