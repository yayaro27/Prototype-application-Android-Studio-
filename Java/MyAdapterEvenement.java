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

public class MyAdapterEvenement extends RecyclerView.Adapter<MyAdapterEvenement.MyViewHolder> {


    String data1[], data2[], data3[],data4[];
    int images[];
    Context context;

    public MyAdapterEvenement(Context ct, String s1[], String s2[], String s3[],String s4[], int img[]){
        context = ct;
        data1 = s1;
        data2 = s2;
        data3 = s3;
        data4 = s4;
        images = img;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row2, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.MyText1.setText(data1[position]);
        holder.MyText2.setText(data3[position]);
        holder.MyText3.setText(data4[position]);
        holder.ImageView.setImageResource(images[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FocusEvenement.class);
                intent.putExtra("data1",data1[position]);
                intent.putExtra("data2",data2[position]);
                intent.putExtra("data3",data4[position]);
                intent.putExtra("imageView",images[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView MyText1, MyText2, MyText3;;
        ImageView ImageView;
        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            MyText1 = itemView.findViewById(R.id.nom);
            MyText2 = itemView.findViewById(R.id.description);
            MyText3 = itemView.findViewById(R.id.time);
            ImageView = itemView.findViewById(R.id.Image);
            mainLayout = itemView.findViewById(R.id.mainLayout);

        }
    }
}
