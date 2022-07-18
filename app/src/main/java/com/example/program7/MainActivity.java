package com.example.program7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,add,call,del;
        EditText editTextt;
        float mv,mvt;
        b0=(Button)findViewById(R.id.dial0);
        b1=(Button)findViewById(R.id.dial1);
        b2=(Button)findViewById(R.id.dial2);
        b3=(Button)findViewById(R.id.dial3);
        b4=(Button)findViewById(R.id.dial4);
        b5=(Button)findViewById(R.id.dial5);
        b6=(Button)findViewById(R.id.dial6);
        b7=(Button)findViewById(R.id.dial7);
        b8=(Button)findViewById(R.id.dial8);
        b9=(Button)findViewById(R.id.dial9);
        add=(Button)findViewById(R.id.Add);
        call=(Button)findViewById(R.id.Call);
        del=(Button)findViewById(R.id.dialdel);
        editTextt= (EditText) findViewById(R.id.editText);

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextt.setText(editTextt.getText()+"0");
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextt.setText(editTextt.getText()+"1");
            }
        });b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextt.setText(editTextt.getText()+"2");
            }
        });b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextt.setText(editTextt.getText()+"3");
            }
        });b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextt.setText(editTextt.getText()+"4");
            }
        });b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextt.setText(editTextt.getText()+"5");
            }
        });b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextt.setText(editTextt.getText()+"6");
            }
        });b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextt.setText(editTextt.getText()+"7");
            }
        });b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextt.setText(editTextt.getText()+"8");
            }
        });b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextt.setText(editTextt.getText()+"9");
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textInBox = editTextt.getText().toString();
                if(textInBox.length() > 0){
                    String newText = textInBox.substring(0,textInBox.length()-1);
                    editTextt.setText(newText);
                }
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
                intent.putExtra(ContactsContract.Intents.Insert.PHONE,editTextt.getText());
                startActivity(intent);
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int REQUEST_PHONE_CALL = 1;
                if(android.os.Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                    if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
                    }
                    else{
                        String number = editTextt.getText().toString();
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:"+ number));
                        startActivity(callIntent);
                    }
                }
            }
        });


    }
}