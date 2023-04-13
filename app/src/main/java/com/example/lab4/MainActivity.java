package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btn_add ;
EditText et_name, et_age ;
@SuppressLint("UseSwitchCompatOrMaterialCode")
Switch sw_active;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = findViewById(R.id.btn_add);
        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        sw_active = findViewById(R.id.sw_active);

        btn_add.setOnClickListener( new View.OnClickListener() {
            public void onClick(View view) {
                customerModel cm ;
                try {
                    cm = new customerModel(-1, et_name.getText().toString(), Integer.parseInt(et_age.getText().toString()), sw_active.isChecked());
                    Toast.makeText(MainActivity.this, cm.toString(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                    cm = new customerModel(-1 , "error" , 0 , false ) ;
                }
                DataBaseHelper dbh = new DataBaseHelper(MainActivity.this);
                boolean success = dbh.addOne(cm);
                Toast.makeText(MainActivity.this, "Success= " + success, Toast.LENGTH_SHORT).show();
            }
        }) ;
        }



    }
