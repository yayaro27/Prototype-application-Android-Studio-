package com.example.tuto;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class InfoPasseDeCombat extends ArrayAdapter<String> {
    private String[] num;
    private Integer[] normal;
    private Integer[] premium;
    private Activity context;
    public InfoPasseDeCombat(Activity context, String[] num, Integer[] normal, Integer[] premium) {
        super(context, R.layout.item_passe_combat, num);

        this.context = context;
        this.num = num;
        this.normal = normal;
        this.premium = premium;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        ViewHolder viewHolder = null;
        if(r==null){
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r= layoutInflater.inflate(R.layout.item_passe_combat, null, true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else{
            viewHolder= (ViewHolder) r.getTag();

        }
        viewHolder.imgN.setImageResource(normal[position]);
        viewHolder.imgP.setImageResource(premium[position]);
        viewHolder.numT.setText(num[position]);

        return r;




    }
    static class ViewHolder{
        ImageView imgN;
        ImageView imgP;
        TextView numT;
        public ViewHolder(View v){
            imgN=v.findViewById(R.id.imageViewFree);
            imgP=v.findViewById(R.id.imageViewPremium);
            numT = v.findViewById(R.id.numPasse);
        }
    }
}
