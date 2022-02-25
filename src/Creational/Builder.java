package Creational;

/*

********* PROPERTIES ***********
- creational design pattern
- used when we have too many arguments to send in Constructor &
  it's hard to maintain the order
- when we don't want to send all parameters in Object initialization
  (Generally we send optional parameters as null)

********* IMPLEMENTATION ***********
- we create 'static nested class', which contains all arguments of outer class
- as per naming convention, if class name is 'Vehicle', builder class name
  should be 'VehicleBuilder'
- builder class have a public constructor with all required parameters
- builder class should have methods for optional parameters. method will
  return the Builder object.
- a 'build()' method that will return the final Object.
- the main class 'Vehicle' has private constructor so to create instance
  only via Builder class
- the main class 'Vehicle' has only getters

 */

class VehicLe {
    // required parameters
    private String engine;
    private int wheel;

    // optional parameter
    private int airbags;

    public String getEngine() {
        return this.engine;
    }

    public int getWheel() {
        return this.wheel;
    }

    public int getAirbags() {
        return this.airbags;
    }

    private VehicLe(VehicleBuilder builder) {
        this.engine = builder.engine;
        this.wheel = builder.wheel;
        this.airbags = builder.airbags;
    }

    public static class VehicleBuilder {
        private String engine;
        private int wheel;

        private int airbags;

        public VehicleBuilder(String engine, int wheel) {
            this.engine = engine;
            this.wheel = wheel;
        }

        public VehicleBuilder setAirbags(int airbags) {
            this.airbags = airbags;
            return this;
        }

        public VehicLe build() {
            return new VehicLe(this);
        }
    }
}

public class Builder  {

    public static void main(String[] args) {
        VehicLe car = new VehicLe.VehicleBuilder("1500cc", 4).setAirbags(4).build();
        VehicLe bike = new VehicLe.VehicleBuilder("200cc", 2).build();

        System.out.println(car.getEngine());
        System.out.println(car.getWheel());
        System.out.println(car.getAirbags());

        System.out.println(bike.getEngine());
        System.out.println(bike.getWheel());
        System.out.println(bike.getAirbags());
    }
}
