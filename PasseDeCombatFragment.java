package com.example.tuto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

public class PasseDeCombatFragment extends Fragment {
    ListView ls;
    String[] num = {"1","2","3","4","5","6","7","8","9"};
    Integer[] normal = {R.drawable.bourse, R.drawable.bourse, R.drawable.bourse, R.drawable.bourse, R.drawable.bourse, R.drawable.bourse, R.drawable.bourse, R.drawable.bourse, R.drawable.bourse};
    Integer[] premium = {R.drawable.chaussonpatte_ours, R.drawable.bourse, R.drawable.masque_crocodile, R.drawable.cartecadeau, R.drawable.alien_masque, R.drawable.cartecadeau, R.drawable.bourse, R.drawable.cartecadeau, R.drawable.velo};

   /* @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passe_de_combat);
    }*/

    public PasseDeCombatFragment(){}


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_passe_de_combat, container, false);

        ListView ls;
        String[] num = {"1","2","3","4","5","2","3","4","5"};
        Integer[] normal = {R.drawable.abs, R.drawable.parametres_blue, R.drawable.jean, R.drawable.cadenas, R.drawable.basket, R.drawable.parametres_blue, R.drawable.jean, R.drawable.cadenas, R.drawable.basket};
        Integer[] premium = {R.drawable.chaussonpatte_ours, R.drawable.costume_clown, R.drawable.masque_crocodile, R.drawable.casquette_jaune, R.drawable.alien_masque, R.drawable.costume_clown, R.drawable.masque_crocodile, R.drawable.casquette_jaune, R.drawable.alien_masque};

        ls = (ListView) v.findViewById(R.id.list_pass);
        InfoPasseDeCombat infoPasseDeCombat = new InfoPasseDeCombat(getActivity(), this.num, this.normal, this.premium);
        ls.setAdapter(infoPasseDeCombat);

        return v;
    }
}
/*setContentView(R.layout.activity_passe_de_combat);
        ls = (ListView) findViewById(R.id.list_pass);
        InfoPasseDeCombat infoPasseDeCombat = new InfoPasseDeCombat(this, this.num, this.normal, this.premium);
        ls.setAdapter(infoPasseDeCombat);*/