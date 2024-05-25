package com.jis.fitlife.activity;

import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.jis.fitlife.R;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    EditText editTextMail,editTextName,editTextPassword;
    Button btnSave;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        editTextMail = findViewById(R.id.editTextMail);
        editTextName = findViewById(R.id.editText);
        editTextPassword = findViewById(R.id.editText2);
        btnSave = findViewById(R.id.button);

        performClick ();

    }

    private void performClick() {

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextMail.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(),
                            "Enter email",Toast.LENGTH_SHORT).show();
                } else if (editTextName.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(),
                            "Enter name",Toast.LENGTH_SHORT).show();
                }
                else if (editTextPassword.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(),
                            "Enter password",Toast.LENGTH_SHORT).show();
                }else {
                    String email = editTextMail.getText().toString().trim();
                    String name = editTextName.getText().toString().trim();
                    String password = editTextPassword.getText().toString().trim();

                    getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                            .putString("USER_EMAIL", email).commit();
                    getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                            .putString("USER_NAME", name).commit();
                    getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                            .putString("USER_PASSWORD", password).commit();

                    Intent myIntent = new Intent(LoginActivity.this, EnterInfoActivity.class);
                    startActivity(myIntent);
                }

            }
        });
    }

}

