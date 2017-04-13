package com.example.pierre.tp_antoine.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pierre.tp_antoine.R;

import model.User;
import utils.UserLocationListener;

public class LoginActivity extends AppCompatActivity {

    public static final String LOGIN_KEY = "LOGIN_KEY";
    public static final String PASSWORD_KEY = "PASSWORD_KEY";

    private EditText login;
    private EditText password;
    private Button btnLogin;
    private Button btnRegister;
    private CheckBox cbRemember;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        prefs  = PreferenceManager.getDefaultSharedPreferences(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (EditText) findViewById(R.id.etLogin);
        password = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        cbRemember = (CheckBox) findViewById(R.id.cbRememberMe);

        if(prefs.contains(LOGIN_KEY) && prefs.contains(PASSWORD_KEY)){
            login.setText(prefs.getString(LOGIN_KEY, ""));
            password.setText(prefs.getString(PASSWORD_KEY, ""));
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(login.getText().toString().equals("plems") && password.getText().toString().equals("yolo")) {

                    User currentUser = new User("plems", "yolo", "plems", "yolo", null, null);
                    UserLocationListener.getInstance().setMyLocationListener(LoginActivity.this, currentUser);

                   if(cbRemember.isChecked()) {
                       prefs.edit()
                               .putString(LOGIN_KEY, login.getText().toString())
                               .apply();
                       prefs.edit()
                               .putString(PASSWORD_KEY, password.getText().toString())
                               .apply();
                   }

                    startActivity(new Intent(LoginActivity.this, EventsActivity.class));
                }

            }
        });


        btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                    User currentUser = new User("plems", "yolo", "plems", "yolo", null, null);
                    UserLocationListener.getInstance().setMyLocationListener(LoginActivity.this, currentUser);

                Toast.makeText(LoginActivity.this, currentUser.getLat().toString() + "," +  currentUser.getLng().toString(), Toast.LENGTH_LONG).show();

            }
        });

    }
}
