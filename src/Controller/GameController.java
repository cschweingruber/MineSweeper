package Controller;

public class GameController {

    public GameController(int fieldSize, double bombPercentage) {
        FieldController controller = new FieldController(fieldSize, bombPercentage);
    }
}
