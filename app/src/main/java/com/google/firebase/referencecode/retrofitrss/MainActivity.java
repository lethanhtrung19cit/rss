package com.google.firebase.referencecode.retrofitrss;


import android.app.ProgressDialog;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.Response;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;

import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class MainActivity extends AppCompatActivity {

   Toolbar toolbar;
   RecyclerView recyclerView;
   ImageView imageView;
   RssRoot rssRoot;

    private final String RSS_link = "https://cdn.24h.com.vn/upload/rss/trangchu24h.rss";
    private final String RSS_to_Json_API="https://api.rss2json.com/v1/api.json?rss_url=";


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Rss");

        setSupportActionBar(toolbar);
        imageView=findViewById(R.id.image);
        recyclerView=findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);


        doStuff();

    }
    private void doStuff()
    {
        final Bitmap[] bmp = {null};
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        Handler handler=new Handler(Looper.myLooper());
        ProgressDialog mDialog = new ProgressDialog(MainActivity.this);
        executorService.execute(new Runnable() {
            @Override
            public void run() {


                String result;
                HTTPDataHandler http = new HTTPDataHandler();
                result = http.GetHTTPData(RSS_to_Json_API+ RSS_link);


                handler.post(new Runnable() {
                    @Override
                    public void run() {
//
                        mDialog.dismiss();
                        rssRoot = new Gson().fromJson(result, RssRoot.class);
                        FeedAdapter adapter = new FeedAdapter(rssRoot, getBaseContext());
                        recyclerView.setAdapter(adapter);

                    }
                });
            }
        });
    }
//
}


