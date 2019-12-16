package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etstName,etUserName, etPassword;
    Button btnLogIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUserName = findViewById(R.id.UserName);
        etPassword = findViewById(R.id.password);

        btnLogIn = findViewById(R.id.login);

        btnLogIn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String user = etUserName.getText().toString();
        String pass = etPassword.getText().toString();
        if (user.equals("user1") && pass.equals("password1")  ) {

            Intent act = new Intent(getApplicationContext(), Main2Activity.class);
            startActivity(act);
        } else
            Toast.makeText(getApplicationContext(), "Invalid user name or password or Enter student name", Toast.LENGTH_LONG).show();
    }

}
