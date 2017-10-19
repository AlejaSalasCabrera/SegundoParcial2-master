package com.jonmid.segundoparcial.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jonmid.segundoparcial.Array.Images;
import com.jonmid.segundoparcial.R;
import com.jonmid.segundoparcial.TeamActivity;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    TextView textView;
    TextView textView1;
    ImageView imageView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textView=(TextView) findViewById(R.id.id_tv_namedetail);
        textView1=(TextView) findViewById(R.id.id_tv_codedetail);
        imageView=(ImageView) findViewById(R.id.id_img_item_detail);

        button =(Button) findViewById(R.id.btn1);
        textView.setText(getIntent().getExtras().getString("name"));
        textView1.setText(getIntent().getExtras().getString("code"));
        Picasso.with(this).load(Images.imageRandom()).into(imageView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goActivityOne(view);
            }
        });


    }

    public void goActivityOne(View view){
        Intent intent = new Intent(this, TeamActivity.class);
        startActivity(intent);
    }




}
