package duzones.creativednas.com.duzones;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.app.AppCompatActivity;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


public class grade_card2 extends AppCompatActivity {
    SwipeRefreshLayout swipe;
    WebView webView;
    String e;

    class MyWebViewClient extends WebViewClient {
        MyWebViewClient() {
        }

        public void onPageFinished(WebView webView, String url) {
            super.onPageFinished(webView, url);
            invalidateOptionsMenu();
            swipe.setRefreshing(false);
        }

        public void onPageStarted(WebView webView, String url, Bitmap bitmap) {
            super.onPageStarted(webView, url, bitmap);
            grade_card2.this.invalidateOptionsMenu();
        }


        public boolean shouldOverrideUrlLoading(WebView webView, String url) {
            webView.loadUrl(url);
            return true;
        }
    }

    public void onBackPressed() {
        if (this.webView.canGoBack()) {
            this.webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_grade_card);
     e=getIntent().getExtras().getString("link_to_pass");
        Toast.makeText(this, e, Toast.LENGTH_LONG).show();

        swipe = (SwipeRefreshLayout) findViewById(R.id.swipegrades);
        swipe.setOnRefreshListener(new OnRefreshListener() {
            public void onRefresh() {
                webAction(e);
            }
        });
        webAction(e);
    }

    public void webAction(String e) {
        this.webView = (WebView) findViewById(R.id.webviewgrades);
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.getSettings().setAllowFileAccess(false);
        this.webView.getSettings().setAllowFileAccessFromFileURLs(false);
        this.webView.loadUrl(e);
        this.swipe.setRefreshing(true);
        this.webView.getSettings().setSupportZoom(true);
        this.webView.getSettings().setBuiltInZoomControls(true);
        this.webView.getSettings().setDisplayZoomControls(true);
        this.webView.setHorizontalScrollBarEnabled(false);
        this.webView.setWebViewClient(new MyWebViewClient());
        webView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                Uri uri=Uri.parse(url);
                Intent i =new Intent(Intent.ACTION_VIEW,uri);
                startActivity(i);
            }
        });
    }
}
