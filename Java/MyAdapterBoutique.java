package com.example.tuto;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapterBoutique extends RecyclerView.Adapter<MyAdapterBoutique.MyviewHolder> {

    String data1[], data2[];
    int images[];
    Context context;

    public MyAdapterBoutique(Context ct, String[] s1, String[] s2, int[] img){
        context=ct;
        data1 = s1;
        data2 = s2;
        images = img;
    }
    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row1,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, final int position) {
        holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]);
        holder.myImage.setImageResource(images[position]);

        holder.Principal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,InfoItem.class);
                intent.putExtra("data1",data1[position]);
                intent.putExtra("data2",data2[position]);
                intent.putExtra("myImage",images[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {

        TextView myText1, myText2;
        ImageView myImage;
        ConstraintLayout Principal;



        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.programming_language_txt);
            myText2 = itemView.findViewById(R.id.description_txt);
            myImage = itemView.findViewById(R.id.myImageview);
            Principal = itemView.findViewById(R.id.Principal);
        }
    }
}
