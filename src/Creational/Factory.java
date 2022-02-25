package Creational;

/*

********* PROPERTIES ***********
- creational design pattern
- used when we have multiple sub-classes of a super class &
  based on input we want to return one class instance
- it provides abstraction between implementation & client classes
- remove the instantiation of client class from client code

********* IMPLEMENTATION ***********
- super class can be: interface, abstract class or basic class
- factory class has a static method which returns the instance of sub-class based on input

 */

abstract class Vehicle {
    public abstract int getWheel();

    public String toString() {
        return "Wheel: " + this.getWheel();
    }
}

class Car extends Vehicle {
    int wheel;

    Car(int wheel) {
        this.wheel = wheel;
    }

    @Override
    public int getWheel() {
        return this.wheel;
    }
}

class Bike extends Vehicle {
    int wheel;

    Bike(int wheel) {
        this.wheel = wheel;
    }

    @Override
    public int getWheel() {
        return this.wheel;
    }
}

//  This is a factory that's only job is returning vehicle according to the type
class VehicleFactory {
    public static Vehicle getInstance(String type, int wheel) {
        if(type == "car") {
            return new Car(wheel);
        }
        else if(type == "bike") {
            return new Bike(wheel);
        }

        return null;
    }
}

public class Factory {

    public static void main(String[] args) {
        Vehicle car = VehicleFactory.getInstance("car", 4);
        System.out.println(car);

        Vehicle bike = VehicleFactory.getInstance("bike", 2);
        System.out.println(bike);
    }
}
