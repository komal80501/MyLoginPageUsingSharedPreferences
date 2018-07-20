package com.example.lenovo.myloginpageusingsharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context context;
    SharedPreferences sharedPreferences;
    EditText txuserName;
    EditText txpassword;
    public static final String mypreference="mypref";
    public static final String UserName="unameKey";
    public static final String Password="passKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialising Shared Preferences
        sharedPreferences =getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        //storing data 1st need to an editor object to make changes
        SharedPreferences.Editor edit=sharedPreferences.edit();
        edit.putString("UserName","komal");
        edit.putBoolean("logged_in",false);
        edit.putString("Password","123");
        edit.putBoolean("logged_in1",false);

        edit.commit();//either this we can use apply();
    }

    public void login(View view) {
        //Reading data and check condition
        String UserName=sharedPreferences.getString("UserName",null);
        String Password=sharedPreferences.getString("Password",null);

        Boolean logged_in= Boolean.valueOf(String.valueOf(sharedPreferences.getBoolean("logged_in",false)));
        Boolean logged_in1= Boolean.valueOf(String.valueOf(sharedPreferences.getBoolean("logged_in1",false)));


        txuserName=(EditText) findViewById(R.id.txtuserName);
        txpassword=(EditText) findViewById(R.id.txtpassword);

        String uname=txuserName.getText().toString();
        String pass=txpassword.getText().toString();

        if(UserName.equals(uname) && Password.equals(pass))
        {
            Toast.makeText(this,"Login Succefully",Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(this,"ivalid pass or username",Toast.LENGTH_LONG).show();


        }


    }

    public void clear(View view) {
        txuserName=(EditText) findViewById(R.id.txtuserName);
        txpassword=(EditText) findViewById(R.id.txtpassword);
        txuserName.setText("");
        txpassword.setText("");
    }
}
