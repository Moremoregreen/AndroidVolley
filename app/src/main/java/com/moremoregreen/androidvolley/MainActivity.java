package com.moremoregreen.androidvolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.toolbox.NetworkImageView;

public class MainActivity extends AppCompatActivity {

    Button btn_get,btn_post,btn_put,btn_patch,btn_delete,btn_fetch_image;
    NetworkImageView image_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //init View
        btn_get = findViewById(R.id.btn_get);
        btn_delete = findViewById(R.id.btn_delete);
        btn_fetch_image = findViewById(R.id.btn_fet_image);
        btn_patch = findViewById(R.id.btn_patch);
        btn_post = findViewById(R.id.btn_post);
        btn_put = findViewById(R.id.btn_put);

        image_view = findViewById(R.id.image_view);

        //Set Event
        btn_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyVolleyRequest.getInstance(MainActivity.this, new IVolley() {
                    @Override
                    public void onResponse(String response) {
                        //Show result from API
                        Toast.makeText(MainActivity.this, ""+response, Toast.LENGTH_SHORT).show();
                    }
                })
                        .getRequest("https://jsonplaceholder.typicode.com/todos/1");
            }
        });

        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyVolleyRequest.getInstance(MainActivity.this, new IVolley() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivity.this, ""+response, Toast.LENGTH_SHORT).show();
                    }
                }).postRequest("https://jsonplaceholder.typicode.com/posts");
            }
        });

        btn_put.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyVolleyRequest.getInstance(MainActivity.this, new IVolley() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivity.this, ""+response, Toast.LENGTH_SHORT).show();
                    }
                }).putRequest("https://jsonplaceholder.typicode.com/posts/1");
            }
        });

        btn_patch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyVolleyRequest.getInstance(MainActivity.this, new IVolley() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivity.this, ""+response, Toast.LENGTH_SHORT).show();
                    }
                }).patchRequest("https://jsonplaceholder.typicode.com/posts/1");
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyVolleyRequest.getInstance(MainActivity.this, new IVolley() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivity.this, ""+response, Toast.LENGTH_SHORT).show();
                    }
                }).deleteRequest("https://jsonplaceholder.typicode.com/posts/1");
            }
        });

        btn_fetch_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image_view.setImageUrl("http://zh-tw.lc742.com/uploadfiles/380/news/new-year-2018.png",
                        MyVolleyRequest.getInstance(MainActivity.this).getImageLoader());
            }
        });

    }
}
