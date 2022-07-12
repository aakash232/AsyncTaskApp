package com.example.asynctaskapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView displayTxt, btn_start, btn_stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyAsyncTask task = new MyAsyncTask();
                task.execute();
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Asynchrounous Task stopped", Toast.LENGTH_SHORT).show();
                displayTxt.setSelected(false);
                //displayTxt.setVisibility(View.INVISIBLE);
            }
        });
    }

    private class MyAsyncTask extends AsyncTask<String,String,String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(getBaseContext(), "Asynchrounous Task started", Toast.LENGTH_SHORT).show();
        }


        @Override
        protected String doInBackground(String... strings) {
            try {
                //visible after 10ms
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //null string returned
            return "";
        }

        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);
            displayTxt.setVisibility(View.VISIBLE);
            displayTxt.setSelected(true);
        }

    }

    private void initViews() {
        displayTxt=findViewById(R.id.display_text);
        btn_start=findViewById(R.id.btn_start);
        btn_stop=findViewById(R.id.btn_stop);
    }
}
