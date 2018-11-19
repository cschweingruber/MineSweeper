/*
 * Copyright (c) 2018. School project
 */

package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class CellView extends JButton {
    public CellView(MouseListener clickListener) {
        addMouseListener(clickListener);
    }

    public void reveal(int bombNeighbors) {
        if (bombNeighbors == 0) {
            setText("");
        } else {
            setText("" + bombNeighbors);
        }
        setBackground(Color.GRAY);
    }
}
