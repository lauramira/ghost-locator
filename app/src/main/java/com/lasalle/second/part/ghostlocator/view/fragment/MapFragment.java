package com.lasalle.second.part.ghostlocator.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.lasalle.second.part.ghostlocator.R;
import com.lasalle.second.part.ghostlocator.view.activity.MainActivity;
import com.lasalle.second.part.ghostlocator.view.model.Ghost;

import java.util.List;

public class MapFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    private MapView mapView;

    private MapFragment.MapFragmentEvent callback;

    public interface MapFragmentEvent {
        void onMarkerClick(Integer id);
    }

    public static MapFragment newInstance() {
        MapFragment fragment = new MapFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_map, container, false);
        mapView = (MapView) view.findViewById(R.id.map_view);

        mapView.onCreate(savedInstanceState);

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mapView.getMapAsync(this);
        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLngBounds.Builder bounds = new LatLngBounds.Builder();


        List<Ghost> list = ((MainActivity) getActivity()).getGhostList();
       for (Ghost ghost : list){
           Marker marker = googleMap.addMarker(
                   new MarkerOptions()
                           .position(ghost.getLocation()));
           marker.setTag(ghost.getId());
           marker.setTitle(ghost.getName());

           bounds.include(ghost.getLocation());
       }
        googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds.build(), 130));
        googleMap.setOnMarkerClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        if(mapView != null){
            mapView.onStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mapView != null){
            mapView.onResume();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mapView != null){
            mapView.onDestroy();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mapView != null){
            mapView.onStop();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(mapView != null) {
            mapView.onSaveInstanceState(outState);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        callback = (MapFragment.MapFragmentEvent) context;
    }


    @Override
    public boolean onMarkerClick(Marker marker) {
        callback.onMarkerClick(Integer.parseInt(marker.getTag().toString()));
        return false;

    }


}