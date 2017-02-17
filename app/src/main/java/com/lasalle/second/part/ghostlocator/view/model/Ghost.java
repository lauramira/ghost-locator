package com.lasalle.second.part.ghostlocator.view.model;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Usuario on 17/02/2017.
 */

public class Ghost {
    private int id;
    private String name;
    private LatLng location;
    private String imageUrl;

    public Ghost(int id, String imageUrl, LatLng location, String name) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.location = location;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
