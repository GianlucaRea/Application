package it.univaq.disim.sose.application;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import it.univaq.disim.sose.application.adapters.ResultAdapter;
import it.univaq.disim.sose.application.models.Result;


public class FilmSearchActivity extends Activity {
    private String TAG ="SOAPClient";
    private ListView listView;
    private ImageButton home,toLoginFS;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filmsearch);
        Intent intent = getIntent();
        ArrayList<Result> resultList = (ArrayList<Result>) intent.getSerializableExtra("key");
        String userToken = intent.getStringExtra("userToken");
        String userID= intent.getStringExtra("userID");


        listView=findViewById(R.id.listViewSearch);
        home = findViewById(R.id.home_search);
        toLoginFS = findViewById(R.id.toLoginFS);

        ResultAdapter resultAdapter = new ResultAdapter(this,R.layout.single_row,resultList);
        listView.setAdapter(resultAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(FilmSearchActivity.this, FilmDetailActivity.class);
                intent.putExtra("film_id", resultList.get(position).getId());
                intent.putExtra("userToken",userToken);
                intent.putExtra("userID",userID);
                startActivity(intent);
            }
        });

        toLoginFS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(userToken == null ){
                    Intent intent = new Intent(FilmSearchActivity.this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    Log.i("LOGIN","Alredy Logged in");
                }
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FilmSearchActivity.this, MainActivity.class);
                intent.putExtra("userToken",userToken);
                intent.putExtra("userID",userToken);
                startActivity(intent);
            }
        });
    }
}
