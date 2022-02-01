package com.example.tuto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class FocusChallenge extends AppCompatActivity {


    private ImageButton mbouton;
    private View decorView;
    ImageView mainImageView;
    TextView title,description;
    private ImageButton ButtonMenu;
    private ImageButton ButtonChall;
    private ImageButton Buttonpass;
    String data1,data2,data3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus_chall);
        mainImageView = findViewById(R.id.mainImageView);
        title = findViewById(R.id.title);
        this.ButtonMenu = (ImageButton) findViewById(R.id.Menu);

        ButtonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });
        this.mbouton = (ImageButton) findViewById(R.id.shopbis);
        mbouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), Boutique.class);
                startActivity(otherActivity);
                finish();
            }
        });
        this.Buttonpass = (ImageButton) findViewById(R.id.passe_de_combat);
        Buttonpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), PasseDeCombatActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });
        this.ButtonChall = (ImageButton) findViewById(R.id.Chall);
        ButtonChall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), ChallengeActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });

        description = findViewById(R.id.description);
        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if(visibility == 0)
                    decorView.setSystemUiVisibility(hideSystemBars());
            }
        });
        getData();
        setData();

    }

    private void getData(){
        if( getIntent().hasExtra("data1") && getIntent().hasExtra("data2") && getIntent().hasExtra("data3") ){
            data1 =  getIntent().getStringExtra("data1");
            data2 =  getIntent().getStringExtra("data2");
            data3 =  getIntent().getStringExtra("data3");

        }else{
            Toast.makeText(this,"No Data.", Toast.LENGTH_SHORT).show();
        }
    }


    private void setData(){
        title.setText(data1);
        description.setText(data2);
        Glide.with(getApplicationContext())
                .load(data3)
                .into(mainImageView);
    }
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            decorView.setSystemUiVisibility(hideSystemBars());
        }
    }

    private int hideSystemBars(){
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
    }
}