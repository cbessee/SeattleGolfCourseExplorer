package com.development.cbessee.golfcoursecatalog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import golfbertAPIClient.models.Address;
import golfbertAPIClient.models.Course;

import java.util.ArrayList;


public class CourseListAdapter extends ArrayAdapter<Course> implements View.OnClickListener{

    private ArrayList<Course> course;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView txtAddress;
    }

    public CourseListAdapter(ArrayList<Course> data, Context context) {
        super(context, R.layout.course_list_item, data);
        this.course = data;
        this.mContext=context;
    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        Course course = (Course) object;

        /* Create intent to view this courses details? */
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Course course = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.course_list_item, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtAddress = (TextView) convertView.findViewById(R.id.address);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.txtName.setText(course.getName());
        Address address = course.getAddress();
        String addressString = address.getStreet() + ", " + address.getCity() + ", " + address.getState() + " " + address.getZip();
        viewHolder.txtAddress.setText(addressString);
        // Return the completed view to render on screen
        return convertView;
    }
}