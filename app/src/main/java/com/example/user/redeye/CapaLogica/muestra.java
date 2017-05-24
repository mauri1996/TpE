package com.example.user.redeye.CapaLogica;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.redeye.CapaDatos.basedatos;
import com.example.user.redeye.R;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class muestra extends AppCompatActivity {
    ListView list;
    ArrayList<String> listado;
    Button Btnmenu_vol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra);
        list = (ListView) findViewById(R.id.lista_1);
        Btnmenu_vol = (Button) findViewById(R.id.btn_vol_list);
        CargarListado();

        Btnmenu_vol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vol = new Intent(muestra.this, MainActivity.class);
                startActivity(vol);
            }
        });
    }

    private void CargarListado() {
        listado = ListaCodigo();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listado);
        list.setAdapter(adapter);
    }

    private ArrayList<String> ListaCodigo() {
        int cont = 0;
        ArrayList<String> datos = new ArrayList<String>();
        basedatos basehelper = new basedatos(this, "Demo", null, 1);
        SQLiteDatabase db = basehelper.getReadableDatabase();
        String sql = "select ID, CODIGO from Codigos";
        Cursor c = db.rawQuery(sql, null);
        if (c.moveToFirst()) {
            do {
                String linea = c.getString(1);
                if ("CDC_2".equals(linea)) {
                    linea = "La Iglesia del Sagrario";
                    ++cont;
                }
                if ("PCC_1".equals(linea)) {
                    linea = "Parque Calderon";
                    ++cont;
                }
                if ("MPC_1".equals(linea)) {
                    linea = "Museo Pumapungo";
                    ++cont;
                }
                if ("RTC_1".equals(linea)) {
                    linea = "Rio Tomebamba";
                    ++cont;
                }
                if ("MRC_2".equals(linea)) {
                    linea = "Museo Remigio Crespo";
                    ++cont;
                }
                if ("ISS_1".equals(linea)) {
                    linea = "Iglesia de San Sebastian";
                    ++cont;
                }
                if ("OUC_1".equals(linea)) {
                    linea = "Orquideario";
                    ++cont;
                }
                if ("EC_1".equals(linea)) {
                    linea = "Escalinatas";
                    ++cont;
                }
                if ("CDC_1".equals(linea)) {
                    linea = "Catedral de la Inmaculada Concepcion";
                    ++cont;
                }
                if ("MTC_1".equals(linea)) {
                    linea = "Mirador de Turi";
                    ++cont;
                }
                datos.add(linea);
            } while (c.moveToNext());

        }
        if (cont == 10) {
            Bitmap bm = BitmapFactory.decodeResource( getResources(), R.drawable.marcadoregalo1);
            Bitmap bm2=BitmapFactory.decodeResource(getResources(),R.drawable.marcadorregalo2);
            File folder = new File(Environment.getExternalStorageDirectory() + "/Eye_City_Aplication");

            boolean success = true;
            if (!folder.exists()) {
                success = folder.mkdir();
            }
            if (success) {
                String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
                extStorageDirectory= extStorageDirectory+"/Eye_City_Aplication";
                try {
                    File file = new File(extStorageDirectory, "Regalo1.PNG");

                    FileOutputStream outStream = new FileOutputStream(file);
                    bm.compress(Bitmap.CompressFormat.PNG, 100, outStream);
                    outStream.flush();
                    outStream.close();
                }catch (Exception e){
                    Toast.makeText(this, "no guardada", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
                try {
                    File file = new File(extStorageDirectory, "Regalo2.PNG");
                    FileOutputStream outStream = new FileOutputStream(file);
                    bm2.compress(Bitmap.CompressFormat.PNG, 100, outStream);
                    outStream.flush();
                    outStream.close();
                    Toast.makeText(this, "Recompenzas Otorgadas", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(this, "No guardada", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(muestra.this, "Failed - Error", Toast.LENGTH_SHORT).show();
            }

        }
        db.close();
        return datos;
    }

}
