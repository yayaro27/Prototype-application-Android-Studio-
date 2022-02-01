package com.example.tuto;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Blog extends AppCompatActivity {
    EditText message;
    Button envoyer;
    ProgressDialog dialog;
    private ImageButton ButtonParametre;
    private ImageButton ButtonChall;
    private ImageButton ButtonMenu;
    private ImageButton mbouton;
    private ImageButton Buttonpass;
    private View decorView;
    ListView ls;
    JSONParser parser = new JSONParser();
    ArrayList<HashMap<String,String>> values= new ArrayList<HashMap<String,String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tchat);
        message=findViewById(R.id.message);
        envoyer=findViewById(R.id.envoyer);
        ls = findViewById(R.id.list);




        envoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Add().execute();
                values= new ArrayList<HashMap<String,String>>();
                new All().execute();


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
        this.mbouton = (ImageButton) findViewById(R.id.shop);
        mbouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), Boutique.class);
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
        this.ButtonMenu = (ImageButton) findViewById(R.id.logo);
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

    class Add extends AsyncTask<String, String, String>{

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            dialog=new ProgressDialog(Blog.this);
            dialog.setMessage("Message en cours d'envoi");
            dialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {

            HashMap<String,String> map= new HashMap<String,String>();
            map.put("message",message.getText().toString());
            JSONObject object=parser.makeHttpRequest("http://192.168.0.17/challengeMCA/traitement2.php","GET", map);
            return null;
        }




        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            dialog.cancel();
            Toast.makeText(Blog.this,"Message envoyé",Toast.LENGTH_LONG).show();

        }
    }

    class All extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {


            HashMap<String,String> map2= new HashMap<String,String>();
            map2.put("recupmessage", "true");
            JSONObject object2=parser.makeHttpRequest("http://192.168.0.17/challengeMCA/traitement2.php","GET", map2);

            try {
                JSONArray users= object2.getJSONArray("message");
                for (int i=0;i<users.length();i++){
                    JSONObject user=users.getJSONObject(i);
                    HashMap<String,String> m=new HashMap<String,String>();
                    m.put("message",user.getString("message"));

                    values.add(m);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            SimpleAdapter adapter =new SimpleAdapter(Blog.this,values, R.layout.messages,new String[]{"message"},new int[]{R.id.TexteMessage});
            ls.setAdapter(adapter);

        }

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
