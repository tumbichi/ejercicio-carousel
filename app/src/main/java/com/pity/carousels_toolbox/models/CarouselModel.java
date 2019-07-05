package com.pity.carousels_toolbox.models;

import java.util.ArrayList;

public class CarouselModel {
    private String title;
    private String type;
    private ArrayList<CarouselItemModel> itemsCorousel;

    public CarouselModel (String title, String type, ArrayList<CarouselItemModel> itemList){
        this.title = title;
        this.type = type;
        this.itemsCorousel = itemList;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<CarouselItemModel> getItemsCorousel() {
        return itemsCorousel;
    }
}
