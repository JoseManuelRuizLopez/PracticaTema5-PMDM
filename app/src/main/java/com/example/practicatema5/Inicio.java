package com.example.practicatema5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inicio extends AppCompatActivity {

    Button btn1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        btn1 = (Button) findViewById(R.id.btn1);

        btn1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ConfigurarToast.class);
                startActivity(intent);
            }
        });
    }
}
