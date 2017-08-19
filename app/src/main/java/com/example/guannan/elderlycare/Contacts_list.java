package com.example.guannan.elderlycare;

/**
 * Created by guannan on 15/8/2017.
 */

public class Contacts_list {
    private String name;
    private int ImageId;

    public Contacts_list(String name, int ImageId){
        this.name = name;
        this.ImageId = ImageId;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return ImageId;
    }
}
