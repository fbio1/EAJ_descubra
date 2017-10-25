package br.eaj.tads.eaj_descubra;

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
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Taniro on 28/09/2016.
 */

public class FragmentMapa extends Fragment implements OnMapReadyCallback {

    GoogleMap mGoogleMap;
    MapView mMapView;
    View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        mView = inflater.inflate(R.layout.fragment_mapa, container, false);
        //logica do fragment
        return mView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mMapView = (MapView) mView.findViewById(R.id.map);

        if(mMapView != null){
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        MapsInitializer.initialize(getContext());
        mGoogleMap = googleMap;

        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        FragmentRecycler fragmentRecycler = new FragmentRecycler();

        googleMap.addMarker(new MarkerOptions().position(new LatLng(-5.884968, -35.364468)).title("EAJ").snippet("Graduação EAJ"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-5.885786, -35.365748)).title("Predio da Informatica"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng( -5.884567, -35.364924)).title("CVT"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng( -5.885205, -35.364782)).title("Ensino medio"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-5.884953, -35.365646)).title("Instituto do bosque"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-5.887602, -35.361685)).title("Aquicultura"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-5.885911, -35.366131)).title("Biblioteca"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-5.885883, -35.363646)).title("Alojamento Masculino"));
        //Apicolas
        //alojamento feminino
        //avicultura
        //capela
        //diraçao
        //direçao etec
        //quadra
        //RU

        CameraPosition liberty = CameraPosition.builder().target(new LatLng(-5.884968, -35.364468)).zoom(16).bearing(0).build();

        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(liberty));
    }
}
