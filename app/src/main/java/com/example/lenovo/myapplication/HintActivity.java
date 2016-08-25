package com.example.lenovo.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HintActivity extends AppCompatActivity {
    public final static String key="com.example.lenovo.myapplication.no_key";
    private TextView HintTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);

        TextView textView = (TextView) findViewById(R.id.HintTextView);
        String no="If the only factors of "+getIntent().getExtras().getString(key)+" are 1 and itself then it is prime.";
        textView.setText(no);
        Intent in = new Intent(this, MainActivity.class);
        setResult(1,in);

    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        TextView textView = (TextView) findViewById(R.id.HintTextView);
        String ps = textView.getText().toString();
        savedInstanceState.putString("textView", ps);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstance) {
        super.onSaveInstanceState(savedInstance);
        TextView textView = (TextView) findViewById(R.id.HintTextView);
        textView.setText(savedInstance.getString("textView"));
    }



}
