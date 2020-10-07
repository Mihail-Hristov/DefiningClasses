package raw.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();

        int numberOfLines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfLines; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];

            List<Double> pressures = new ArrayList<>();
            List<Integer> ages = new ArrayList<>();

            for (int j = 5; j <= 12; j++) {
                if (j % 2 == 0){
                    int age = Integer.parseInt(tokens[j]);
                    ages.add(age);
                }else {
                    double pressure = Double.parseDouble(tokens[j]);
                    pressures.add(pressure);
                }
            }

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire tires = new Tire(ages, pressures);

            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }

        String command = scanner.nextLine();

        switch (command) {
            case "fragile":
                for (Car car : cars) {
                    if (car.checkPressure()) {
                        System.out.println(car.getModel());
                    }
                }
                break;
            case "flamable":
                for (Car car : cars) {
                    if (car.checkEngine() > 250) {
                        System.out.println(car.getModel());
                    }
                }

                break;
        }

    }
}
