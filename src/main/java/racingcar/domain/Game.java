package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Car> cars;
    private int round;
    private int maxPosition;

    public Game(String[] names, int round) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        this.cars = cars;
        this.round = round;
    }

    public void play() {
        for (int i = 0; i < round; i++) {
            move();
            print();
        }
        printWinners();
    }

    private void move() {
        for (Car car : cars) {
            int number = Randoms.pickNumberInRange(0, 9);
            car.move(number);
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
    }
    private void print() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners() {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if(car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
