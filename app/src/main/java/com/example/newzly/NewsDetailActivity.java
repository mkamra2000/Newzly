package com.example.newzly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsDetailActivity extends AppCompatActivity {
    String title,desc,content,imageURL,url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        title = getIntent().getStringExtra("DETAIL_TITLE");
        desc = getIntent().getStringExtra("DETAIL_DESC");
        content = getIntent().getStringExtra("DETAIL_CONTENT");
        imageURL = getIntent().getStringExtra("DETAIL_IMAGE");
        url = getIntent().getStringExtra("DETAIL_URL");

        TextView titleTV = findViewById(R.id.idTVTitle);
        TextView subDescTV = findViewById(R.id.idTVSubDesc);
        TextView contentTV = findViewById(R.id.idTVContent);
        ImageView newsIV = findViewById(R.id.idIVNews);
        Button readNewsBtn = findViewById(R.id.idBtnReadNews);

        titleTV.setText(title);
        subDescTV.setText(desc);
        contentTV.setText(content);
        Picasso.get().load(imageURL).into(newsIV);
        readNewsBtn.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        });
    }
}