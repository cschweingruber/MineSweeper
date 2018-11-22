package Model;

import Common.CellClickState;
import Common.CellState;
import Controller.CellController;

public class Cell {

    private int[] id;
    private CellState state;
    private CellClickState clickState;
    private int bombNeighbors;

    public Cell() {
        setClickState(CellClickState.NOT_CLICKED);
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }

    public CellClickState getClickState() {
        return clickState;
    }

    public void setClickState(CellClickState clickState) {
        this.clickState = clickState;
    }

    public int[] getId() {
        return id;
    }

    public void setId(int[] id) {
        this.id = id;
    }

    public int getBombNeighbors() {
        return bombNeighbors;
    }

    public void setBombNeighbors(int bombNeighbors) {
        this.bombNeighbors = bombNeighbors;
    }
}