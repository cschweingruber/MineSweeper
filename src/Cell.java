import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Cell extends JButton implements MouseListener {

    /**
     * state variable
     * can be covered (default) (0)
     * can be turned (1)
     * can be a bomb (2)
     */
    private int state;

    private int size;

    private JFrame cell;

    public Cell() {
        cell = new JFrame();
        addMouseListener(this);
    }

    private void createCell() {

    }

    private void reveal() {
        System.out.println("clicked");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        reveal();
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
