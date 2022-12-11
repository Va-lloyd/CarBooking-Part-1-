package com.valloyd.carbooking.car;

import com.valloyd.carbooking.car.enums.Brand;

import java.math.BigDecimal;
import java.util.Objects;

public final class Car {

    private String regNumber;
    private BigDecimal rentalPriceDaily;
    private Brand brand;
    private final boolean isElectric;

    public Car(String regNumber, BigDecimal rentalPriceDaily, Brand brand, boolean isElectric) {
        this.regNumber = regNumber;
        this.rentalPriceDaily = rentalPriceDaily;
        this.brand = brand;
        this.isElectric = isElectric;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public BigDecimal getRentalPriceDaily() {
        return rentalPriceDaily;
    }

    public void setRentalPriceDaily(BigDecimal rentalPriceDaily) {
        this.rentalPriceDaily = rentalPriceDaily;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public boolean isElectric() {
        return isElectric;
    }

    @Override
    public String toString() {
        return "Car{" +
                "regNumber='" + regNumber + '\'' +
                ", rentalPriceDaily=" + rentalPriceDaily +
                ", brand=" + brand +
                ", isElectric=" + isElectric +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return isElectric == car.isElectric && Objects.equals(regNumber, car.regNumber) && Objects.equals(rentalPriceDaily, car.rentalPriceDaily) && Objects.equals(brand, car.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNumber, rentalPriceDaily, brand, isElectric);
    }

}
