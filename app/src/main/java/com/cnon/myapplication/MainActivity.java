package com.cnon.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        sharedPreferences = this.getSharedPreferences("com.cnon.myapplication", Context.MODE_PRIVATE);

        String storedAge = sharedPreferences.getString("age","");
        if(!storedAge.equals("")) textView.setText(storedAge);

    }

    public void button(View view)
    {
        String text =  editText.getText().toString();
       sharedPreferences.edit().putString("age",text).apply();
        textView.setText(editText.getText().toString());
        //Log.e("Output:",editText.getText().toString());
    }


    public void delete(View view)
    {
        String storedAge = sharedPreferences.getString("age","");
        if(!storedAge.equals("")) sharedPreferences.edit().remove("age").apply();

    }

}