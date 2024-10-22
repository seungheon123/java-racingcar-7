# java-racingcar-precourse

## 문제 요구사항
- 주어진 횟수 동안 자동차들은 전진 또는 멈출 수 있다.
  - 사용자는 몇 번의 이동을 할 것인지 입력할 수 있다.
  - 전진하는 조건은 0~9 사이의 랜덤값이 4 이상일 경우이다.
- 각 자동차는 이름을 가지며, 이름은 5자 이하이다.
  - `,`를 기준으로 이름을 구분한다.
  - 전진하는 자동차는 이름이 출력된다.
- 자동차 경주 게임의 결과를 출력한다.
  - 우승자는 한 명 이상일 수 있다.
  - 우승자는 `,`로 구분한다.
- 잘못된 입력에 대해 예외 처리한다.
  - 예외 메시지는 `IllegalArgumentException`을 활용한다.

## 프로그래밍 요구사항
- `indent(들여쓰기)` depth를 2단계까지 제한한다.
- 3항 연산자를 쓰지 않는다.
- 함수 또는 메소드가 한 가지 일만 한다.
- Junit5와 AssertJ를 활용해 테스트를 구현한다.

## 구현
### Car
``` Java 
class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(int number) {
        if (number >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }
    
    public int getPosition() {
        return position;
    }
}
```
### Game
``` Java
class Game {
    private List<Car> cars;
    private int round;

    public Game(String[] names, int round) {
        this.cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        this.round = round;
    }

    public void play() {
        for (int i = 0; i < round; i++) {
            for (Car car : cars) {
                car.move(new Random().nextInt(10));
            }
        }
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
                winners.clear();
                winners.add(car);
            } else if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

}
```
