package it.univaq.disim.sose.application.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import it.univaq.disim.sose.application.R;
import it.univaq.disim.sose.application.models.Result;

public class ResultAdapter extends ArrayAdapter<Result> {

    private Context mContext;
    private int mResource;
    //Constructor
    public ResultAdapter(@NonNull Context context, int resource, ArrayList<Result> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource,parent,false);

        ImageView imageView = convertView.findViewById(R.id.imageView_row);
        TextView titleView = convertView.findViewById(R.id.Title_row);
        TextView descriptionView = convertView.findViewById(R.id.Description_row);

        //Set image resource here
        Picasso.with(mContext).load(getItem(position).getImage()).into(imageView);
        titleView.setText(getItem(position).getTitle());
        descriptionView.setText(getItem(position).getDescription());


        return convertView;
    }
}
