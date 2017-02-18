package com.lasalle.second.part.ghostlocator.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lasalle.second.part.ghostlocator.R;
import com.lasalle.second.part.ghostlocator.view.activity.MainActivity;
import com.lasalle.second.part.ghostlocator.view.model.Ghost;

public class ProfileFragment extends Fragment {

    private TextView textView;
    private ImageView imageView;

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
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
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        textView = (TextView) view.findViewById(R.id.fragment_profile_text_view_name);
        imageView = (ImageView) view.findViewById(R.id.fragment_profile_image_view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Ghost ghost = ((MainActivity) getActivity()).getGhost();
        textView.setText(ghost.getName());

        imageView.setImageResource(ghost.getImageUrl());



    }
}
