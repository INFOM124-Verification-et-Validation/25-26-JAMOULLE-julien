package com.gildedrose;

public class BetterGildedRose {

    Item[] items;

    public BetterGildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items){
            item.updateQuality();
        }
    }

}
