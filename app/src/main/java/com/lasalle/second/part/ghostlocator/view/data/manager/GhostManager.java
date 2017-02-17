package com.lasalle.second.part.ghostlocator.view.data.manager;

import com.lasalle.second.part.ghostlocator.view.data.GhostData;
import com.lasalle.second.part.ghostlocator.view.model.Ghost;

import java.util.List;

/**
 * Created by Usuario on 17/02/2017.
 */

public class GhostManager {
    private GhostData ghostData;

    public GhostManager(GhostData ghostData) {
        this.ghostData = ghostData;
    }

    public List<Ghost> getGhosts(){
        return this.ghostData.getAll();
    }

    public Ghost getGhost(Integer id){
        return this.ghostData.get(id);
    }
}
