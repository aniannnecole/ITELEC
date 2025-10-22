package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AutoCompleteTextView autoCompleteSelection = findViewById(R.id.autoCompleteSelection);
        String[] items = {
                "Philippines", "Japan", "United States", "Canada", "Australia",
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                items
        );
        autoCompleteSelection.setAdapter(adapter);
        autoCompleteSelection.setOnClickListener(v -> autoCompleteSelection.showDropDown());
        autoCompleteSelection.setOnItemClickListener((parent, view, position, id) -> {
            String selected = parent.getItemAtPosition(position).toString();
            Toast.makeText(MainActivity.this, "Selected: " + selected, Toast.LENGTH_SHORT).show();
        });
    }
}
