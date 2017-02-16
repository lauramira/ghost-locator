package com.lasalle.second.part.ghostlocator.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lasalle.second.part.ghostlocator.R;

public class FirstUserExperienceFragment extends Fragment {

    public static FirstUserExperienceFragment newInstance() {
        FirstUserExperienceFragment fragment = new FirstUserExperienceFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_user_experience, container, false);
    }
}
