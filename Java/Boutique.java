package com.example.tuto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Boutique extends AppCompatActivity {

    private View decorView;
    private ImageButton ButtonMenu;
    Button btnShopP, btnShopG;
    private ImageButton ButtonParametre;
    private ImageButton ButtonChall;
    private ImageButton Buttonpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        this.ButtonMenu = (ImageButton) findViewById(R.id.logo);
        btnShopG = findViewById(R.id.btnShopG);
        btnShopP = findViewById(R.id.btnShopP);
        replaceFragment(new BoutiqueFree());

        btnShopG.setOnClickListener(new View.OnClickListener(){

        @Override
            public void onClick(View v) {
                    replaceFragment(new BoutiqueFree());
            }
        });

        btnShopP.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                replaceFragment(new BoutiquePay());
            }
        });
        this.ButtonParametre = (ImageButton) findViewById(R.id.parametres);
        ButtonParametre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), Preferences.class);
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

        ButtonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });


        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if(visibility == 0)
                    decorView.setSystemUiVisibility(hideSystemBars());
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout,fragment);
        fragmentTransaction.commit();
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