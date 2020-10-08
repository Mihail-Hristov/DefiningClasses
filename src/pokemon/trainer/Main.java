package pokemon.trainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!"Tournament".equals(input)){
            String[] tokens = input.split("\\s+");

            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, element, health);
            Trainer trainer;
            if (trainers.containsKey(trainerName)){
                trainer = trainers.get(trainerName);
            }else {
                trainer = new Trainer(trainerName, new ArrayList<>());
            }
            trainers.putIfAbsent(trainerName, trainer);
            List<Pokemon> currentList = trainers.get(trainerName).getPokemons();
            currentList.add(pokemon);
            trainers.put(trainerName, trainer);

            input = scanner.nextLine();
        }

        String elements = scanner.nextLine();

        while (!"End".equals(elements)){
            String finalElements = elements;
            trainers.entrySet()
                    .forEach(t -> {
                        if (t.getValue().checkForElement(finalElements)) {
                            t.getValue().plusOneBadge();
                        }else {
                            t.getValue().lossHealth();
                        }

                        t.getValue().checkForDead();

                    });


            elements = scanner.nextLine();
        }

        trainers.entrySet()
                .stream()
                .sorted((t1, t2) -> Integer.compare(t2.getValue().getBadges(), t1.getValue().getBadges()))
                .forEach(t -> {
                    Trainer trainer = t.getValue();
                    System.out.println(trainer.getName() + " " + trainer.getBadges() + " " + trainer.getPokemons().size());
                });

    }
}
