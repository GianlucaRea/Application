package it.univaq.disim.sose.application;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import it.univaq.disim.sose.application.models.Result;

public class MainActivity extends Activity {

    private String TAG ="SOAPClient",userToken,userID;
    private List <Result> results = new ArrayList<Result>();
    private EditText editText;
    private Button btnClickHere;
    private ImageButton toLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        userToken = intent.getStringExtra("userToken");
        userID = intent.getStringExtra("userID");

        //Choice Box Implementation
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.type_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Input for search
        editText = (EditText)findViewById(R.id.SearchID);
        btnClickHere = (Button)findViewById(R.id.buttonSearch);
        toLogin = findViewById(R.id.toLogin);

        toLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(userToken == null ){
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    } else {
                        Log.i("LOGIN","Alredy Logged in");
                    }
            }
        });

        btnClickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String spinnerChoice = spinner.getSelectedItem().toString();
                String searchText = editText.getText().toString();
                AsyncCallWS task = new AsyncCallWS();
                task.execute(searchText,spinnerChoice,userToken,userID);
            }
        });
    }

    private class AsyncCallWS extends AsyncTask<String, Integer, Void> {
        @Override
        protected Void doInBackground(String... params) {
            Log.i(TAG, "doInBackground");
            switch (params[1]){
                case "Movies":
                    results = searchFilms(params[0]);
                    openFilmActivity(results,params[2],params[3]);
                    break;
                case "Tv Shows":
                    results = searchSeries(params[0]);
                    openFilmActivity(results,params[2],params[3]);
                    break;
                case "Episodes":
                    results = searchEpisodes(params[0]);
                    openFilmActivity(results,params[2],params[3]);
                case "All":
                default:
                    results = searchAll(params[0]);
                    openFilmActivity(results,params[2],params[3]);
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
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



    public List <Result> searchFilms(String message)
    {
        String NAMESPACE = "http://search.sose.disim.univaq.it/";
        String METHOD_NAME = "searchOnlyFilms";
        String WSDL_URL = "http://10.0.2.2:8080/FilmSearchProsumer/search?wsdl";
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

            Vector<SoapObject> returnResponse= (Vector<SoapObject>) soapEnvelope.getResponse();
            results = cleanResponse(returnResponse);

            return results;
        }
        catch(Exception ex) {
            Log.e(TAG, "Error: " + ex.getMessage());
        }
        return results;
    }

    public List <Result> searchSeries(String message)
    {
        String NAMESPACE = "http://search.sose.disim.univaq.it/";
        String METHOD_NAME = "searchOnlySeries";
        String WSDL_URL = "http://10.0.2.2:8080/FilmSearchProsumer/search?wsdl";
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

            Vector<SoapObject> returnResponse= (Vector<SoapObject>) soapEnvelope.getResponse();
            results = cleanResponse(returnResponse);

            return results;

        }
        catch(Exception ex) {
            Log.e(TAG, "Error: " + ex.getMessage());
        }
        return results;
    }

    public List <Result> searchEpisodes(String message)
    {
        String NAMESPACE = "http://search.sose.disim.univaq.it/";
        String METHOD_NAME = "searchEpisodes";
        String WSDL_URL = "http://10.0.2.2:8080/FilmSearchProsumer/search?wsdl";
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

            Vector<SoapObject> returnResponse= (Vector<SoapObject>) soapEnvelope.getResponse();
            results = cleanResponse(returnResponse);

            return results;

        }
        catch(Exception ex) {
            Log.e(TAG, "Error: " + ex.getMessage());
        }
        return results;
    }

    public List <Result> searchAll(String message)
    {
        String NAMESPACE = "http://search.sose.disim.univaq.it/";
        String METHOD_NAME = "searchFilmsByName";
        String WSDL_URL = "http://10.0.2.2:8080/FilmSearchProsumer/search?wsdl";
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

            Vector<SoapObject> returnResponse= (Vector<SoapObject>) soapEnvelope.getResponse();
            results = cleanResponse(returnResponse);

            return results;
        }
        catch(Exception ex) {
            Log.e(TAG, "Error: " + ex.getMessage());
        }
        return results;
    }

    public void openFilmActivity(List <Result> results,String userToken,String userID){
        Intent intent = new Intent(this, FilmSearchActivity.class);
        intent.putExtra("key", (Serializable) results);
        intent.putExtra("userToken",userToken);
        intent.putExtra("userID",userID);
        startActivity(intent);
    }

    public List<Result> cleanResponse(Vector<SoapObject> soapObjectVector){
        List<Result> results = new ArrayList<Result>();
        for(int i=0; i < soapObjectVector.size(); ++i){
            SoapObject so = soapObjectVector.get(i);
            Result result = new Result(so.getPropertyAsString(1),so.getPropertyAsString(0),so.getPropertyAsString(3),so.getPropertyAsString(2));
            results.add(result);
        }
        return results;
    }
}
