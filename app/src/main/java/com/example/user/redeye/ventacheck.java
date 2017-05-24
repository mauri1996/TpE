package com.example.user.redeye;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import uk.co.senab.photoview.PhotoViewAttacher;

public class ventacheck extends AppCompatActivity {
    TextView text1;
    Button Btnvolver1;
    Button BtnVali;
    EditText text_edit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventacheck);
        text1=(TextView)findViewById(R.id.text);
        Btnvolver1 = (Button) findViewById(R.id.volver_check);
        BtnVali = (Button) findViewById(R.id.recarga);
        text_edit=(EditText) findViewById(R.id.edi_cod);
        Btnvolver1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        BtnVali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Ingresar();
            }
        });


    }
    private void Ingresar(){
        try{
            String codigo_secreto= "Codigo: dakey123";
            String CodeVali=text_edit.getText().toString();
            if (CodeVali.equals(codigo_secreto)){
                Toast.makeText(ventacheck.this, "Codigo Correcto", Toast.LENGTH_SHORT).show();
                ingreso("CDC_2");
                ingreso("PCC_1");
                ingreso("MPC_1");
                ingreso("RTC_1");
                ingreso("MRC_2");
                ingreso("ISS_1");
                ingreso("OUC_1");
                ingreso("EC_1");
                ingreso("CDC_1");
                ingreso("MTC_1");
                Toast.makeText(ventacheck.this, "Codigos ingresados", Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(ventacheck.this, "Error de Codigo", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    private void ingreso(String codigo){
        String code=codigo;
        basedatos basehelper = new basedatos(ventacheck.this,"Demo",null,1);
        SQLiteDatabase db= basehelper.getWritableDatabase();

        try{
            if(comprobar(code)){
                ContentValues registronuevo= new ContentValues();
                registronuevo.put("CODIGO",code);
                db.insert("Codigos",null,registronuevo);
                db.close();
            }
        }catch (Exception e){
            Toast t = Toast.makeText(ventacheck.this, "ERROR =( " +e.getMessage(),
                    Toast.LENGTH_SHORT);
            t.show();
        }



    }
    private boolean comprobar(String text){
        basedatos basehelper = new basedatos(this,"Demo",null,1);
        SQLiteDatabase db= basehelper.getReadableDatabase();
        String sql="select ID, CODIGO from Codigos";
        Cursor c= db.rawQuery(sql,null);
        if(c.moveToFirst()){
            do{
                String linea = c.getString(1);
                if(text.equals(linea)){
                    return false;
                }
            }while (c.moveToNext());
        }
        db.close();
        return true;
    }


}
