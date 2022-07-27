package it.univaq.disim.sose.application;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

public class SignupActivity extends Activity {
    private EditText signupUsername,signupPassword;
    private Button buttonSignup;
    private ImageButton home_signup;
    private String usernameText,passwordText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_signup);
        home_signup = findViewById(R.id.home_signup);
        buttonSignup = findViewById(R.id.buttonSignup);
        signupPassword = findViewById(R.id.signupPassword);
        signupUsername = findViewById(R.id.signupUsername);

        home_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usernameText = signupUsername.getText().toString();
                passwordText = signupPassword.getText().toString();
                RequestParams params = new RequestParams();
                params.add("username",usernameText);
                params.add("password",passwordText);
                //String x = "Login" + "?username="+usernameText+"&password="+passwordText;
                RestClient.post("signup", params, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        Log.i("INFO", new String(responseBody));
                        Intent intent = new Intent(SignupActivity.this , LoginActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Log.e("ERROR","An error has occurred");
                        error.printStackTrace();
                    }
                });
            }
        });

    }
}
