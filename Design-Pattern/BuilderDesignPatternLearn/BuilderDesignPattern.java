

class Car{

    //Required Feilds

    private String engine;
    private int wheels;

    //Non-Required Feilds

    private boolean airConditioner;
    private boolean gps;
    private boolean sunroof;

    private Car(CarBuilder builder) {
        this.engine = builder.engine;
        this.wheels = builder.wheels;
        this.airConditioner = builder.airConditioner;
        this.gps = builder.gps;
        this.sunroof = builder.sunroof;
    }

    // For printing the car details
    public String toString() {
        return "Car [engine=" + engine + ", wheels=" + wheels +
                ", airConditioner=" + airConditioner +
                ", gps=" + gps + ", sunroof=" + sunroof + "]";
    }

    public static class CarBuilder{

        private String engine;
        private int wheels;
        private boolean airConditioner;
        private boolean gps;
        private boolean sunroof;

        public CarBuilder(String engine, int wheels){
            this.engine=engine;
            this.wheels=wheels;
        }

        public CarBuilder setAirConditioner(boolean value){
            this.airConditioner=value;
            return this;
        }

        public CarBuilder setGps(Boolean value){
            this.gps=value;
            return this;
        }

        public CarBuilder setSunnroof(Boolean value){
            this.sunroof=value;
            return this;
        }

        public Car build(){
            return new Car(this);
        }

    }

}

public class BuilderDesignPattern {

    public static void main(String[] args) {

        // Building a luxury car

        Car luxurycar=new Car.CarBuilder("V8 Engine", 4)
                .setAirConditioner(true)
                .setGps(true)
                .setSunnroof(true)
                .build();
        System.out.println(luxurycar);

        // Building a Simple car

        Car simplecar=new Car.CarBuilder("V4 Engine", 4)
                .build();
        System.out.println(simplecar);
    }
}
