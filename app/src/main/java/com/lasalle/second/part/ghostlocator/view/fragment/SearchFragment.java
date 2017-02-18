package com.lasalle.second.part.ghostlocator.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.gms.maps.MapView;
import com.lasalle.second.part.ghostlocator.R;
import com.lasalle.second.part.ghostlocator.view.GhostType;

public class SearchFragment extends Fragment implements Spinner.OnItemSelectedListener, View.OnClickListener {

    private GhostType ghostType;

    public interface SearchFragmentEvents {
        void onSearchButtonClicked(GhostType ghostType);
    }

    private SearchFragment.SearchFragmentEvents callback;

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        Button button = (Button) view.findViewById(R.id.fragment_search_button);
        button.setOnClickListener(this);

        Spinner spinner = (Spinner) view.findViewById(R.id.fragment_search_spinner);
        spinner.setOnItemSelectedListener(this);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Spinner spinner = (Spinner) getActivity().findViewById(R.id.fragment_search_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.ghosts_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ghostType = GhostType.ALL;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        callback = (SearchFragment.SearchFragmentEvents) context;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fragment_search_button){
            callback.onSearchButtonClicked(ghostType);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            switch (position){
                case 0:
                    ghostType = GhostType.ALL;
                    break;
                case 1:
                    ghostType = GhostType.HARRY_POTTER;
                    break;
                case 2:
                    ghostType = GhostType.MOVIE;
                    break;
                case 3:
                    ghostType = GhostType.VIDEO_GAMES;
                    break;
            }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
