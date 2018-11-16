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
    private int state = 0;

    public Cell() {
//        setSize(width, height);
        addMouseListener(this);
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
