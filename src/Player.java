import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class Player extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent e) {
        /*
         * Cell which has been clicked
         */
        Cell cell = (Cell) e.getSource();
        if (SwingUtilities.isLeftMouseButton(e)) {
            Field.reveal(cell);
        } else {
            Field.setProtection(cell);
        }
    }
}

