package com.example.yspark.FavouriteView;

public class ImagePark {
    private int resourceId;
    private int textId;
    private String name, id;

    public ImagePark(int textId , int resourceId, String name, String id) {
        this.textId = textId;
        this.resourceId = resourceId;
        this.name = name;
        this.id = id;
    }

    public int getTextId() { return textId; }
    public int getResourceId() { return resourceId; }
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setTextId(int textId) { this.textId = textId; }

    public void setResourceId(int resourceId) { this.resourceId = resourceId; }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }
}
