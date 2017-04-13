package com.gangzi.meterialdesign;

/**
 * Created by Administrator on 2017/3/28.
 */

public class Picture {
    private String name;
    private int imageId;

    public Picture(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
