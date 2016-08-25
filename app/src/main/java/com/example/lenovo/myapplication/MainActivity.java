package com.example.lenovo.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public int number;
    public TextView textView;
    public Button yesButton;
    public Button noButton;
    public Button nextButton;
    public Button hintbutton;
    public Button cheatbutton;
    public String ps;
    public int count=0 ;


    public final static String key="com.example.lenovo.myapplication.no_key";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.textView);
        if(count==0){
        generate(textView);count++;}

        yesButton = (Button) findViewById(R.id.yesButton);
        yesButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                onYes(textView);
            }
        });

        noButton = (Button) findViewById(R.id.noButton);
        noButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                onNo(textView);
            }
        });

        nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                generate(textView);
            }
        });

        hintbutton = (Button) findViewById(R.id.hintbutton);
        hintbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                onHint(textView);
            }
        });

        cheatbutton = (Button) findViewById(R.id.cheatbutton);
        cheatbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                onCheat(textView);
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("no.", number);
        TextView textView = (TextView) findViewById(R.id.textView);
        ps = textView.getText().toString();
        savedInstanceState.putString("textView", ps);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstance) {
        super.onSaveInstanceState(savedInstance);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(savedInstance.getString("textView"));
        number=savedInstance.getInt("no.");
    }

    public int checkPrime(int num) {
        int c = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                c++;

            }
        }
        if (c != 2) return 1;
        else return 0;
    }

    public void onYes(View view) {
        int j = checkPrime(number);
        if (j == 0)
            Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
    }

    public void onNo(View view) {
        int j = checkPrime(number);
        if (j == 0)
            Toast.makeText(MainActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();

    }
    public void onYesCheat(View view) {
        int j = checkPrime(number);
        if (j == 0)
            Toast.makeText(MainActivity.this, "Correct but you have cheated", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, "Incorrect although you have cheated", Toast.LENGTH_SHORT).show();
    }

    public void onNoCheat(View view) {
        int j = checkPrime(number);
        if (j == 0)
            Toast.makeText(MainActivity.this, "Incorrect although you have cheated", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, "Correct but you have cheated", Toast.LENGTH_SHORT).show();
    }

    public void generate(View view) {
        Random rand = new Random();
        number = rand.nextInt(1000) + 1;
        TextView textView = (TextView) findViewById(R.id.textView);
        String myString = "Is " + String.valueOf(number) + " a prime number??";
        textView.setText(myString);
    }

    public void onHint(View view){
        Intent intent =new Intent(this,HintActivity.class);
        String pass=String.valueOf(number);
        intent.putExtra(key,pass);
        startActivityForResult(intent,1);

    }

    public void onCheat(View view){
        Intent intent =new Intent(this,CheatActivity.class);
        String pass=String.valueOf(number);
        intent.putExtra(key,pass);
        startActivityForResult(intent,2);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==1)
        {
            Toast.makeText(this,"Hint is taken",Toast.LENGTH_SHORT).show();
        }
        if(requestCode==2)
        {
            yesButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    onYesCheat(textView);
                }
            });
            noButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    onNoCheat(textView);
                }
            });
            Toast.makeText(this,"You have cheated",Toast.LENGTH_SHORT).show();

        }

    }
    @Override
    public void onStart() {
        super.onStart();


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://myapplication.lenovo.example.com/main"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.lenovo.myapplication/http/myapplication.lenovo.example.com/main")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://myapplication.lenovo.example.com/main"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.lenovo.myapplication/http/myapplication.lenovo.example.com/main")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}

