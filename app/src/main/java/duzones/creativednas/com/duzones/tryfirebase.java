package duzones.creativednas.com.duzones;

import android.Manifest;
import android.app.Dialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Objects;
import java.util.Random;

import me.itangqi.waveloadingview.WaveLoadingView;

import static android.content.Context.DOWNLOAD_SERVICE;

public class tryfirebase extends AppCompatActivity {
    private int STORAGE_PERMISSION_CODE = 1;

    Dialog progressbox;
    WaveLoadingView waveLoadingView;
    TextView textView;
    WebView webview;
    String e;
    AdRequest adRequest;
    private static final String APP_ID = "ca-app-pub-7180287377976427~2306652579";
    private InterstitialAd interstitialAd;
    int zrandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tryfirebase);
        e = getIntent().getExtras().getString("link_to_pass");
        progressbox = new Dialog(this);
        progressbox.setContentView(R.layout.progressbox);
        progressbox.setCancelable(true);
        progressbox.setCanceledOnTouchOutside(false);
        waveLoadingView = progressbox.findViewById(R.id.waveLoadingView);
        waveLoadingView.setShapeType(WaveLoadingView.ShapeType.CIRCLE);
        waveLoadingView.setCenterTitle(" ");
        waveLoadingView.setCenterTitleColor(Color.parseColor("#212121"));
        waveLoadingView.setBorderWidth(5);
        // waveLoadingView.setCenterTitleStrokeColor(Color.parseColor("#ffffff"));
        //waveLoadingView.setCenterTitleStrokeWidth(2);
        waveLoadingView.setAmplitudeRatio(70);
        waveLoadingView.setWaveColor(Color.parseColor("#0971D8"));
        waveLoadingView.setBorderColor(Color.parseColor("#0971D8"));
        progressbox.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        progressbox.show();


        MobileAds.initialize(this, APP_ID);

        AdView adview = findViewById(R.id.adView);
        adRequest = new AdRequest.Builder().build();
        adview.loadAd(adRequest);


        interstitialAd = new InterstitialAd(tryfirebase.this);
        interstitialAd.setAdUnitId("ca-app-pub-7180287377976427/8354499258");
        adRequest = new AdRequest.Builder().build();
        interstitialAd.loadAd(adRequest);

        //  if (showad() == 1)


        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int i) {
                adRequest = new AdRequest.Builder().build();
                interstitialAd.loadAd(adRequest);
            }

            @Override
            public void onAdLeftApplication() {
                adRequest = new AdRequest.Builder().build();
                interstitialAd.loadAd(adRequest);
            }

            @Override
            public void onAdOpened() {
                adRequest = new AdRequest.Builder().build();
                interstitialAd.loadAd(adRequest);
            }

            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                adRequest = new AdRequest.Builder().build();
                interstitialAd.loadAd(adRequest);
                // Toast.makeText(getActivity(), "working", Toast.LENGTH_SHORT).show();
            }

        });


        // Toast.makeText(this, e, Toast.LENGTH_LONG).show();

        if (ContextCompat.checkSelfPermission(tryfirebase.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
        } else {
            //requeststoragepermission();
            ActivityCompat.requestPermissions(tryfirebase.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);

        }
        init(e);
        listener();


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            } else {
                ActivityCompat.requestPermissions(tryfirebase.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);

            }
        }
    }

    private void init(String e) {

        webview = (WebView) findViewById(R.id.webview2);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setAllowFileAccess(false);
        webview.getSettings().setAllowFileAccessFromFileURLs(false);

        webview.getSettings().setSupportZoom(true);
        webview.getSettings().setBuiltInZoomControls(true);
        webview.getSettings().setDisplayZoomControls(true);
        webview.setHorizontalScrollBarEnabled(true);
        webview.loadUrl(e);

        webview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                waveLoadingView.setProgressValue(newProgress);
                waveLoadingView.setCenterTitle(String.valueOf(newProgress));
                if (newProgress == 100) {
                    //waveLoadingView.setVisibility(View.GONE);
                    progressbox.dismiss();
                    if (showad() == 1) {
                        interstitialAd.show();
                    }

                }


            }
        });


        webview.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));

                request.setDescription("Download file...");
                request.setTitle(URLUtil.guessFileName(url, contentDisposition, mimetype));
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED); //Notify client once download is completed!
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(url, contentDisposition, mimetype));
                DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                dm.enqueue(request);
                Toast.makeText(getApplicationContext(), "Downloading File", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void listener() {
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }


            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

            }


        });


    }

    @Override
    public void onBackPressed() {

        if (webview.canGoBack()) {
            webview.goBack();
        } else {
            super.onBackPressed();
            if (showad() == 1) {
                interstitialAd.show();
            }

        }

    }

    public int showad() {
        zrandom = new Random().nextInt(10) + 2;
        if (zrandom == 1 || zrandom == 10) {
            return 1;
        } else if (zrandom > 4 && zrandom % 2 == 0)
            return 1;

        else return 0;
    }
}