package raw.data;

import java.util.List;

public class Car {

    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire tire;

    public Car(String model, Engine engine, Cargo cargo, Tire tire) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tire = tire;
    }


    public String getModel() {
        return this.model;
    }

    public boolean checkPressure() {

        boolean lessThanOne = false;
        List<Double> pressures = tire.getPressures();
        for (Double pressure: pressures) {
            if (pressure < 1){
                lessThanOne = true;
            }
        }

        return lessThanOne;
    }

    public int checkEngine() {
        int power = engine.getPower();

        return  power;
    }
}

