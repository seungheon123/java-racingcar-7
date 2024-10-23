package racingcar.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.exception.CustomException;

class InputParserTest {

    @Test
    void 자동차_이름_추출(){
        String input = "test1,test2,test3";
        assertEquals(3, InputParser.parseNames(input).length);
    }

    @Test
    void 자동차_이름_길이_예외(){
        String input = "test1,wrongName";
        assertThrows(CustomException.class, () -> InputParser.parseNames(input));
    }

    @Test
    void 레이싱_라운드_추출(){
        String input = "5";
        assertEquals(5, InputParser.parseRound(input));
    }

    @Test
    void 레이싱_라운드_최소값_예외(){
        String input = "0";
        assertThrows(CustomException.class, () -> InputParser.parseRound(input));
    }

    @Test
    void 레이싱_라운드_숫자_아닌_값_예외(){
        String input = "a";
        assertThrows(CustomException.class, () -> InputParser.parseRound(input));
    }

}
