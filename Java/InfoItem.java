package com.example.tuto;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InfoItem extends AppCompatActivity {

    ImageView imageView3;
    TextView title, description;

    String data1, data2;
    int myImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_item);

        imageView3 = findViewById(R.id.imageView3);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);

        getData();
        setData();
    }

    private void getData(){
        if(getIntent().hasExtra("myImage") && getIntent().hasExtra("data1") && getIntent().hasExtra("data2")){
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            myImage = getIntent().getIntExtra("myImage",1);
        }
        else{
            Toast.makeText(this,"Pas de Data",Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        title.setText(data1);
        description.setText(data2);
        imageView3.setImageResource(myImage);
    }
}