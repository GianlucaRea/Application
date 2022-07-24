package it.univaq.disim.sose.application;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import it.univaq.disim.sose.application.adapters.ResultAdapter;
import it.univaq.disim.sose.application.models.Result;


public class FilmSearchActivity extends Activity {
    private String TAG ="SOAPClient";
    private ListView listView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filmsearch);
        Intent intent = getIntent();
        ArrayList<Result> resultList = (ArrayList<Result>) intent.getSerializableExtra("key");


        listView=findViewById(R.id.listViewSearch);

        ResultAdapter resultAdapter = new ResultAdapter(this,R.layout.single_row,resultList);
        listView.setAdapter(resultAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(FilmSearchActivity.this, FilmDetailActivity.class);
                intent.putExtra("film_id", resultList.get(position).getId());
                startActivity(intent);
            }
        });
    }
}
