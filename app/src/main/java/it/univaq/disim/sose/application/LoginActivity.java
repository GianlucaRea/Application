package it.univaq.disim.sose.application;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;


public class LoginActivity extends Activity {

    private ImageButton home;
    private EditText loginUsername,loginPassword;
    private String TAG,usernameText,passwordText;
    private TextView linkToSignUp;
    private Button buttonLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_login);

        home = findViewById(R.id.home_login);
        loginUsername = findViewById(R.id.loginUsername);
        loginPassword = findViewById(R.id.signupPassword);
        linkToSignUp = findViewById(R.id.linkToSignUp);
        buttonLogin = findViewById(R.id.buttonSignup);

      home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        linkToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usernameText = loginUsername.getText().toString();
                passwordText = loginPassword.getText().toString();
                RequestParams params = new RequestParams();
                params.add("username",usernameText);
                params.add("password",passwordText);
                //String x = "Login" + "?username="+usernameText+"&password="+passwordText;
                RestClient.post("Login", params, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        Log.i("INFO", new String(responseBody));
                        String string = new String(responseBody);
                        String[] parts = string.split("§");
                        String token = parts[0]; // 004
                        String userID = parts[1];
                        Intent intent = new Intent(LoginActivity.this , MainActivity.class);
                        intent.putExtra("userToken",token );
                        intent.putExtra("userID",userID);
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
