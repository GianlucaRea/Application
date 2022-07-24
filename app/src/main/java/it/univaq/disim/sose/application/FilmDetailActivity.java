package it.univaq.disim.sose.application;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import it.univaq.disim.sose.application.adapters.ResultAdapter;
import it.univaq.disim.sose.application.adapters.ReviewAdapter;
import it.univaq.disim.sose.application.models.FilmDetail;
import it.univaq.disim.sose.application.models.RatingData;
import it.univaq.disim.sose.application.models.Review;

public class FilmDetailActivity extends Activity {

    private String TAG ="SOAPClient",searchText,filmID,userID,title,comment;
    private FilmDetail filmDetail;
    private ImageView imageView;
    private TextView titleView,descriptionView,filmRatings;
    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.film_detail);
        Intent intent = getIntent();
        searchText = intent.getStringExtra("film_id");
       //TODO Da eliminare questa è quella di lost con recensioni
        searchText = "tt0411008";
        AsyncCallWS task = new AsyncCallWS();
        try {
            filmDetail = task.execute(searchText).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        imageView=findViewById(R.id.filmImage);
        Picasso.with(FilmDetailActivity.this)
                .load(filmDetail.getImageLink())
                .into(imageView);

        titleView = findViewById(R.id.filmTitle);
        titleView.setText(filmDetail.getTitle());
        descriptionView = findViewById(R.id.filmDescription);
        descriptionView.setText(filmDetail.descriptionForDetails());
        filmRatings = findViewById(R.id.filmRatings);
        filmRatings.setText(filmDetail.getRatings().toString());

        listView=findViewById(R.id.listViewReviews);
        ReviewAdapter reviewAdapter = new ReviewAdapter(this,R.layout.review_row,filmDetail.getReviews());
        listView.setAdapter(reviewAdapter);


    }

    private class AsyncCallWS extends AsyncTask<String, Integer, FilmDetail> {
        @Override
        protected FilmDetail doInBackground(String... params) {
            Log.i(TAG, "doInBackground");
            return filmDetail = returnFilmDetail(params[0]);
        }

        @Override
        protected void onPostExecute(FilmDetail result) {
            Log.i(TAG, "onPostExecute");
        }

        @Override
        protected void onPreExecute() {
            Log.i(TAG, "onPreExecute");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.i(TAG, "onProgressUpdate");
        }

    }

    public FilmDetail returnFilmDetail(String message)
    {
        String NAMESPACE = "http://filmdetails.sose.disim.univaq.it/";
        String METHOD_NAME = "getFilmDetails";
        String WSDL_URL = "http://10.0.2.2:8080/FilmDetailsProsumer/filmdetails?wsdl";
        String SOAP_ACTION = "";

        try {
            SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME);
            Request.addProperty("arg0", message);
            SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            soapEnvelope.dotNet = false;
            soapEnvelope.setOutputSoapObject(Request);
            HttpTransportSE transport= new HttpTransportSE(WSDL_URL);

            Log.i(TAG, "Invoking the " + METHOD_NAME + "operation");
            Log.i(TAG, "Sending message '" + message + "'");
            transport.call(SOAP_ACTION, soapEnvelope);

            // Soap Object init
            SoapObject filmsDetailsSoap= (SoapObject) soapEnvelope.getResponse();
            // Film Rating init
            RatingData rating = new RatingData( (SoapObject) filmsDetailsSoap.getProperty("ratings"));
            // Film Review List Inizialization
            ArrayList<Review> reviewList = new ArrayList<Review>();
            for(int i = 0; i < filmsDetailsSoap.getPropertyCount(); i++){
                String x = filmsDetailsSoap.getPropertyInfo(i).getName();
               if(x.equals("reviews") ){
                   SoapObject objectFor = (SoapObject) filmsDetailsSoap.getProperty(i);
                   filmID = objectFor.getPropertyAsString("filmID");
                   userID = objectFor.getPropertyAsString("userID");
                   title = objectFor.getPropertyAsString("title");
                   comment = objectFor.getPropertyAsString("comment");
                   Review review = new Review( filmID, userID, title, comment);
                   reviewList.add(review);
               }
            }

            //filmDetail Creation
            filmDetail = new FilmDetail(filmsDetailsSoap,reviewList,rating);


            return filmDetail;
        }
        catch(Exception ex) {
            Log.e(TAG, "Error: " + ex.getMessage());
        }
        return filmDetail;
    }


}
