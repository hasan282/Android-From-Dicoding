package com.example.countvolume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edLength, edWidth, edHeight;
    private Button btResult, btReset, btMove;
    private TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edLength = findViewById(R.id.edt_length);
        edWidth = findViewById(R.id.edt_width);
        edHeight = findViewById(R.id.edt_height);
        tvRes = findViewById(R.id.tv_result);
        btResult = findViewById(R.id.btn_calculate);
        btReset = findViewById(R.id.btn_reset);
        btMove = findViewById(R.id.btn_move_act);

        btResult.setOnClickListener(this);
        btReset.setOnClickListener(this);
        btMove.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_calculate) {
            String inLength = edLength.getText().toString().trim();
            String inWidth = edWidth.getText().toString().trim();
            String  inHeight = edHeight.getText().toString().trim();

            boolean emptyField = false;
            boolean invalidDouble = false;

            if (TextUtils.isEmpty(inLength)) {
                emptyField = true;
                edLength.setError("Tidak Boleh Kosong");
            }

            if (TextUtils.isEmpty(inWidth)) {
                emptyField = true;
                edWidth.setError("Tidak Boleh Kosong");
            }

            if (TextUtils.isEmpty(inHeight)) {
                emptyField = true;
                edHeight.setError("Tidak Boleh Kosong");
            }

            Double Length = toDouble(inLength);
            Double Width = toDouble(inWidth);
            Double Height = toDouble(inHeight);

            if (Length == null) {
                invalidDouble = true;
                edLength.setError("Harus Berupa Nomer Valid");
            }

            if (Width == null) {
                invalidDouble = true;
                edWidth.setError("Harus Berupa Nomer Valid");
            }

            if (Height == null) {
                invalidDouble = true;
                edHeight.setError("Harus Berupa Nomer Valid");
            }

            if (!emptyField && !invalidDouble) {
                double Volume = Length * Width * Height;
                tvRes.setText(String.valueOf(Volume));
            }
        }
        else if (view.getId() == R.id.btn_reset) {
            edLength.setText(null);
            edWidth.setText(null);
            edHeight.setText(null);
            tvRes.setText("Hasil");
        }
        else if (view.getId() == R.id.btn_move_act) {
            Intent moveIntent = new Intent(MainActivity.this, OtherActivity.class);
            startActivity(moveIntent);
        }
    }

    private Double toDouble(String str) {
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}