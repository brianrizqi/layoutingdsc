package com.example.brianr.loginandregister;

import android.app.IntentService;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    private EditText emailEditText, usernameEditText, passwordEditText;
    private Button regis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        emailEditText = (EditText) findViewById(R.id.emailRegis);
        usernameEditText = (EditText) findViewById(R.id.userRegis);
        passwordEditText = (EditText) findViewById(R.id.passRegis);
        regis = (Button) findViewById(R.id.btnRegis);
        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                // Check
                if (email.equals("") || username.equals("") || password.equals("")) {
                    Toast.makeText(Register.this, "Silahkan Isi Semua Kolom!", Toast.LENGTH_SHORT).show();
                } else {
                    User user = new User(email, username, password);
                    Intent intent = new Intent();
                    intent.putExtra("new_user", user);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}
