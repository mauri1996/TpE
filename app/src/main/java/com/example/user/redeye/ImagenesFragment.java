package com.example.user.redeye;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

public class ImagenesFragment extends Fragment {
    private WebView webView2;
    //private TextView text1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v3 =  inflater.inflate(R.layout.fragment_imagenes, container, false);
        if(v3 != null){
            webView2=(WebView) v3.findViewById(R.id.web_2);
            //text1 =(TextView) v3.findViewById(R.id.textView3);
        }
        String strtext1=getArguments().getString("ima");
        //text1.setText(strtext1);
        //Toast.makeText(getActivity(),"entro", Toast.LENGTH_LONG).show();
        webView2.loadUrl(strtext1);

        return v3;
    }



}
