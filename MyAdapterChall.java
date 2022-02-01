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

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapterChall extends RecyclerView.Adapter<MyAdapterChall.MyViewHolder> {


    List<Challenge> challenges;
    Context context;

    public MyAdapterChall(Context ct, List<Challenge> challenges){
        context = ct;
        this.challenges = challenges;


    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.MyText1.setText(challenges.get(position).getNom());
        holder.MyText2.setText(challenges.get(position).getDescription());

        Glide.with(context)
                .load(challenges.get(position).getImage())
                .into(holder.imageView1);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FocusChallenge.class);
                intent.putExtra("data1", challenges.get(position).getNom());
                intent.putExtra("data2", challenges.get(position).getDescription());
                intent.putExtra("data3", challenges.get(position).getImage());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return challenges.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView MyText1, MyText2;
        ImageView imageView1;
        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            MyText1 = itemView.findViewById(R.id.nom);
            MyText2 = itemView.findViewById(R.id.description);
            imageView1 = itemView.findViewById(R.id.Image);
            mainLayout = itemView.findViewById(R.id.mainLayout);

        }
    }
}
