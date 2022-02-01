package com.example.tuto;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ChallengeActivity extends AppCompatActivity {
    private ImageButton ButtonMenu;
    private ImageButton ButtonParametre;
    private ImageButton mbouton;
    private ImageButton Buttonpass;
    RecyclerView recyclerView;
    List<Challenge> chall;
    MyAdapterChall myAdapter;
    private View decorView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aff_challenge);
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
        this.ButtonParametre = (ImageButton) findViewById(R.id.parametre);
        ButtonParametre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), Preferences.class);
                startActivity(otherActivity);
                finish();
            }
        });
        recyclerView=findViewById(R.id.recyclerView);
        chall = new ArrayList<>();
        extractChallenges();

        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if(visibility == 0)
                    decorView.setSystemUiVisibility(hideSystemBars());
            }
        });

    }



        private void extractChallenges() {

            RequestQueue queue = Volley.newRequestQueue(this);
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "*/Lien vers le formulaire php souhaité/*", null,new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject nom = response.getJSONObject(i);
                            Challenge chal = new Challenge();
                            chal.setNom(nom.getString("nom").toString());
                            chal.setDescription(nom.getString("description").toString());
                            chal.setImage(nom.getString("image").toString());
                            chall.add(chal);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    myAdapter = new MyAdapterChall(getApplicationContext(),chall);
                    recyclerView.setAdapter(myAdapter);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    Log.d("tag","onErrorResponse"+ volleyError.getMessage());
                }
            });
            queue.add(jsonArrayRequest);
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
    public void onBackPressed() {
        super.onBackPressed();
        Intent otherActivity = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(otherActivity);
        finish();

    }
}
