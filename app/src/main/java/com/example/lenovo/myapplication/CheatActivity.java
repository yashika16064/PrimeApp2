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

public class CheatActivity extends AppCompatActivity {
    public final static String key = "com.example.lenovo.myapplication.no_key";
    private TextView CheatTextView;
    public String no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        TextView textView = (TextView) findViewById(R.id.CheatTextView);
        int num = Integer.parseInt(getIntent().getExtras().getString(key));
        int c=Prime(num);
        if(c==0)
         no =num+" is Prime" ;
        else
             no =num+" is not Prime";
        textView.setText(no);
        Intent in = new Intent(this, MainActivity.class);
        setResult(2,in);

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        TextView textView = (TextView) findViewById(R.id.CheatTextView);
        String ps = textView.getText().toString();
        savedInstanceState.putString("textView", ps);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstance) {
        super.onSaveInstanceState(savedInstance);
        TextView textView = (TextView) findViewById(R.id.CheatTextView);
        textView.setText(savedInstance.getString("textView"));
    }




    public int Prime(int num) {
        int c = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                c++;
            }
        }
        if (c != 2) return 1;
        else return 0;
    }

}