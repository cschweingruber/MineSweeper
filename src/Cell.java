import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Cell extends JButton  {

    /**
     * state variable
     * can be covered (default) (CellState.NOT_CLICKED)
     * can be turned (CellState.CLICKED)
     */
    private CellState state;

    private CellClickState clickState;

    private String id;

    private int bombNeighbors;

    private MouseListener l;

    public Cell(CellState cellState, MouseListener l) {
        setState(cellState);
        setClickState(CellClickState.NOT_CLICKED);
        if (cellState == CellState.BOMB) {
            setBackground(Color.black); //TODO: set img of bomb
        }
        addMouseListener(new Player() {
            @Override
            public void mouseClicked(MouseEvent e) {
                l.mouseClicked(e);
            }
        });
    }

    public void reveal() {
        if (this.bombNeighbors == 0) {
            setText("");
        } else {
            setText("" + bombNeighbors);
        }
        setClickState(CellClickState.CLICKED);
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
        switch (clickState) {
            case NOT_CLICKED:
                setBackground(Color.GRAY);
                break;
            case CLICKED:
                setBackground(Color.darkGray);
                break;
            case PROTECTED:
                setBackground(Color.orange);    //TODO: stop-zeichen als bild!
                break;
        }
    }

}

