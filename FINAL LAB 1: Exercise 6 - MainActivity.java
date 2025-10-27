package com.example.myapplication5; 

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int[] images = {R.drawable.sunflower1, R.drawable.sunflower2};
    String[] captions = {"Sunflower Field", "Close-up Sunflower"};

    int index = 0;
    ImageView imageView;
    TextView tvCaption;
    ImageButton btnNext, btnPrev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        tvCaption = findViewById(R.id.tvCaption);
        btnNext = findViewById(R.id.btnNext);
        btnPrev = findViewById(R.id.btnPrev);

        
        imageView.setImageResource(images[index]);
        tvCaption.setText(captions[index]);

       
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = (index + 1) % images.length;
                imageView.setImageResource(images[index]);
                tvCaption.setText(captions[index]);
            }
        });

       
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = (index - 1 + images.length) % images.length;
                imageView.setImageResource(images[index]);
                tvCaption.setText(captions[index]);
            }
        });
    }
}
