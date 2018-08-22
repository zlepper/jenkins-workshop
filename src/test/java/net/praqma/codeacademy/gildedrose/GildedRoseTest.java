package net.praqma.codeacademy.gildedrose;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GildedRoseTest {
    GildedRose app;

    @Before
    public void initialize() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

        app = new GildedRose(items);
    }

    @Test
    public void foo() {
        assertEquals(10, app.items[0].sellIn);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        System.out.println("Hello world");
    }


    @Test
    public void foo2() {
        assertEquals(20, app.items[0].quality);
        app.updateQuality();
        assertEquals(19, app.items[0].quality);
    }
}
