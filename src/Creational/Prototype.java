package Creational;

/*

********* PROPERTIES ***********
- creational design pattern
- used when we want to avoid multiple object creation of same instance,
  instead we copy the object to new object & then we can modify as per
  our need

********* IMPLEMENTATION ***********
- object which we're copying should provide copying feature by implementing
  Cloneable interface
- we can override clone() method to implement as per our need

 */

import java.util.ArrayList;
import java.util.List;

class VehiclE implements Cloneable {
    private List<String> vehicleList;

    public VehiclE() {
        this.vehicleList = new ArrayList<String>();
    }

    public VehiclE(List<String> list) {
        this.vehicleList = list;
    }

    public void insertData() {
        vehicleList.add("Audi A4");
        vehicleList.add("Honda amaze");
        vehicleList.add("Hyundai Creta");
        vehicleList.add("Maruti Baleno");
        vehicleList.add("Renault Duster");
    }

    public List<String> getVehicleList() {
        return this.vehicleList;
    }

    @Override
    public Object clone() {
        List<String> tempList = new ArrayList<String>();

        for(String v: this.getVehicleList()) {
            tempList.add(v);
        }

        return new VehiclE(tempList);
    }
}

public class Prototype {

    public static void main(String[] args) {
        VehiclE a = new VehiclE();
        a.insertData();

        VehiclE b = (VehiclE) a.clone();
        b.getVehicleList().add("Honda new Amaze");

        System.out.println(a.getVehicleList());
        System.out.println(b.getVehicleList());

        b.getVehicleList().remove("Audi A4");
        System.out.println(a.getVehicleList());
        System.out.println(b.getVehicleList());
    }
}
