package com.example.user.redeye.CapaLogica;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.user.redeye.CapaDatos.Informacion;
import com.example.user.redeye.R;

public class MainActivity extends AppCompatActivity {

    Button BtnSig;
    Button BtnMapa;
    Button BtnLugar;
    Button BtnSalir;
    FloatingActionButton bot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad__menu__principal);
        bot = (FloatingActionButton) findViewById(R.id.logo_floating);

        BtnSig=(Button)findViewById(R.id.button1);
        BtnMapa=(Button)findViewById(R.id.button2);
        BtnLugar=(Button)findViewById(R.id.lugares);
        BtnSalir=(Button)findViewById(R.id.button4);

        bot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                final CharSequence[] items = new CharSequence[3];

                items[0] = "Instrucciones";
                items[1] = "Ingresar Codigo";
                items[2] = "Creditos";

                builder.setTitle("Opciones: ")
                        .setItems(items, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which){
                                    case 0:
                                        AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);

                                        LayoutInflater inflater = MainActivity.this.getLayoutInflater();

                                        View v = inflater.inflate(R.layout.intrucciones, null);
                                        Button Btn_acep = (Button) v.findViewById(R.id.bt_instru);
                                        Btn_acep.setOnClickListener(
                                                new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        Intent intent3= new Intent(MainActivity.this,MainActivity.class);
                                                        startActivity(intent3);
                                                    }
                                                }
                                        );

                                        builder1.setView(v);
                                        builder1.show();

                                        break;
                                    case 1:
                                        Intent intent2= new Intent(MainActivity.this,ventacheck.class);
                                        startActivity(intent2);
                                        break;
                                    case 2:
                                        AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);

                                        LayoutInflater inflater1 = MainActivity.this.getLayoutInflater();

                                        View v1 = inflater1.inflate(R.layout.creditos, null);
                                        Button Btn_acep1 = (Button) v1.findViewById(R.id.bt_credi);
                                        Btn_acep1.setOnClickListener(
                                                new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        Intent intent3= new Intent(MainActivity.this,MainActivity.class);
                                                        startActivity(intent3);
                                                    }
                                                }
                                        );

                                        builder2.setView(v1);
                                        builder2.show();
                                        break;
                                }

                            }
                        });
                builder.show();
                /*Intent intent2 = new Intent(MainActivity.this,ventacheck.class);
                startActivity(intent2);*/
            }
        });
        BtnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        BtnLugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,Informacion.class);
                startActivity(intent);
            }
        });
        BtnSig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,SegundaActividad.class);
                startActivity(intent);
            }
        });
        BtnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1= new Intent(MainActivity.this,MapsActivity.class);
                startActivity(intent1);
            }
        });




    }
}
