//import javax.swing.*;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//
//public class Cell extends JButton implements MouseListener {
//
//    /**
//     * state variable
//     * can be covered (default) (0)
//     * can be turned (1)
//     * can be a bomb (2)
//     *
//     */
//    private int state = 0;
//
//    private Enum<CellState> clickState = CellState.NOT_CLICKED;
//
//    public Cell(String text) {
//        setButtonText(text);
//        addMouseListener(this);
//    }
//
//    void setButtonText(String text) {
//        setText(text);
//    }
//
//    private void reveal() {
//        setClickState(CellState.CLICKED);
//    }
//
//    @Override
//    public void mouseClicked(MouseEvent e) {
//        reveal();
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {
//
//    }
//
//    public int getState() {
//        return state;
//    }
//
//    public void setState(int state) {
//        this.state = state;
//    }
//
//    public Enum<CellState> getClickState() {
//        return clickState;
//    }
//
//    public void setClickState(Enum<CellState> clickState) {
//        this.clickState = clickState;
//    }
//}

import javax.swing.*;

public class Cell extends JButton {

    /**
     * state variable
     * can be covered (default) (0)
     * can be turned (1)
     * can be a bomb (2)
     *
     */
    private int state = 0;

    private String id;

    public double size;

    private int xPos = getX();

    private int yPos = getY();

    public Cell() {
    }

    public void reveal() {
        //TODO: REVEAL
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

}

