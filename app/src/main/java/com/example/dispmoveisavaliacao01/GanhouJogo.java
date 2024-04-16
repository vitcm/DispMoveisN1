package com.example.dispmoveisavaliacao01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class GanhouJogo extends AppCompatActivity  {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ganhou_jogo);
        Button btnEntrar = findViewById(R.id.btnMenu);
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GanhouJogo.this, SegundaActivity.class);
                startActivity(intent);
            }
        });
    }
}
