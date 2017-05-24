package com.example.user.redeye.CapaLogica;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Vuforia extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LaunchComponent ("asd.Dmc.Red_Eye1");
    }
    public void  LaunchComponent (String packageName){
        try{
            Intent i = new Intent(Intent.ACTION_MAIN);
            PackageManager manager = getPackageManager();
            i = manager.getLaunchIntentForPackage(packageName);
            i.addCategory(Intent.CATEGORY_LAUNCHER);
            startActivity(i);
            finish();
        }catch (Exception e){
            Toast t = Toast.makeText(Vuforia.this, " ERROR.!! =( Instalar Red Eye ",
                    Toast.LENGTH_SHORT);
            t.show();
        }
    }
}
