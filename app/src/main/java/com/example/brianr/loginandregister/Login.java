package com.example.brianr.loginandregister;

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
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    private EditText usernameEditText, passwordEditText;
    private Button loginBtn, regisBtn;
    private ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Init
        users = new ArrayList<User>();
        usernameEditText = (EditText) findViewById(R.id.userLogin);
        passwordEditText = (EditText) findViewById(R.id.passLogin);
        regisBtn = (Button) findViewById(R.id.buttonRegis);
        loginBtn = (Button) findViewById(R.id.btnLogin);
        // CLick Listener
        regisBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, Register.class);
                startActivityForResult(i, 999);
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                boolean status = false;
                for (int i=0; i<users.size(); i++){
                    User user = users.get(i);
                    if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                        // Masuk ke Dashboard
                        Toast.makeText(Login.this, "Halo Bro", Toast.LENGTH_SHORT).show();
                    }
                }
                // Cek jika tidak ditemukan
                if(status == false){
                    Toast.makeText(Login.this, "Data tidak cocok", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 999 && resultCode == RESULT_OK){
            User user = (User) data.getSerializableExtra("new_user");
            users.add(user);
            // Opsional clear EditText
            usernameEditText.setText("");
            passwordEditText.setText("");
        }
    }
}

