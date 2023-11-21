package baseball.view;

public class InputVIew {
    private static InputVIew inputVIew;

    private InputVIew() {
    }

    public static InputVIew getInstance() {
        if (inputVIew == null) {
            inputVIew = new InputVIew();
        }
        return inputVIew;
    }
}
