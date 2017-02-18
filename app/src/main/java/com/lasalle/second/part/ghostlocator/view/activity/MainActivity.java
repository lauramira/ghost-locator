package com.lasalle.second.part.ghostlocator.view.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.lasalle.second.part.ghostlocator.R;
import com.lasalle.second.part.ghostlocator.view.AbstractActivity;
import com.lasalle.second.part.ghostlocator.view.GhostType;
import com.lasalle.second.part.ghostlocator.view.fragment.FirstUserExperienceFragment;
import com.lasalle.second.part.ghostlocator.view.fragment.MapFragment;
import com.lasalle.second.part.ghostlocator.view.fragment.ProfileFragment;
import com.lasalle.second.part.ghostlocator.view.fragment.SearchFragment;
import com.lasalle.second.part.ghostlocator.view.model.Ghost;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AbstractActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener,
        FirstUserExperienceFragment.FirstUserExperienceFragmentEvents,
        SearchFragment.SearchFragmentEvents{

    private BottomNavigationView bottomNavigationView;
    private static final String USER_EXPERIENCE_KEY = "userExperienceExecuted";
    private static final String FILE_NAME = "ghostLocator";
    private GhostType ghostType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.main_activity_bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        SharedPreferences sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        Boolean userExperienceExecuted = sharedPreferences.getBoolean(USER_EXPERIENCE_KEY, false);
        if (!userExperienceExecuted) {
            displayFirstUserExperience();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(USER_EXPERIENCE_KEY, true);
            editor.commit();
        } else {
            bottomNavigationView.setVisibility(View.VISIBLE);
            View view = bottomNavigationView.findViewById(R.id.activity_main_bottom_menu_search);
            view.performClick();
        }

        ghostType = GhostType.ALL;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if((item.getItemId() == R.id.activity_main_bottom_menu_search) ||
           (item.getItemId() == R.id.activity_main_bottom_menu_map) ||
           (item.getItemId() == R.id.activity_main_bottom_menu_profile))
        {
            setUpFragment(item.getItemId());
            return true;
        }

        return false;
    }

    @Override
    public void onStartButtonClicked() {
        bottomNavigationView.setVisibility(View.VISIBLE);
        setUpFragment(R.id.activity_main_bottom_menu_search);
    }

    private void setUpFragment(int id) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment existingFragment = fragmentManager.findFragmentByTag(Integer.toString(id));
        if(existingFragment == null) {
            existingFragment = createFragment(id);
        }

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_activity_fragment_container, existingFragment, Integer.toString(id));
        fragmentTransaction.commit();
    }

    private Fragment createFragment(int id) {
        Fragment fragment = null;

        if(id == R.id.activity_main_bottom_menu_search) {
            fragment = SearchFragment.newInstance();
        }
        else if(id == R
                .id.activity_main_bottom_menu_map) {
            fragment = MapFragment.newInstance();
        }
        else if(id == R.id.activity_main_bottom_menu_profile) {
            fragment = ProfileFragment.newInstance();
        }
        else if(id == R.id.first_user_experience_fragment) {
            fragment = FirstUserExperienceFragment.newInstance();
        }

        return fragment;
    }

    private void displayFirstUserExperience() {
        bottomNavigationView.setVisibility(View.GONE);
        setUpFragment(R.id.first_user_experience_fragment);
    }

    @Override
    public void onSearchButtonClicked(GhostType ghostType) {
        this.ghostType = ghostType;
        View view = bottomNavigationView.findViewById(R.id.activity_main_bottom_menu_map);
        view.performClick();
    }

    public List<Ghost> getGhostList() {
        if (ghostType.getId() == GhostType.ALL.getId()){
            return getGhostManager().getGhosts();
        } else if (ghostType.getId() == GhostType.HARRY_POTTER.getId()){
            return getGhostManager().getGhostByHarryPotter();
        } else if (ghostType.getId() == GhostType.MOVIE.getId()){
            return getGhostManager().getGhostByMovie();
        } else if (ghostType.getId() == GhostType.VIDEO_GAMES.getId()){
            return getGhostManager().getGhostByVideoGames();
        }

        return new ArrayList<>();
    }
}
