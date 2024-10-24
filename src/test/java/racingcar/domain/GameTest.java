package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class GameTest {
    @Test
    void 게임_생성_테스트() {
        //given
        String[] names = {"test1", "test2"};
        int round = 5;

        //when
        Game game = new Game(names, round);

        //then
        assertEquals(2, game.getCars().size());
        assertEquals(5, game.getRound());
    }

    @Test
    void 게임_진행_테스트() {
        //given
        String[] names = {"test1", "test2"};
        int round = 5;
        Game game = new Game(names, round);

        //when
        game.play();

        //then
        for (Car car : game.getCars()) {
            assertTrue(car.getPosition() >= 0 && car.getPosition() <= round);
        }
    }

    @Test
    void 게임_라운드_테스트() {
        // given
        String[] names = {"pobi", "woni"};
        int round = 3;
        Game game = new Game(names, round);

        // when
        game.play();

        // then
        for (Car car : game.getCars()) {
            assertTrue(car.getPosition() >= 0 && car.getPosition() <= round);
        }
        assertEquals(3, game.getRound());
    }

    @Test
    void 우승자_출력_테스트() {
        // given
        String[] names = {"pobi", "woni", "jun"};
        int round = 5;
        Game game = new Game(names, round);

        // when
        game.play();

        // then
        int maxPosition = game.getCars().stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = new ArrayList<>();
        for (Car car : game.getCars()) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        assertTrue(winners.size() > 0);
    }
}
