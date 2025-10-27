package com.example.myapplication5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    int[] images = {R.drawable.sunflower1, R.drawable.sunflower2};
    int index = 0;

    ImageSwitcher imageSwitcher;
    ImageButton btnNext, btnPrevious;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageSwitcher = findViewById(R.id.imageSwitcher);
        btnNext = findViewById(R.id.btnNext);
        btnPrevious = findViewById(R.id.btnPrevious);


        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                return imageView;
            }
        });


        imageSwitcher.setInAnimation(this, android.R.anim.slide_in_left);
        imageSwitcher.setOutAnimation(this, android.R.anim.slide_out_right);


        imageSwitcher.setImageResource(images[index]);


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = (index + 1) % images.length;
                imageSwitcher.setImageResource(images[index]);
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = (index - 1 + images.length) % images.length;
                imageSwitcher.setImageResource(images[index]);
            }
        });
    }
} com.example.myapplication1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText1, editText2;
    private Button actionButton;
    private ToggleButton toggleButton;
    private ImageButton closeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        actionButton = findViewById(R.id.actionButton);
        toggleButton = findViewById(R.id.toggleButton);
        closeButton = findViewById(R.id.closeButton);


        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // Close the activity
            }
        });




        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1 = editText1.getText().toString();
                String text2 = editText2.getText().toString();
                Toast.makeText(MainActivity.this, "Text1: " + text1 + "\nText2: " + text2, Toast.LENGTH_SHORT).show();
            }
        });


        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            String state = isChecked ? "ON" : "OFF";
            Toast.makeText(MainActivity.this, "Toggle is " + state, Toast.LENGTH_SHORT).show();
        });
    }
}
