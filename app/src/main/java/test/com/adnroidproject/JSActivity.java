package test.com.adnroidproject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class JSActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js);
        WebView webView= (WebView) findViewById(R.id.myWebView);
        WebSettings wSet = webView.getSettings();
        wSet.setJavaScriptEnabled(true);
        wSet.setCacheMode(WebSettings.LOAD_DEFAULT);
        wSet.setDomStorageEnabled(true);
        wSet.setBuiltInZoomControls(true);
        wSet.setSupportZoom(true);
        webView.loadUrl("file:///android_asset/spage71/spage71.html");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl("file:///android_asset/spage71/spage71.html");


                return true;
            }
        });
        webView.addJavascriptInterface(this, "android");
    }
    @JavascriptInterface
    public void startFunction(final String text) {
        Thread thread=new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                if (null != text)              {
                    Log.e("aaaaa",text);

                }
            }
        });
        thread.start();

    }
}
