package Model;

public class Field {

    private double bombPercentage;
    private int fieldSize;


    public Field(int fieldSize, double bombPercentage) {
        this.fieldSize = fieldSize;
        this.bombPercentage = bombPercentage;

    }

    public int getFieldSize() {
        return fieldSize;
    }

    public void setFieldSize(int fieldSize) {
        this.fieldSize = fieldSize;
    }

    public double getBombPercentage() {
        return bombPercentage;
    }

    public void setBombPercentage(double bombPercentage) {
        this.bombPercentage = bombPercentage;
    }
}