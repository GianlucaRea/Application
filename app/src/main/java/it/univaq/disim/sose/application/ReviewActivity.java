package it.univaq.disim.sose.application;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ReviewActivity extends Activity {
    private String TAG ="SOAPClient", user_id,film_id,film_title;
    private TextView reviewFilmTitle,reviewTextTitle,reviewTextComment;
    private EditText editTextActor, editTextDialogue, editTextCostume,editTextDirector;
    private Button addReview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_review);
        Intent intent = getIntent();
        user_id = intent.getStringExtra("user_id");
        film_id = intent.getStringExtra("film_id");
        film_title = intent.getStringExtra("film_title");

        reviewFilmTitle = findViewById(R.id.reviewFilmTitle);
        reviewFilmTitle.setText(film_title);
        reviewTextTitle = findViewById(R.id.reviewTitleText);
        reviewTextComment = findViewById(R.id.reviewTitleComment);
        editTextActor = findViewById(R.id.ActorsRating);
        editTextDialogue = findViewById(R.id.DialogueRating);
        editTextCostume = findViewById(R.id.CostumeRating);
        editTextDirector =findViewById(R.id.FilmDirectorRating);
        addReview = findViewById(R.id.addReviewButton);

        editTextActor.setText("0");
        editTextDialogue.setText("0");
        editTextCostume.setText("0");
        editTextDirector.setText("0");
        addReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsyncCallWS task = new AsyncCallWS();
                task.execute();
            }
        });
    }

    private class AsyncCallWS extends AsyncTask<String, Integer, Void> {
        @Override
        protected Void doInBackground(String... params) {
            Log.i(TAG, "doInBackground");
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

}
