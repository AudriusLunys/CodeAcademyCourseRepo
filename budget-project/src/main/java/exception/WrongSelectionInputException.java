package exception;

public class WrongSelectionInputException extends IllegalArgumentException {

    public WrongSelectionInputException(String s) {
        super(s);
    }
}