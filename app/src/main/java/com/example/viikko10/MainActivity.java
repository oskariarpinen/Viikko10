package com.example.viikko10;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    WebView webBrowser;
    EditText urlInput;
    ImageButton goForward;
    ImageButton goBack;
    ImageButton refresh;
    ImageButton goURL;
    String newURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        WebView webBrowser = findViewById(R.id.webBrowser);
        webBrowser.getSettings().setJavaScriptEnabled(true);
        webBrowser.canGoBack();
        webBrowser.setWebViewClient(new MyWebViewClient());

        ImageButton refresh = findViewById(R.id.refresh);
        EditText urlInput = findViewById(R.id.urlInput);
        ImageButton goURL = findViewById(R.id.goURL);
        ImageButton goBack = findViewById(R.id.buttonBack);
        ImageButton goForward = findViewById(R.id.buttonForward);


        webBrowser.loadUrl("https://www.google.com");

        goURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newURL = urlInput.getText().toString();
                webBrowser.loadUrl("https://"+newURL);
            }
        });
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webBrowser.reload();
            }
        });

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webBrowser.goBack();
                urlInput.setText(webBrowser.getUrl().toString());
            }
        });

        goForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webBrowser.goForward();
            }
        });
    }
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return false;
        }
    }
}