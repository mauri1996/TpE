package com.example.user.redeye.CapaDatos;

        import android.content.ContentValues;
        import android.content.Intent;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.example.user.redeye.R;
        import com.example.user.redeye.CapaLogica.muestra;

        import uk.co.senab.photoview.PhotoViewAttacher;

public class Informacion extends AppCompatActivity {

    Button BtnSalir2;
    Button Btncodigo2, btnlugares;
    TextView text;
    ImageView iman;
    PhotoViewAttacher photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);
        BtnSalir2=(Button)findViewById(R.id.Cancelar_btn);
        Btncodigo2=(Button)findViewById(R.id.Registar_c);
        text=(TextView)findViewById(R.id.textView3);
        iman=(ImageView)findViewById(R.id.mapa);
        btnlugares=(Button)findViewById(R.id.lista_Lugares);
        photo=new PhotoViewAttacher(iman);
        BtnSalir2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnlugares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2= new Intent(Informacion.this,muestra.class);
                startActivity(intent2);
            }
        });

        Btncodigo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent codigo_1  = new Intent(Informacion.this,muestra.class);
                try{
                    Bundle bundle2 = getIntent().getExtras();
                    String code = bundle2.getString("Codigo");
                    basedatos basehelper = new basedatos(Informacion.this,"Demo",null,1);
                    SQLiteDatabase db= basehelper.getWritableDatabase();
                    if(comprobar(code)){
                        ContentValues registronuevo= new ContentValues();
                        registronuevo.put("CODIGO",code);
                        db.insert("Codigos",null,registronuevo);
                        db.close();
                        Toast t = Toast.makeText(Informacion.this, "Agregado",
                                Toast.LENGTH_SHORT);
                        t.show();
                    }else {
                        Toast t3 = Toast.makeText(Informacion.this, "El codigo ingresado ya fue registrado",
                                Toast.LENGTH_SHORT);
                        t3.show();
                    }
                }catch (Exception e){
                    Toast t = Toast.makeText(Informacion.this, "Codigo Qr  no Escaneado",
                            Toast.LENGTH_SHORT);
                    t.show();
                }
                startActivity(codigo_1);
            }
        });

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