package com.example.user.redeye;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;


public class InformationFragment extends Fragment implements View.OnClickListener{
    private WebView webView1;
    private Button btn_cod;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_information, container, false);
        if (v != null) {
            webView1 = (WebView) v.findViewById(R.id.web_1);
            btn_cod = (Button) v.findViewById(R.id.btn_cod);
        }
        String strtext = getArguments().getString("info");

        webView1.loadUrl(strtext);
        btn_cod.setOnClickListener(this);
        return v;
    }


    @Override

    public void onClick(View v) {
        Intent intent = new Intent(getActivity(),Informacion.class);
        String strtext1 = getArguments().getString("code_1");
        intent.putExtra("Codigo",strtext1);
        startActivity(intent);
    }

}
