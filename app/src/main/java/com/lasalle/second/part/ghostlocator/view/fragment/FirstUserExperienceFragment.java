package com.lasalle.second.part.ghostlocator.view.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.lasalle.second.part.ghostlocator.R;

public class FirstUserExperienceFragment extends Fragment implements Button.OnClickListener {

    public interface FirstUserExperienceFragmentEvents {
        void onStartButtonClicked();
    }

    private FirstUserExperienceFragmentEvents callback;

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
        View view = inflater.inflate(R.layout.fragment_first_user_experience, container, false);

        Button button = (Button) view.findViewById(R.id.first_user_experience_start_button);
        button.setOnClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        callback = (FirstUserExperienceFragmentEvents) context;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.first_user_experience_start_button) {
            callback.onStartButtonClicked();
        }
    }
}
