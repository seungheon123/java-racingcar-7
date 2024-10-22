package racingcar.exception;

public class CustomException extends IllegalArgumentException{
    public CustomException(String message) {
        super(message);
    }

    public static final CustomException INVALID_MESSAGE = new CustomException("입력한 이름이 5자를 초과하였습니다.");
    public static final CustomException INVALID_ROUND = new CustomException("시도 횟수는 숫자여야 합니다.");
    public static final CustomException INVALID_ROUND_MIN = new CustomException("시도 횟수는 1 이상이어야 합니다.");
}
