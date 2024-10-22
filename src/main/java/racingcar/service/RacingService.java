package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Game;
import racingcar.util.InputParser;

public class RacingService {

    public static void startGame() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String carNameInput = Console.readLine();

        System.out.println("시도할 회수는 몇회인가요?");
        String roundInput = Console.readLine();

        String[] carNames = InputParser.parseNames(carNameInput);
        int round = InputParser.parseRound(roundInput);

        Game game = new Game(carNames, round);
        game.play();

    }
}
