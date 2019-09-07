package com.example.countvolume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OtherActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        Button moveWithData = findViewById(R.id.btn_move_data);

        moveWithData.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_move_data:
                Intent moveWthData = new Intent(OtherActivity.this,MoveWithData.class);
                moveWthData.putExtra(MoveWithData.EXTRA_NAME,"Hasan");
                moveWthData.putExtra(MoveWithData.EXTRA_AGE, 20);
                break;
            case R.id.btn_move_object:
                break;
        }
    }
}
