package com.lasalle.second.part.ghostlocator.view.model;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Usuario on 17/02/2017.
 */

public class Ghost {
    private int id;
    private String name;
    private LatLng location;
    private int imageResourceId;

    public Ghost(int id, int imageResourceId, LatLng location, String name) {
        this.id = id;
        this.imageResourceId = imageResourceId;
        this.location = location;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImageUrl() {
        return imageResourceId;
    }

    public void setImageUrl(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
