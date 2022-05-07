package com.example.finalproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SearchFragment extends Fragment {

    private WebView webview;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_fragment,container,false);

        webview = (WebView) view.findViewById(R.id.searchfragment_webView);
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        //网址
        webview.loadUrl("https://www.baidu.com");

        //页面设置
        settings.setUseWideViewPort(true);//设定支持viewport
        settings.setLoadWithOverviewMode(true);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);//设定支持缩放

        return view;
    }
}

