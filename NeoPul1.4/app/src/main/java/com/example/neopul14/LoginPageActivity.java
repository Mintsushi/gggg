package com.example.neopul14;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by 리제 on 2017-05-24.
 */

public class LoginPageActivity  extends AppCompatActivity {
    String idtemp;
    String pwtemp;
    EditText idEditText;
    EditText pwEditText;

    void AlertDialogMassage(String setmessage, String settitle, String setpositivebutton){
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginPageActivity.this);
        builder.setMessage(setmessage);
        builder.setTitle(settitle)
                .setCancelable(false)
                .setPositiveButton(setpositivebutton, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                    }
                });
        AlertDialog alert = builder.create();
        alert.setTitle(settitle);
        alert.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        idEditText = (EditText) findViewById(R.id.IDinputEditText);
        pwEditText = (EditText) findViewById(R.id.PWinputEditText);

        Button registerButton = (Button)findViewById(R.id.RegisterButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startActivity(new Intent(LoginPageActivity.this, RegisterPageActivity.class));
                finish();
            }

        });

        Button loginButton = (Button)findViewById(R.id.LoginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                idtemp = idEditText.getText().toString();
                pwtemp = pwEditText.getText().toString();
                Log.i("ID : ",idtemp);
                Log.i("pw : ",pwtemp);
                if(idtemp.equals("Riza")) {
                    if (pwtemp.equals("0401")) {
                        startActivity(new Intent(LoginPageActivity.this, MainActivity.class));
                        finish();
                    }
                    else{
                        AlertDialogMassage("PW Error","PW is wrong.","OK");
                    }
                }
                else {
                    AlertDialogMassage("ID Error","ID is wrong.","OK");
                }
            }

        });

    }
}