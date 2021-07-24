package am.aca.generactive.util.namegenerator;

import java.util.Random;

public class NameGenerator {

    private static final Random random = new Random();

    public static String getRandomName() {
        return String.format("%s %s",
                capitalizeFirstLetter(Adjectives.LIST[random.nextInt(Adjectives.LIST.length)]),
                capitalizeFirstLetter(Nouns.LIST[random.nextInt(Nouns.LIST.length)]));
    }

    private static String capitalizeFirstLetter(String value) {
        if (value == null || value.isEmpty()) {
            return value;
        }

        return value.substring(0, 1).toUpperCase() + value.substring(1);
    }
}
