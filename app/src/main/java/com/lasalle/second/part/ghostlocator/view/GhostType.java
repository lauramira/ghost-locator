package com.lasalle.second.part.ghostlocator.view;

/**
 * Created by Usuario on 17/02/2017.
 */

public enum GhostType {
    ALL(1),
    MOVIE(2),
    VIDEO_GAMES(3),
    HARRY_POTTER(4);

    GhostType(int id) {
        this.id = id;
    }

    private int id;

    public int getId() {
        return id;
    }
}
