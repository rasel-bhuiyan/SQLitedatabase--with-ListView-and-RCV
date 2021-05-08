package com.example.sqlwithrcv2;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText name, phone, email;
    Button save;
    RecyclerView recyclerView;
    ListView listView;

    DBsource dBsource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.Name);
        phone = findViewById(R.id.Phone);
        email = findViewById(R.id.Email);
        save = findViewById(R.id.save);
        listView = findViewById(R.id.listview);
        recyclerView = findViewById(R.id.recv);



         dBsource = new DBsource(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                ModelClass modelClass = new ModelClass(name.getText().toString(), phone.getText().toString(), email.getText().toString());

                if (modelClass == null) {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                } else {
                    boolean statas = dBsource.AddInfo(modelClass);
                    if (statas) {

                        Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                    }
                }

                onStart();

            }
        });




    }


    @Override
    protected void onStart() {
        super.onStart();

        ArrayList<ModelClass> arrayList = dBsource.showDATA();

                final ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, arrayList);
                listView.setAdapter(arrayAdapter);

                CustomRCV customRCV = new CustomRCV(MainActivity.this,arrayList);

                StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(staggeredGridLayoutManager);

                recyclerView.setAdapter(customRCV);



    }
}