package opinion.poll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < numberOfLines; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);
            people.add(person);

        }

        people.sort(Comparator.comparing(p -> p.getName()));

        for (Person person : people) {
            if (person.getAge() > 30) {
                System.out.println(String.format("%s - %d", person.getName(), person.getAge()));
            }
        }
    }
}
