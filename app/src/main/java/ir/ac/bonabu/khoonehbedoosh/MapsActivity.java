package ir.ac.bonabu.khoonehbedoosh;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import Modules.DirectionFinder;
import Modules.DirectionFinderListener;
import Modules.Route;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, DirectionFinderListener, GoogleMap.OnMarkerClickListener, GoogleMap.OnInfoWindowClickListener {

    private boolean flag=true;

    public static GoogleMap mMap;
    private ImageView btnFindPath;
    private EditText etOrigin;
//    private EditText etDestination;
    private List<Marker> originMarkers = new ArrayList<>();
    private List<Marker> destinationMarkers = new ArrayList<>();
    private List<Polyline> polylinePaths = new ArrayList<>();
    private ProgressDialog progressDialog;

//    private Marker marker;

    ArrayList<LatLng> listPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btnFindPath = (ImageView) findViewById(R.id.btnFindPath);
        etOrigin = (EditText) findViewById(R.id.etOrigin);
//        etDestination = (EditText) findViewById(R.id.etDestination);


        btnFindPath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
            }
        });

        listPoints=new ArrayList<>();

    }


    private void sendRequest() {
        String origin = etOrigin.getText().toString();
//        String destination = etDestination.getText().toString();
        if (origin.isEmpty()) {
            Toast.makeText(this, "Please enter origin address!", Toast.LENGTH_SHORT).show();
            return;
        }
//        if (destination.isEmpty()) {
//            Toast.makeText(this, "Please enter destination address!", Toast.LENGTH_SHORT).show();
//            return;
//        }

        try {
            new DirectionFinder(this, origin,origin).execute();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        LatLng hcmus = new LatLng(35.692333, 51.393076);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hcmus, 12));
        mMap.getUiSettings().setZoomControlsEnabled(true);
      //  mMap.getUiSettings().setCompassEnabled(true);
      //  Button btnShowLocation = (Button) findViewById(R.id.btnmylocation);

        // show location button click event
//        btnShowLocation.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View arg0) {
//                // create class object
//                GPSTracker gps = new GPSTracker(MapsActivity.this);
//
//                // check if GPS enabled
//                if(gps.canGetLocation()){
//
//                    double latitude = gps.getLatitude();
//                    double longitude = gps.getLongitude();
//
//                    // \n is for new line
//                    LatLng location= new LatLng(latitude, longitude);
//                    Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
//                }else{
//                    // can't get location
//                    // GPS or Network is not enabled
//                    // Ask user to enable GPS/network in settings
//                    gps.showSettingsAlert();
//                }
//
//            }
//        });showSettingsAlert

//        originMarkers.add(mMap.addMarker(new MarkerOptions()
//                .title("Đại học Khoa học tự nhiên")
//                .position(hcmus)));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
//originMarkers.add(mMap.addMarker(new MarkerOptions()
//                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.start_blue))
//                .title(route.startAddress)
//                .position(route.startLocation)));

        mMap.setOnInfoWindowClickListener(this);

//Example.sharedPreferences.getBoolean("malek",false)
        if (CutomerActivity.malek) {
            mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng latLng) {
                    listPoints.add(latLng);

                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.position(latLng);

                    if(flag) {
                        originMarkers.add(mMap.addMarker(new MarkerOptions().position(latLng)));
                        Marker marker=mMap.addMarker(new MarkerOptions().position(latLng).title("ثبت مشخصات"));
                        marker.showInfoWindow();
                        flag = false;
                    }
                    else {
                        if (originMarkers.size()>0)
                            originMarkers.remove(originMarkers.size()-1);
                        mMap.clear();
                        originMarkers.add(mMap.addMarker(new MarkerOptions().position(latLng)));
                        Marker marker=mMap.addMarker(new MarkerOptions().position(latLng).title("ثبت مشخصات"));
                        marker.showInfoWindow();
                    }

//                markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.start_blue));
//
//                mMap.addMarker(markerOptions);
                }
            });
        }
        else
        {
            ArrayList<LatLng> latLngs=new ArrayList<>();
            LatLng hcmus1 = new LatLng(35.692333, 51.393076);
          //  hcmus1.latitude
            latLngs.add(hcmus1);
            LatLng hcmus2 = new LatLng(35.0, 50.0);
            latLngs.add(hcmus2);
            LatLng hcmus3 = new LatLng(34.5, 49.0);
            latLngs.add(hcmus3);
            LatLng hcmus4 = new LatLng(37.0, 40.0);
            latLngs.add(hcmus4);
            drowLocation(latLngs);

        }
//        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
//            @Override
//            public void onMapLongClick(LatLng latLng) {
//                listPoints.add(latLng);
//
//                MarkerOptions markerOptions=new MarkerOptions();
//                markerOptions.position(latLng);
//
//                markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.start_blue));
//
//                mMap.addMarker(markerOptions);
//            }
//        });
    }

    public void drowLocation(ArrayList<LatLng> list)
    {
//        Drawable myDrawable= ResourcesCompat.getDrawable(getResources(),R.drawable.start_blue,null);
//        Bitmap bit= ((BitmapDrawable)myDrawable).getBitmap();

//        InfoWindowData info=new InfoWindowData();
//
//        CustomInfoWindowGoogleMap customInfoWindow = new CustomInfoWindowGoogleMap(this);

        for(int x=0;x<list.size();x++) {
//            info.setImage(BitmapDescriptorFactory.fromBitmap(bit));
//            info.setHotel("ssfdsfsd");
//            info.setFood("sfsdfds");
//            info.setTransport("dfdsfsd");

//            mMap.setInfoWindowAdapter(customInfoWindow);

            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(list.get(x))
                    .title("Snowqualmie Falls")
                    .snippet("Snoqualmie Falls is located 25 miles east of Seattle.")
                    .icon(BitmapDescriptorFactory.defaultMarker( BitmapDescriptorFactory.HUE_BLUE));

            CustomInfoWindowAdapter adapter = new CustomInfoWindowAdapter(MapsActivity.this);
            mMap.setInfoWindowAdapter(adapter);

//            originMarkers.add(mMap.addMarker(new MarkerOptions().position(list.get(x))));
            Marker m = mMap.addMarker(markerOptions);
            m.showInfoWindow();
        }
    }

    @Override
    public void onDirectionFinderStart() {
        progressDialog = ProgressDialog.show(this, "Please wait.",
                "Finding direction..!", true);

        if (originMarkers != null) {
            for (Marker marker : originMarkers) {
                marker.remove();
            }
        }

        if (destinationMarkers != null) {
            for (Marker marker : destinationMarkers) {
                marker.remove();
            }
        }

        if (polylinePaths != null) {
            for (Polyline polyline:polylinePaths ) {
                polyline.remove();
            }
        }
    }

    @Override
    public void onDirectionFinderSuccess(List<Route> routes) {
        progressDialog.dismiss();
        polylinePaths = new ArrayList<>();
        originMarkers = new ArrayList<>();
        destinationMarkers = new ArrayList<>();

        for (Route route : routes) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(route.startLocation, 12));
//            ((TextView) findViewById(R.id.tvDuration)).setText(route.duration.text);
//            ((TextView) findViewById(R.id.tvDistance)).setText(route.distance.text);

//            originMarkers.add(mMap.addMarker(new MarkerOptions()
//                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.start_blue))
//                    .title(route.startAddress)
//                    .position(route.startLocation)));
//            destinationMarkers.add(mMap.addMarker(new MarkerOptions()
//                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.end_green))
//                    .title(route.endAddress)
//                    .position(route.endLocation)));
//
//            PolylineOptions polylineOptions = new PolylineOptions().
//                    geodesic(true).
//                    color(Color.BLUE).
//                    width(10);
//
//            for (int i = 0; i < route.points.size(); i++)
//                polylineOptions.add(route.points.get(i));
//
//            polylinePaths.add(mMap.addPolyline(polylineOptions));
        }
    }



    @Override
    public void onInfoWindowClick(Marker marker) {
        Intent intent =new Intent(MapsActivity.this,)
    }

    @Override
    public boolean onMarkerClick(Marker marker)
    {
//        marker.setTitle("ssdfkjdbfsk");
//        marker.showInfoWindow();
//
        return false;
    }
}
