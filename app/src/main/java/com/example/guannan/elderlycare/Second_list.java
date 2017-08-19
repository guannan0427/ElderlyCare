package com.example.guannan.elderlycare;

/**
 * Created by guannan on 15/8/2017.
 */

public class Second_list {
    private String secondItem_name;
    private int secondItem_ImageId;

    public Second_list(String name, int ImageId){
        this.secondItem_name = name;
        this.secondItem_ImageId = ImageId;
    }

    public String getName(){
        return secondItem_name;
    }

    public int getImageId(){
        return secondItem_ImageId;
    }
}
