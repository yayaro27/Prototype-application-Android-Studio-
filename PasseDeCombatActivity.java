package com.example.tuto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class PasseDeCombatActivity extends AppCompatActivity {

    private View decorView;
    private ImageButton ButtonChall;
    private ImageButton ButtonSettings;
    private ImageButton ButtonShop;
    private ImageButton Buttonpass;
    private ImageButton ButtonMenu;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passe_de_combat);
        replaceFragment(new PasseDeCombatFragment());

        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if(visibility == 0)
                    decorView.setSystemUiVisibility(hideSystemBars());
            }
        });
        this.ButtonSettings = (ImageButton) findViewById(R.id.ButtonSettings);
        ButtonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), Preferences.class);
                startActivity(otherActivity);
            }
        });
        this.ButtonShop = (ImageButton) findViewById(R.id.shop);
        ButtonShop.setOnClickListener(new View.OnClickListener() {
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

        this.ButtonMenu = (ImageButton) findViewById(R.id.ButtonMenu);
        ButtonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });
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

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout_PassCombat,fragment);
        fragmentTransaction.commit();
    }


}