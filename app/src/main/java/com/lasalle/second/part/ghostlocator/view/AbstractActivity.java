package com.lasalle.second.part.ghostlocator.view;

import android.support.v7.app.AppCompatActivity;

import com.lasalle.second.part.ghostlocator.view.data.manager.GhostManager;

/**
 * Created by Usuario on 17/02/2017.
 */

public class AbstractActivity extends AppCompatActivity {

    public GhostManager getGhostManager(){
        return ((ApplicationCustom) getApplication()).getGhostManager();
    }
}
