package com.lasalle.second.part.ghostlocator.view.fragment;

import android.location.Address;
import android.location.Geocoder;
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
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.lasalle.second.part.ghostlocator.R;
import com.lasalle.second.part.ghostlocator.view.activity.MainActivity;
import com.lasalle.second.part.ghostlocator.view.model.Ghost;

import java.util.List;

public class MapFragment extends Fragment implements OnMapReadyCallback {
    private MapView mapView;

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
        // Inflate the layout for this fragment
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

      /*  LatLngBounds bounds = new LatLngBounds(
                new LatLng(51.5095013, -0.486029),
                new LatLng(51.5919139,-0.4031429));*/

       /* googleMap.setLatLngBoundsForCameraTarget(bounds);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 4));*/

        List<Ghost> list = ((MainActivity) getActivity()).getGhostList();
       for (Ghost ghost : list){
           Marker marker = googleMap.addMarker(
                   new MarkerOptions()
                           .position(ghost.getLocation()));
           marker.setTag(ghost.getId());
           marker.setTitle(ghost.getName());
       }


        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                return false;
            }
        });
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
}