package com.example.assignment1;

import android.Manifest;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Objects;


public class CardViewItemFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    String category, name, district, address;
    double latitude, longitude;
    int image;

    ImageView introImageView;
    TextView nameTextView,categoryTextView, introTextView, addressTextView;

    GoogleMap gMap;
    private Marker currentMarker = null;
//    Location currentLocation = null;
//    double currentLatitude = 0;
//    double currentLongitude = 0;

    public CardViewItemFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_card_view_item, container, false);

        if (getArguments() != null) {
            category = getArguments().getString("category");
            name = getArguments().getString("name");
            district = getArguments().getString("district");
            address = getArguments().getString("address");
            latitude = Double.parseDouble(getArguments().getString("latitude"));
            longitude = Double.parseDouble(getArguments().getString("longitude"));
            image = Integer.parseInt(getArguments().getString("image"));

            categoryTextView = rootView.findViewById(R.id.categoryTv);
            nameTextView = rootView.findViewById(R.id.nameTv);
            introTextView = rootView.findViewById(R.id.introTv);
            addressTextView = rootView.findViewById(R.id.addressTv);
            introImageView = rootView.findViewById(R.id.introIv);

            categoryTextView.setText(category);
            nameTextView.setText(name);
            introTextView.setText(""); // 여기 채우기!!!!!! String.xml에서 문장넣어서 해보면 될듯
            addressTextView.setText(address);
            introImageView.setImageResource(image);

            ActivityResultLauncher<String[]> locationPermissionRequest =
                    registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), result -> {
                        Boolean fineLocationGranted = result.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false);
                        Boolean coarseLocationGranted = result.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION,false);
//                        if (fineLocationGranted != null && fineLocationGranted) {
//                            getCurrentLocation();
//                        } else if (coarseLocationGranted != null && coarseLocationGranted) {
//                            getCurrentLocation();
//                            Toast.makeText(getActivity(), "Only approximate location access granted", Toast.LENGTH_SHORT).show();
//                        } else {
//                            Toast.makeText(getActivity(), "Permission denied", Toast.LENGTH_SHORT).show();
//                        }
                    });


            locationPermissionRequest.launch(new String[] {
                    Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION});

            SupportMapFragment mapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.itemMap);
            mapFragment.getMapAsync(this);

        }

        return rootView;
    }

    @Override
    public void onInfoWindowClick(@NonNull Marker marker) {

    }

//    @Override
//    public void onMapReady(@NonNull GoogleMap googleMap) {
//        gMap = googleMap;
//        LatLng location = new LatLng(latitude, longitude);
//
//        MarkerOptions marker = new MarkerOptions();
//        marker.position(location);
//        marker.title(name);
////        marker.snippet("SEOUL");
//
//        Objects.requireNonNull(googleMap.addMarker(marker)).showInfoWindow();
//        gMap.setOnInfoWindowClickListener(this);
//        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 5));
//
//    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        if (getArguments() != null) {
//            double latitude = Double.parseDouble(getArguments().getString("latitude"));
//            double longitude = Double.parseDouble(getArguments().getString("longitude"));
            gMap = googleMap;
            LatLng DEFAULT_LatLng = new LatLng(latitude, longitude);

            MarkerOptions marker = new MarkerOptions();
            marker.position(DEFAULT_LatLng);
            marker.title(name);
            marker.snippet("Seoul");

            Objects.requireNonNull(googleMap.addMarker(marker)).showInfoWindow();
            gMap.setOnInfoWindowClickListener(this);
            gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(DEFAULT_LatLng, 15));
        }


//        double defaultLatitude = DEFAULT_LatLng.latitude;
//        double defaultLongitude = DEFAULT_LatLng.longitude;
    }


//    public void updateLocation(Location location) {
//        if (currentMarker != null) currentMarker.remove();
//        LatLng location_LatLng = new LatLng(latitude, longitude);
//        MarkerOptions marker = new MarkerOptions();
//        marker.position(location_LatLng);
//        marker.title(name);
////        marker.snippet("");
//        marker.draggable(true);
//        currentMarker = gMap.addMarker(marker);
//
//        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(location_LatLng, 13);
//        gMap.moveCamera(cameraUpdate);
//
//    }

}