package google;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> people = new HashMap<>();

        String input = scanner.nextLine();

        while (!"End".equals(input)){
            String[] tokens = input.split("\\s+");

            String name = tokens[0];
            String object = tokens[1];

            Person person = new Person(name);
            person.setName(name);
            people.putIfAbsent(name, person);
            Person currentPerson;

            switch (object) {
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);

                    Company company = new Company(companyName, department, salary);

                    currentPerson = people.get(name);
                    currentPerson.setCompany(company);
                    people.put(name, currentPerson);
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];

                    Pokemons pokemon = new Pokemons(pokemonName, pokemonType);

                    currentPerson = people.get(name);
                    List<Pokemons> currentList = currentPerson.getPokemons();
                    currentList.add(pokemon);
                    people.put(name, currentPerson);

                    break;
                case "parents":
                    String parentsName = tokens[2];
                    String parentBirthday = tokens[3];

                    Parents parent = new Parents(parentsName, parentBirthday);

                    currentPerson = people.get(name);
                    List<Parents> currentListOfParents = currentPerson.getParents();
                    currentListOfParents.add(parent);
                    people.put(name, currentPerson);

                    break;
                case "children":
                    String childrenName = tokens[2];
                    String childrenBirthday = tokens[3];

                    Children children = new Children(childrenName, childrenBirthday);

                    currentPerson = people.get(name);
                    List<Children> currentListOfChildren = currentPerson.getChildren();
                    currentListOfChildren.add(children);
                    people.put(name, currentPerson);

                    break;
                case "car":
                    String model = tokens[2];
                    int speed = Integer.parseInt(tokens[3]);

                    Car car = new Car(model, speed);

                    currentPerson = people.get(name);
                    currentPerson.setCar(car);

                    break;
            }


            input = scanner.nextLine();
        }

        String searchingPerson = scanner.next();

        Person personForPrint = people.get(searchingPerson);

        System.out.println(searchingPerson);
        System.out.println("Company:");
        if (personForPrint.getCompany() != null) {
            System.out.println(String.format("%s %s %.2f"
                    , personForPrint.getCompany().getName()
                    , personForPrint.getCompany().getDepartment()
                    , personForPrint.getCompany().getSalary()));
        }
        System.out.println("Car:");
        if (personForPrint.getCar() != null) {
            System.out.println(String.format("%s %d", personForPrint.getCar().getModel(), personForPrint.getCar().getSpeed()));
        }
        System.out.println("Pokemon:");
        if (!personForPrint.getPokemons().isEmpty()) {
            for (Pokemons pokemon : personForPrint.getPokemons()) {
                System.out.print(pokemon.getName() + " ");
                System.out.print(pokemon.getType() + " ");
                System.out.println();
            }
        }
        System.out.println("Parents:");
        if (!personForPrint.getParents().isEmpty()) {
            for (Parents parent : personForPrint.getParents()) {
                System.out.print(parent.getName() + " ");
                System.out.print(parent.getBirthday() + " ");
                System.out.println();
            }
        }
        System.out.print("Children:");
        if (!personForPrint.getChildren().isEmpty()) {
            System.out.println();
            int count = personForPrint.getChildren().size();
            for (Children children : personForPrint.getChildren()) {
                count --;
                System.out.print(children.getName() + " " + children.getBirthday());
                if (count > 0){
                    System.out.println();
                }
            }
        }

    }
}
