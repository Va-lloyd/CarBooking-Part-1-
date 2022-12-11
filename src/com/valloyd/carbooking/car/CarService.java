package com.valloyd.carbooking.car;

public final class CarService {

    CarDAO carDAO;

    public CarService() {
        carDAO = new CarDAO();
    }

    public Car[] getCars() {
        var carAmount = 0;

        for (int i = 0; i < carDAO.getCars().length; i++) {
            if (!(carDAO.getCars()[i] == null)) {
                carAmount++;
            }
        }

        if (carAmount > 0) {
            Car[] cars = new Car[carAmount];
            var index = 0;

            for (int i = 0; i < carDAO.getCars().length; i++) {
                if (!(carDAO.getCars()[i] == null)) {
                    cars[index++] = carDAO.getCars()[i];
                }
            }
            return cars;
        } else {
            System.out.println("🚫 No cars...");
            return null;
        }
    }

    public Car[] getElectricCars() {
        if (!(getCars() == null)) {
            var electricCarAmount = 0;

            for (int i = 0; i < getCars().length; i++) {
                if (!(getCars()[i] == null) && getCars()[i].isElectric()) {
                    electricCarAmount++;
                }
            }

            if (electricCarAmount > 0) {
                Car[] electricCars = new Car[electricCarAmount];
                var index = 0;

                for (int i = 0; i < getCars().length; i++) {
                    if (!(getCars()[i] == null) && getCars()[i].isElectric()) {
                        electricCars[index++] = getCars()[i];
                    }
                }
                return electricCars;
            } else {
                System.out.println("🚫 No electric cars...");
                return null;
            }
        }
        return null;
    }

    public Car getCarByRegNumber(String regNumber) {
        if (!(getCars() == null)) {
            for (int i = 0; i < getCars().length; i++) {
                if (getCars()[i].getRegNumber().equalsIgnoreCase(regNumber)) {
                    return getCars()[i];
                }
            }
        }
        System.out.println("🚫 No car by given registration number...");
        return null;
    }
}
