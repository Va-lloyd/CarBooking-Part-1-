package com.valloyd.carbooking.car;

import com.valloyd.carbooking.car.enums.Brand;

import java.math.BigDecimal;

final class CarDAO {

    static Car[] cars;
    private static int CAPACITY = 100;

    static {
        cars = new Car[CAPACITY];
        cars[0] = new Car("8i7jrtgd", BigDecimal.valueOf(100), Brand.ONE, false);
        cars[1] = new Car("irj678drgt", BigDecimal.valueOf(200), Brand.THREE, false);
        cars[2] = new Car("ji8tretg", BigDecimal.valueOf(400), Brand.TWO, false);
        cars[3] = new Car("f34ry54ge", BigDecimal.valueOf(70), Brand.CUSTOM, true);
        cars[4] = new Car("k9o80gt4e", BigDecimal.valueOf(700), Brand.THREE, true);
    }

    /*public void setCar(Car car) {
        for (int i = 0; i < cars.length; i++) {
            if ((cars[i] == null)) {
                cars[i] = car;
            }
        }
    }*/

    public Car[] getCars() {
        return cars;
    }
}
