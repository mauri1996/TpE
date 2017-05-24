package com.example.user.redeye.CapaLogica;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.user.redeye.R;

public class VideosFragment extends Fragment {
    WebView webView3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v2 =  inflater.inflate(R.layout.fragment_videos, container, false);
        if(v2 != null){
            webView3=(WebView) v2.findViewById(R.id.web_3);
        }
        String strtext3=getArguments().getString("videos");
        //text.setText(strtext);
        //Toast.makeText(getActivity(),strtext, Toast.LENGTH_LONG).show();
        webView3.loadUrl(strtext3);
        return v2;
    }
}
