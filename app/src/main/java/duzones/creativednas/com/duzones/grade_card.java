package duzones.creativednas.com.duzones;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.app.AppCompatActivity;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;


public class grade_card extends AppCompatActivity {
    SwipeRefreshLayout swipe;
    WebView webView;
    String result_link;

    AdRequest adRequest;
    private static final String APP_ID = "ca-app-pub-7180287377976427~2306652579";
    private InterstitialAd interstitialAd;
    int zrandom;

    class MyWebViewClient extends WebViewClient {
        MyWebViewClient() {
        }

        public void onPageFinished(WebView webView, String resultss) {
            super.onPageFinished(webView, resultss);
            invalidateOptionsMenu();
            swipe.setRefreshing(false);
        }

        public void onPageStarted(WebView webView, String result_ss, Bitmap bitmap) {
            super.onPageStarted(webView, result_link, bitmap);
            grade_card.this.invalidateOptionsMenu();
        }


        public boolean shouldOverrideUrlLoading(WebView webView, String result_url) {
            webView.loadUrl(result_url);
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

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_grade_card);
        result_link=getIntent().getExtras().getString("link_to_pass");





        swipe = (SwipeRefreshLayout) findViewById(R.id.swipegrades);
        swipe.setOnRefreshListener(new OnRefreshListener() {
            public void onRefresh() {
                webAction();
            }
        });
        webAction();

        MobileAds.initialize(this, APP_ID);

        AdView adview = findViewById(R.id.adView);
        adRequest = new AdRequest.Builder().build();
        adview.loadAd(adRequest);
    }


    public void webAction() {
        this.webView = (WebView) findViewById(R.id.webviewgrades);
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.getSettings().setAllowFileAccess(false);
        this.webView.getSettings().setAllowFileAccessFromFileURLs(false);

        this.webView.loadUrl(result_link);
       // Toast.makeText(grade_card.this, result_link, Toast.LENGTH_SHORT).show();
        this.swipe.setRefreshing(true);
        this.webView.getSettings().setSupportZoom(true);
        this.webView.getSettings().setBuiltInZoomControls(true);
        this.webView.getSettings().setDisplayZoomControls(true);
        this.webView.setHorizontalScrollBarEnabled(true);
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
