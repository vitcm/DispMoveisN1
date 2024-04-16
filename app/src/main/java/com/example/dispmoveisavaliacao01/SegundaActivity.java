package com.example.dispmoveisavaliacao01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        Button btnMenuInicial = findViewById(R.id.btnMenuInicial);
        btnMenuInicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SegundaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button btnCodificador = findViewById(R.id.btnPalavrasCodigo);
        btnCodificador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SegundaActivity.this, TerceiraActivity.class);
                startActivity(intent);
            }
        });

        Button btnJokenpo = findViewById(R.id.btnJokenpo);
        btnJokenpo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SegundaActivity.this, QuartaActivity.class);
                startActivity(intent);
            }
        });

        Button btnCodSecreto = findViewById(R.id.btnCodigoSecreto);
        btnCodSecreto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SegundaActivity.this, QuintaActivity.class);
                startActivity(intent);
            }
        });

        Button btnRandomizador = findViewById(R.id.btnRandom);
        btnRandomizador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SegundaActivity.this, SextaActivity.class);
                startActivity(intent);
            }
        });
    }
}