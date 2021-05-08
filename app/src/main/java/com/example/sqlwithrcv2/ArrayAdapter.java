package com.example.sqlwithrcv2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ArrayAdapter extends android.widget.ArrayAdapter<ModelClass> {
    Context context;
    ArrayList<ModelClass> arrayList;

    public ArrayAdapter(@NonNull Context context,  ArrayList<ModelClass> arrayList) {
        super(context, R.layout.row ,arrayList);

        this.context =context;
        this.arrayList  =arrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.row,parent,false);


        TextView name = view.findViewById(R.id.Rname);
        TextView phone = view.findViewById(R.id.Rphone);
        TextView email = view.findViewById(R.id.Remail);

        name.setText(arrayList.get(position).Name);
        phone.setText(arrayList.get(position).Number);
        email.setText(arrayList.get(position).Email);


        return view;
    }
}
