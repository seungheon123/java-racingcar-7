package racingcar.util;
import java.util.Arrays;
import racingcar.exception.CustomException;

public class InputParser {
    private static final String DELIMITER = ",";

    public static String[] parseNames(String input) {
        String[] names = input.split(DELIMITER);
        Arrays.stream(names).forEach(name -> {
            if(name.length() > 5) {
                throw CustomException.INVALID_MESSAGE;
            }
        });
        return names;
    }

    public static int parseRound(String input) {
        try {
            int round = Integer.parseInt(input);
            if (round < 1) {
                throw CustomException.INVALID_ROUND_MIN;
            }
            return round;
        } catch (NumberFormatException e) {
            throw CustomException.INVALID_ROUND;
        }
    }
}


