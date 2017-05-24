package com.example.user.redeye;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import me.dm7.barcodescanner.zbar.Result;
import me.dm7.barcodescanner.zbar.ZBarScannerView;


public class SimpleScannerActivity extends Activity implements ZBarScannerView.ResultHandler {

    private ZBarScannerView mScannerView;


    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView = new ZBarScannerView(this);    // Programmatically initialize the scanner view
        setContentView(mScannerView);                // Set the scanner view as the content view
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result result) {
        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setTitle("Escanner");
        //builder.setMessage(result.getContents());
        String codigo= result.getContents();
        String iterador="";
        String vid="";
        String imag="";
        String informat="";
        char opc= '*';
        int cont=0;

        for (String retval: codigo.split(";")) {
            if(cont==0){
                imag=retval;
            }else if(cont==1){
                vid=retval;
            }else if(cont==2){
                informat=retval;
            }else if(cont==3){
                iterador=retval;
            }
            ++cont;
        }
        builder.setMessage("        Clic en informacion para ver detalles");
        AlertDialog alertDialog =builder.create();
        //mScannerView.stopCamera();
        builder.setPositiveButton("Nuevo", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface builder, int id) {
                aceptar();
            }
        });

        final String information = informat;
        final String videos = vid;
        final String imagens = imag;
        final String codigo_qr = iterador;
        //builder.setMessage(" imagenes: "+imagens + "info: "+information + "videos: " + videos+ "Codigo: " + iterador);
        //Toast t=Toast.makeText(this,imagens, Toast.LENGTH_SHORT);

        builder.setNeutralButton("Informacion", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                Intent info  = new Intent(SimpleScannerActivity.this,ActivityFrames.class);
                info.putExtra("imagenes", imagens);
                info.putExtra("informacion", information);
                info.putExtra("videos", videos);
                info.putExtra("codigo1",codigo_qr);
                startActivity(info);
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                cancelar();
            }
        });
        //alertDialog.show();
        builder.show();
    }

    public void aceptar() {
        Toast t=Toast.makeText(this,"Escanner Reactivado", Toast.LENGTH_SHORT);
        t.show();
        mScannerView.resumeCameraPreview(this);
    }
    public void cancelar() {
        finish();
    }

}
