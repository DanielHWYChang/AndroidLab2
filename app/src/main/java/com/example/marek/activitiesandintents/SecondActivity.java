package com.example.marek.activitiesandintents;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



        Button ok_button = (Button)findViewById(R.id.ok_button);
        ok_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent replyIntent = new Intent();
                EditText editText = (EditText) findViewById(R.id.userMessage);
                String messageBoxMessage = editText.getText().toString();
                replyIntent.putExtra("message", messageBoxMessage);
                setResult(Activity.RESULT_OK,replyIntent);
                finish();
            }
        });
    }
}
