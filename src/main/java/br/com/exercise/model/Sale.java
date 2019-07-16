package br.com.exercise.model;

import java.util.List;

public class Sale extends AbstractEntity{

    public static final String SALE_CODE = "003";

    private List<Item> itemList;

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
