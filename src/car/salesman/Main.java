package car.salesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Engine> engines = new HashMap<>();
        List<Car> cars = new ArrayList<>();

        int numberOfLinesForEngine = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfLinesForEngine; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String model = tokens[0];
            String power = tokens[1];

            Engine engine = null;

            if (tokens.length == 2) {
                engine = new Engine(model, power);
            }else if (tokens.length == 4) {
                String displacement = tokens[2];
                String efficiency = tokens[3];
                engine = new Engine(model, power, displacement, efficiency);
            }else if (tokens.length == 3) {
                engine = new Engine(model, power);

                String third = tokens[2];
                if (third.charAt(0) >= 48 && third.charAt(0) <= 57){
                    engine.setDisplacement(third);
                }else {
                    engine.setEfficiency(third);
                }
            }

            engines.put(model, engine);
        }

        int numberOfLinesForCar = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfLinesForCar; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String model = tokens[0];
            String engine = tokens[1];

            Car car = null;

            if (tokens.length == 2) {
                car = new Car(model, engines.get(engine));
            }else if (tokens.length == 4) {
                String weight = tokens[2];
                String color = tokens[3];
                car = new Car(model, engines.get(engine), weight, color);
            }else if (tokens.length == 3) {
                car = new Car(model, engines.get(engine));

                String third = tokens[2];
                if (third.charAt(0) >= 48 && third.charAt(0) <= 57){
                    car.setWeight(third);
                }else {
                    car.setColor(third);
                }
            }

            cars.add(car);
        }

        for (Car car : cars) {
            System.out.print(car.toString());

        }

    }
}
