package com.example.countvolume;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MoveWithData extends AppCompatActivity {

    public static final String EXTRA_NAME = "ex_nama";
    public static final String EXTRA_AGE = "ex_umur";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_data);

        TextView tvDataRecieved = findViewById(R.id.tv_data_rec);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        int age = getIntent().getIntExtra(EXTRA_AGE, 0);

        String text = "Nama : " + name + ", Umur : " + age + " tahun";
        tvDataRecieved.setText(text);
    }
}
