package com.example.parkingapp.unimagadalena.parkingapp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class Mapa extends Fragment implements OnMapReadyCallback {
    private GoogleMap mMap;

    private OnFragmentInteractionListener mListener;

    public Mapa() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mapa2, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map1);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        UiSettings uiSettings = mMap.getUiSettings();
        uiSettings.setScrollGesturesEnabled(true);
        uiSettings.setCompassEnabled(true);

        if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(),
                android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION);
        }

        mMap.setMyLocationEnabled(true);

        LatLng p = new LatLng(11.226341,-74.188565);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(p,13));

        LatLng p1 = new LatLng(11.225306, -74.190706);
        mMap.addMarker(new MarkerOptions().position(p1).title("PARQUEADERO").snippet("El Tesoro"));

        LatLng p2 = new LatLng(11.223183, -74.189094);
        mMap.addMarker(new MarkerOptions().position(p2).title("PARQUEADERO").snippet("La Guaca"));

        LatLng p3 = new LatLng(11.224251, -74.182957);
        mMap.addMarker(new MarkerOptions().position(p3).title("PARQUEADERO").snippet("Park Center"));

        LatLng p4 = new LatLng(11.243796, -74.213501);
        mMap.addMarker(new MarkerOptions().position(p4).title("PARQUEADERO").snippet("Cubriseal"));

        LatLng p5 = new LatLng(11.233069, -74.193854);
        mMap.addMarker(new MarkerOptions().position(p5).title("PARQUEADERO").snippet("Paso Nivel"));

        LatLng p6 = new LatLng(11.242990, -74.207814);
        mMap.addMarker(new MarkerOptions().position(p6).title("PARQUEADERO").snippet("Pavimark"));

        LatLng p7 = new LatLng(11.239191, -74.209380);
        mMap.addMarker(new MarkerOptions().position(p7).title("PARQUEADERO").snippet("El Cartel"));

        LatLng p8 = new LatLng(11.220516, -74.188706);
        mMap.addMarker(new MarkerOptions().position(p8).title("PARQUEADERO").snippet("Socoda"));



    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
