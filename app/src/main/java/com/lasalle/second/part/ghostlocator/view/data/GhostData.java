package com.lasalle.second.part.ghostlocator.view.data;

import com.lasalle.second.part.ghostlocator.view.model.Ghost;

import java.util.List;

/**
 * Created by Usuario on 17/02/2017.
 */

public interface GhostData {

    List<Ghost> getAll();
    Ghost get(Integer id);
}
