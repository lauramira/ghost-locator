package com.lasalle.second.part.ghostlocator.view;

/**
 * Created by Usuario on 17/02/2017.
 */

public enum GhostType {
    ALL(1),
    MOVIE(2),
    VIDEO_GAMES(3),
    HARRY_POTTER(4);

    GhostType(Integer id) {
        this.id = id;
    }

    private Integer id;
}
