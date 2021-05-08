package com.example.sqlwithrcv2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomRCV extends RecyclerView.Adapter<CustomRCV.MyHolder> {

    Context context;
    ArrayList<ModelClass> arrayList;

    public CustomRCV(Context context, ArrayList<ModelClass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
      View view =   layoutInflater.inflate(R.layout.single_recv,parent,false);

      MyHolder myHolder = new MyHolder(view);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {




        holder.name.setText(arrayList.get(position).Name);
        holder.phone.setText(arrayList.get(position).Number);
        holder.email.setText(arrayList.get(position).Email);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView name,phone,email;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

             name = itemView.findViewById(R.id.recvName);
             phone = itemView.findViewById(R.id.recvPhone);
             email = itemView.findViewById(R.id.recvEmail);
        }
    }
}
