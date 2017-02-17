package com.lasalle.second.part.ghostlocator.view;

import android.app.Application;

import com.lasalle.second.part.ghostlocator.view.data.impl.GhostDataMock;
import com.lasalle.second.part.ghostlocator.view.data.manager.GhostManager;

/**
 * Created by Usuario on 17/02/2017.
 */

public class ApplicationCustom extends Application {

    private GhostManager ghostManager;

    @Override
    public void onCreate() {
        ghostManager = new GhostManager(new GhostDataMock());
    }

    public GhostManager getGhostManager(){
        return ghostManager;
    }
}
