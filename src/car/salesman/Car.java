package car.salesman;

public class Car {

    private String model;
    private Engine engine;
    private String weight;
    private String color;


    public Car(String model, Engine engine, String weight, String color) {
        this(model, engine);
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = "n/a";
        this.color = "n/a";
    }


    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return this.model;
    }

    public Engine getEngine() {
        return this.engine;
    }


    @Override
    public String toString() {
        String output = String.format("%s:%n" +
                "%s:%n" +
                "Power: %s%n" +
                "Displacement: %s%n" +
                "Efficiency: %s%n" +
                "Weight: %s%n" +
                "Color: %s%n",this.model, this.engine.getModel(), this.engine.getPower(), this.engine.getDisplacement(),
                this.engine.getEfficiency(), this.weight, this.color);

        return output;
    }
}
