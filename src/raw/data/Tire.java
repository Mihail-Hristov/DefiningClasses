package raw.data;

import java.util.List;

public class Tire {

    private List<Integer> ages;
    private List<Double> pressures;

    public Tire(List<Integer> ages, List<Double> pressures) {
        this.ages = ages;
        this.pressures = pressures;
    }

    public List<Double> getPressures() {
        return this.pressures;
    }
}
