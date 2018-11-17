import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class Player extends MouseAdapter {

    public static boolean gameover;

    public Player() {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("clicked");
        Cell[][] cellsToReveal = new Cell[2][2];
        /*
         * Cell which has been clicked
         */
        Cell cell = (Cell) e.getSource();

        int xPosCenterCell = Integer.parseInt(cell.getId().substring(0,1));
        int yPosCenterCell = Integer.parseInt(cell.getId().substring(1,2));

        //check if directly hit a bomb
        if (Field.cells[xPosCenterCell][yPosCenterCell].getState() == CellState.BOMB) {
            //TODO: gameover
            System.out.println("gameOver!!");
            gameover = true;
        }

        try {
            int noBomb = 0;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    try {
                        if (Field.cells[xPosCenterCell - i][yPosCenterCell - j].getState() != CellState.CLICKED) {
                            Field.cells[xPosCenterCell - i][yPosCenterCell - j].reveal();
                            if (Field.cells[xPosCenterCell - i] [yPosCenterCell - j].getState() != CellState.BOMB) {
                                noBomb++;
                            }
                        } else {
                            //TODO: remove
                            System.out.println("field "+ String.valueOf(yPosCenterCell - j) + String.valueOf(xPosCenterCell - i) + " already clicked");
                        }
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        System.out.println("clicked bound field. catching ex...");
                    }
                }
            }
            if (noBomb == 9) {
                //TODO: recursivyl cover up
                System.out.println("no bom in view. covering recursively up");
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}

