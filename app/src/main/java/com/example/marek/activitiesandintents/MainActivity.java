package com.example.marek.activitiesandintents;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //once the activity is created let's assign some code to the Button when it is clicked
        Button msgButton = (Button)findViewById(R.id.a2_button);
        //assign code to the onClickListener by defining
        //an anonymous subclass of OnClickListener and overriding its onClickMethod
        //notice here we are calling new and passing the created OnClickListener to the "setOnClickListener" method instead of storing the reference as a variable
        //while at the same time overriding the onClick method. This is a common pattern seen in Java "in the wild"
        msgButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //in this example we will use the button to send a message
                //let's create an intent
                Intent msg_intent = new Intent("com.seneca.lab2b.Daniel");
                //add some extra information to the intent
                //msg_intent.putExtra(Intent.EXTRA_TEXT, "This is my message blah blah blah");
                //msg_intent.setType("text/plain"); //describes the MIME type of the content
                //fire off the intent
                startActivityForResult(msg_intent, 1);
            }
        });




        Button a3_button = (Button)findViewById(R.id.a3_button);
        a3_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Intent msg_intent = new Intent(v.getContext(),ThirdActivity.class);

                //msg_intent.putExtra(Intent.EXTRA_TEXT, "This is my message blah blah blah");
                //msg_intent.setType("text/plain"); //describes the MIME type of the content

                startActivity(msg_intent);
            }
        });



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String result = "RESULT NOT SET";
        if (requestCode == 1){
            if (resultCode == Activity.RESULT_OK){
                result = data.getStringExtra("message");
            }else if (resultCode == Activity.RESULT_CANCELED){
                result = "user cancelled";
            }
        }else{
            Log.e("Lab2", "SOMETHING WENT WRONG");
        }

        TextView text = (TextView)findViewById(R.id.textView);
        text.setText(result);


    }
}
