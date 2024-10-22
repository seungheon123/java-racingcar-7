package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차_이름_확인() {
        Car car = new Car("test");
        assertEquals("test", car.getName());
    }

    @Test
    void 자동차_위치_확인() {
        Car car = new Car("test");
        assertEquals(0, car.getPosition());
    }

    @Test
    void 자동차_전진_4이상일_경우_위치_변경() {
        Car car = new Car("test");
        int number = 4;
        car.move(number);
        assertEquals(1, car.getPosition());
    }

    @Test
    void 자동차_정지_4미만일_경우_위치_유지() {
        Car car = new Car("test");
        int number = 3;
        car.move(number);
        assertEquals(0, car.getPosition());
    }
}
