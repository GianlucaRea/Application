package it.univaq.disim.sose.application.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import java.util.ArrayList;

import it.univaq.disim.sose.application.R;
import it.univaq.disim.sose.application.models.Review;

public class ReviewAdapter extends ArrayAdapter<Review> {

    private Context mContext;
    private int mResource;
    //Constructor
    public ReviewAdapter(@NonNull Context context, int resource, ArrayList<Review> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource,parent,false);

        TextView titleView = convertView.findViewById(R.id.Review_Title_row);
        TextView descriptionView = convertView.findViewById(R.id.Review_Description_row);

        titleView.setText(getItem(position).getTitle());
        descriptionView.setText(getItem(position).getComment());

        return convertView;
    }
}
