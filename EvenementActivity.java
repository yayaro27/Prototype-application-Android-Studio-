package com.example.tuto;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class EvenementActivity extends AppCompatActivity {
    private ImageButton ButtonMenu;
    private ImageButton ButtonParametre;
    private ImageButton ButtonChall;
    private ImageButton mbouton;
    private ImageButton Buttonpass;
    private View decorView;
    RecyclerView recyclerView;
    String s1[], s2[],s3[],s4[];
    int images[] = {R.drawable.pasidee,R.drawable.paris,R.drawable.pasidee,R.drawable.paris};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evenement);

        this.ButtonChall = (ImageButton) findViewById(R.id.Chall);
        ButtonChall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), ChallengeActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });
        this.ButtonMenu = (ImageButton) findViewById(R.id.Menu);

        ButtonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), MainActivity.class);
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
        this.mbouton = (ImageButton) findViewById(R.id.shopbis);
        mbouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), Boutique.class);
                startActivity(otherActivity);
                finish();
            }
        });


        this.ButtonParametre = (ImageButton) findViewById(R.id.parametre);
        ButtonParametre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), Preferences.class);
                startActivity(otherActivity);
                finish();
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        s1 =  getResources().getStringArray(R.array.imageList);
        s2 =  getResources().getStringArray(R.array.Description);
        s3 =  getResources().getStringArray(R.array.petiteDescription);
        s4 =  getResources().getStringArray(R.array.disponible);

        MyAdapterEvenement myAdapter = new MyAdapterEvenement(this,s1,s2,s3,s4,images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if(visibility == 0)
                    decorView.setSystemUiVisibility(hideSystemBars());
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent otherActivity = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(otherActivity);
        finish();

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