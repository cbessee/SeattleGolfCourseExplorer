package com.development.cbessee.golfcoursecatalog;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import golfbertAPIClient.ApiException;
import golfbertAPIClient.api.GolfbertApi;
import golfbertAPIClient.models.Address;
import golfbertAPIClient.models.Course;
import golfbertAPIClient.models.Listofcourses;

import java.util.ArrayList;
import java.util.Collection;

public class CoursesActivity extends AppCompatActivity {

    class RetrieveCoursesTask extends AsyncTask<Void, Void, Listofcourses> {

        protected GolfbertApi apiInstance;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            this.apiInstance = new GolfbertApi();
        }

        @Override
        protected Listofcourses doInBackground(Void... params) {
            try {
                Listofcourses listofcourses = this.apiInstance.listCourses(10, null, null, null, null, null, null, null );
                return listofcourses;
            } catch (ApiException e) {
                return new Listofcourses();
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        ListView coursesList = (ListView) findViewById(R.id.coursesList);

        final ArrayList<Course> courses = new ArrayList<Course>();

        try {
            RetrieveCoursesTask task = new RetrieveCoursesTask();
            Listofcourses listofcourses = task.execute().get();
            courses.addAll(listofcourses.getResources());
        } catch (Exception e) {
            e.printStackTrace();
        }

        CourseListAdapter coursesAdpater = new CourseListAdapter(courses, this);
        coursesList.setAdapter(coursesAdpater);

        coursesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Course course = courses.get(i);
                Integer courseId = course.getId();

                Intent viewCourseIntent = new Intent(getApplicationContext(), SingleCourseActivity.class);
                viewCourseIntent.putExtra("courseId", courseId);
                startActivity(viewCourseIntent);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
