package com.development.cbessee.golfcoursecatalog;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

import golfbertAPIClient.ApiException;
import golfbertAPIClient.api.GolfbertApi;
import golfbertAPIClient.models.Address;
import golfbertAPIClient.models.Course;

public class SingleCourseActivity extends AppCompatActivity {

    private MapView mapView;
    private MapboxMap mapboxMap;
    private RetrieveCourseTask task;

    class RetrieveCourseTask extends AsyncTask<Integer, Void, Course> {

        protected GolfbertApi apiInstance;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            this.apiInstance = new GolfbertApi();
        }

        @Override
        protected Course doInBackground(Integer... courseId) {
            try {
                Course course = this.apiInstance.getCourse(courseId[0]);
                return course;
            } catch (ApiException e) {
                return new Course();
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_course);

        Integer courseId = null;
        Course course = null;

        /* Get course Id from intent and fetch course details */
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            courseId = extras.getInt("courseId");
        }

        try {
            task = new RetrieveCourseTask();
            course = task.execute(courseId).get();
            setCourseTexts(course);
            initializeMap(savedInstanceState, course);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Build ArrayList of hole objects from golfbert */
        /* Add hole polygons from golfbert to map */

    }

    protected void initializeMap(Bundle savedInstanceState, final Course course) {
        Mapbox.getInstance(this, getString(R.string.mapbox_app_token));
        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {

                Double lat = course.getCoordinates().getLat();
                Double lng = course.getCoordinates().getLong();

                CameraPosition position = new CameraPosition.Builder()
                        .target(new LatLng(lat, lng)) // Sets the new camera position
                        .zoom(11) // Sets the zoom
                        .build(); // Creates a CameraPosition from the builder

                mapboxMap.animateCamera(CameraUpdateFactory
                        .newCameraPosition(position), 5000);


            }
        });
    }

    /* Get assorted text views and bind course data to them */
    protected void setCourseTexts(Course course) {
        TextView txtName = (TextView) findViewById(R.id.courseName);
        txtName.setText(course.getName());

        TextView txtAddress = (TextView) findViewById(R.id.address);
        Address address = course.getAddress();
        String addressString = address.getStreet() + ", " + address.getCity() + ", " + address.getState() + " " + address.getZip();
        txtAddress.setText(addressString);

        TextView txtPhone = (TextView) findViewById(R.id.phone);
        txtPhone.setText(course.getPhonenumber());
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
        task.cancel(true);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}
