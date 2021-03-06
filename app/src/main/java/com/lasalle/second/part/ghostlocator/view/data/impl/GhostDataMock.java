package com.lasalle.second.part.ghostlocator.view.data.impl;

import com.google.android.gms.maps.model.LatLng;
import com.lasalle.second.part.ghostlocator.R;
import com.lasalle.second.part.ghostlocator.view.data.GhostData;
import com.lasalle.second.part.ghostlocator.view.model.Ghost;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Usuario on 17/02/2017.
 */

public class GhostDataMock implements GhostData {
    private List<Ghost> movieGhosts;
    private List<Ghost> harryPotterGhosts;
    private List<Ghost> videoGamesGhosts;


    @Override
    public List<Ghost> getAll() {
        List<Ghost> list = new ArrayList<>();
        list.addAll(movieGhosts);
        list.addAll(harryPotterGhosts);
        list.addAll(videoGamesGhosts);

        return list;
    }

    public GhostDataMock() {
        this.movieGhosts = new ArrayList<>(Arrays.asList(
                new Ghost(1, R.drawable.fantasma1, new LatLng(51.6895013, -0.4254354), "ghostbusters"),
                new Ghost(4, R.drawable.fantasma4, new LatLng(51.6945013, -0.4274354), "Casper")
        ));


        this.harryPotterGhosts = new ArrayList<>(Arrays.asList(
                new Ghost(3, R.drawable.fantasma3, new LatLng(51.6925013, -0.4244354), "Nicholas de Mimsy-Porpington"),
                new Ghost(5, R.drawable.fantasma5, new LatLng(51.6915013, -0.4214354), "Myrtle Warren")
        ));

        this.videoGamesGhosts = new ArrayList<>(Arrays.asList(
                new Ghost(2, R.drawable.fantasma2, new LatLng(51.6945013, -0.4235354), "Mario ghost"),
                new Ghost(6, R.drawable.fantasma6, new LatLng(51.6965013, -0.4244354), "Comecocos"),
                new Ghost(7, R.drawable.fantasma7, new LatLng(51.6995013, -0.4254354), "Haunter")
        ));
    }

    @Override
    public List<Ghost> getByMovie() {
        return movieGhosts;
    }

    @Override
    public List<Ghost> getByHarryPotter() {
        return harryPotterGhosts;
    }

    @Override
    public List<Ghost> getByVideoGames() {
        return videoGamesGhosts;
    }

    @Override
    public Ghost get(Integer id) {
        for (Ghost ghost : getAll()){
            if (ghost.getId() == id){
                return ghost;
            }
        }

        return null;
    }
}
