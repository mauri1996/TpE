package com.example.user.redeye.CapaLogica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.redeye.R;

public class SegundaActividad extends AppCompatActivity {
    Button BtnVover;
    Button BtnCaptureCode;
    Button Btnvuforia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);
        BtnVover=(Button)findViewById(R.id.button3);
        BtnCaptureCode=(Button)findViewById(R.id.btnCaptureCode);
        BtnCaptureCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(SegundaActividad.this,SimpleScannerActivity.class);
                startActivity(intent2);
            }
        });
        Btnvuforia=(Button)findViewById(R.id.btnVuforia);

        BtnVover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Btnvuforia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent acti  = new Intent(SegundaActividad.this,Vuforia.class);
                startActivity(acti);
            }
        });
    }

}
