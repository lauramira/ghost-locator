package com.lasalle.second.part.ghostlocator.view.data.impl;

import com.google.android.gms.maps.model.LatLng;
import com.lasalle.second.part.ghostlocator.view.data.GhostData;
import com.lasalle.second.part.ghostlocator.view.model.Ghost;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Usuario on 17/02/2017.
 */

public class GhostDataMock implements GhostData {
    private List<Ghost> list;

    public GhostDataMock() {
        this.list = new ArrayList<>(Arrays.asList(
                new Ghost(1, "fantasma1.jpg", new LatLng(51.6615013, -0.4614354), "ghostbusters"),
                new Ghost(2, "fantasma2.png", new LatLng(51.7715013, -0.4714354), "Mario ghost"),
                new Ghost(3, "fantasma3.jpg", new LatLng(51.6925013, -0.4244354), "Nicholas de Mimsy-Porpington"),
                new Ghost(4, "fantasma4.jpg", new LatLng(51.7915013, -0.4414354), "Casper"),
                new Ghost(5, "fantasma5.jpg", new LatLng(51.6915013, -0.4214354), "Myrtle Warren"),
                new Ghost(6, "fantasma6.png", new LatLng(51.6895013, -0.4614354), "Comecocos")
        ));
    }

    @Override
    public List<Ghost> getAll() {
        return list;
    }

    @Override
    public Ghost get(Integer id) {
        for (Ghost ghost : list){
            if (ghost.getId() == id){
                return ghost;
            }
        }

        return null;
    }
}
