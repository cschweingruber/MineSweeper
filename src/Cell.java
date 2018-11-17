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
import java.awt.*;
import java.awt.event.MouseEvent;

public class Cell extends JButton {

    /**
     * state variable
     * can be covered (default) (CellState.NOT_CLICKED)
     * can be turned (CellState.CLICKED)
     */
    private CellState state;

    private CellClickState clickState = CellClickState.NOT_CLICKED;

    private String id;

    private int bombNeighbors;

    public Cell(CellState cellState) {
        setState(cellState);
        if (cellState == CellState.BOMB) {
            setBackground(Color.black);
        }
        addMouseListener(new Player() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }

    public void reveal() {
        if (this.bombNeighbors == 0) {
            setText("");
        } else {
            setText("" + bombNeighbors);
        }
        //TODO: REVEAL
        setClickState(CellClickState.CLICKED);
        System.out.println("reveal");
        setBackground(Color.GRAY);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }

    public int getBombNeighbors() {
        return bombNeighbors;
    }

    public void setBombNeighbors(int bombNeighbors) {
        this.bombNeighbors = bombNeighbors;
    }

    public CellClickState getClickState() {
        return clickState;
    }

    public void setClickState(CellClickState clickState) {
        this.clickState = clickState;
    }

}

