import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLine = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < numberOfLine; i++) {

            String[] tokens = scanner.nextLine().split("\\s+");

            String brand = tokens[0];
            if (tokens.length == 1) {
                Car car = new Car(brand);
                car.setBrand(brand);
                cars.add(car);
            }else if (tokens.length == 3){
                String model = tokens[1];
                int HP = Integer.parseInt(tokens[2]);

                Car car = new Car(brand, model, HP);
                car.setBrand(brand);
                car.setModel(model);
                car.setHorsePower(HP);

                cars.add(car);
            }
        }

        for (Car car : cars) {
            System.out.println(car.carInfo());
        }

    }
}

