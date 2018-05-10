package com.example.kustom.sharedpreferencespicasso2;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.siyamed.shapeimageview.BubbleImageView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BubbleImageView bubbleImageView= findViewById(R.id.exampleBi);

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.show();


        Picasso
                .get()
                .load("https://baqueton.com/wp-content/uploads/2017/05/Tiernas-ilustraciones-producto-de-la-fusi%C3%B3n-de-la-cultura-pop-2.jpg")
                .fit()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                .into(bubbleImageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        progressDialog.dismiss();

                    }

                    @Override
                    public void onError(Exception e) {
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this, "Algo Salido Mal", Toast.LENGTH_SHORT).show();

                    }
                });

    }
}
