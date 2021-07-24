package am.aca.generactive.mock;

import am.aca.generactive.model.GenerativeItem;
import am.aca.generactive.model.Item;
import am.aca.generactive.model.StockItem;
import am.aca.generactive.util.idgenerator.IdGenerator;
import am.aca.generactive.util.idgenerator.Type;
import am.aca.generactive.util.namegenerator.NameGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class ItemMock {

    public static Item getItem(Class<? extends Item> clazz) {
        Item item;
        if (clazz == GenerativeItem.class) {
            item = new GenerativeItem(IdGenerator.getNext(Type.GROUP),
                    generateRandomPrice(), NameGenerator.getRandomName());
        } else {
            item =  new StockItem(IdGenerator.getNext(Type.GROUP),
                    generateRandomPrice(), NameGenerator.getRandomName());
        }

        return item;
    }

    public static List<Item> getItems(int count) {
        List<Item> rv = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            rv.add(getItem(i % 2 == 0 ? GenerativeItem.class : StockItem.class));
        }

        return rv;
    }

    private static int generateRandomPrice() {
        return new Random().nextInt(8) * 100;
    }

    private ItemMock() {

    }
}
