package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView my_text = findViewById(R.id.textview);
        Button my_button = findViewById(R.id.my_button);
        EditText my_edit = findViewById(R.id.my_edittext);
        my_button.setOnClickListener((View v) -> {
            String editString = my_edit.getText().toString();
            my_text.setText(getResources().getString(R.string.display_message) + editString);
        });
        CheckBox cat = findViewById(R.id.my_checkbox);
        CheckBox dog = findViewById(R.id.my_checkbox2);
        Switch gravity = findViewById(R.id.my_switch);
        RadioButton coffee = findViewById(R.id.my_radiobtn);
        RadioButton tea = findViewById(R.id.my_radiobtn2);

        cat.setOnCheckedChangeListener((btn, isChecked) -> {my_text.setText("You clicked on the "+ cat.getText().toString() + " and it is now "+ isChecked);
            Toast.makeText(getApplicationContext(), my_text.getText().toString(), Toast.LENGTH_SHORT).show();
        });
        dog.setOnCheckedChangeListener((btn, isChecked) -> {my_text.setText("You clicked on the "+ dog.getText().toString() + " and it is now "+ isChecked);
            Toast.makeText(getApplicationContext(), my_text.getText().toString(), Toast.LENGTH_SHORT).show();
        });
        gravity.setOnCheckedChangeListener((btn, isChecked) -> {my_text.setText("You clicked on the "+ gravity.getText().toString() + " and it is now "+ isChecked);
            Toast.makeText(getApplicationContext(), my_text.getText().toString(), Toast.LENGTH_SHORT).show();
        });
        coffee.setOnCheckedChangeListener((btn, isChecked) -> {my_text.setText("You clicked on the "+ coffee.getText().toString() + " and it is now "+ isChecked);
            Toast.makeText(getApplicationContext(), my_text.getText().toString(), Toast.LENGTH_SHORT).show();
        });
        tea.setOnCheckedChangeListener((btn, isChecked) -> {my_text.setText("You clicked on the "+ tea.getText().toString() + " and it is now "+ isChecked);
            Toast.makeText(getApplicationContext(), my_text.getText().toString(), Toast.LENGTH_SHORT).show();
        });
        ImageView my_image = findViewById(R.id.my_image);
        ImageButton algonquin = findViewById(R.id.my_img_btn);
        algonquin.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "The width = " + algonquin.getWidth() + " and height = " + algonquin.getHeight(), Toast.LENGTH_SHORT).show();
        });
    }
}