import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class Player implements MouseListener {

    Field field;

    public Player() {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Cell[][] cellsToReveal = new Cell[2][2];
        List<Cell> cellList = new ArrayList<Cell>();
        Cell cell = (Cell) e.getSource();

        try {
            for (int i = 0; i < field.cells.length; i++) {
                for (int j = 0; j < field.cells.length; j++) {
                    if ((field.cells[i][j].getLocation(new Point(cell.getxPos(), cell.getyPos()))) - (field.cells[i][j].getLocation(new Point(cell.getxPos(), cell.getyPos()))) <= (Math.sqrt(Math.pow(field.cells[i][j].size, 2) + Math.pow(field.cells[i][j].size, 2)))) {
                        cellList.add(field.cells[i][j]);
                    }
                }
            }

            for (int i = 0; i < cellList.size(); i++) {
                for (int j = 0; j < cellList.size(); j++) {
                    cellsToReveal[i][j] = cellList.get(i);
                }
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("ArrayOOB");
            ex.printStackTrace();
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        cell.reveal();
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
}
