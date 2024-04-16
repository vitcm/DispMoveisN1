package com.example.dispmoveisavaliacao01;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class QuartaActivity extends AppCompatActivity {

    private ImageView imgPedraUsuario, imgPapelUsuario, imgTesouraUsuario;

    private TextView textResultado;
    private ImageView imgPedraOponente, imgPapelOponente, imgTesouraOponente;
    private ImageView imgOponenteEscolha, imgUsuarioEscolha;

    private String escolhaStringUsuario, escolhaStringOponente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quarta);

        imgPedraUsuario = findViewById(R.id.imgPedraUsuario);
        imgPapelUsuario = findViewById(R.id.imgPapelUsuario);
        imgTesouraUsuario = findViewById(R.id.imgTesouraUsuario);

        imgPedraOponente = findViewById(R.id.imgPedraOponente);
        imgPapelOponente = findViewById(R.id.imgPapelOponente);
        imgTesouraOponente = findViewById(R.id.imgTesouraOponente);

        imgOponenteEscolha = findViewById(R.id.imgOponenteEscolha);
        imgUsuarioEscolha = findViewById(R.id.imgUsuarioEscolha);

        imgPedraUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escolhaStringUsuario = "pedra";
                escolherJogadaUsuario(R.drawable.pedra);
            }

        });

        imgPapelUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escolhaStringUsuario = "papel";
                escolherJogadaUsuario(R.drawable.papel);
            }
        });

        imgTesouraUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escolhaStringUsuario = "tesoura";
                escolherJogadaUsuario(R.drawable.tesoura);
            }
        });

        Button btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuartaActivity.this, SegundaActivity.class);
                startActivity(intent);
            }
        });

        escolherJogadaOponente();
    }

    private void escolherJogadaUsuario(int imagem) {
        imgUsuarioEscolha.setImageResource(imagem);
        imgUsuarioEscolha.setBackgroundColor(Color.RED);

        escolherJogadaOponente();
    }

    private void escolherJogadaOponente() {
        Random random = new Random();
        int escolhaOponente = random.nextInt(3);
        switch (escolhaOponente) {
            case 0:
                escolhaStringOponente= "pedra";
                imgOponenteEscolha.setImageResource(R.drawable.pedra);
                break;
            case 1:
                escolhaStringOponente= "papel";
                imgOponenteEscolha.setImageResource(R.drawable.papel);
                break;
            case 2:
                escolhaStringOponente= "tesoura";
                imgOponenteEscolha.setImageResource(R.drawable.tesoura);
                break;
        }

        determinarResultadoJogo(escolhaStringUsuario, escolhaStringOponente);
    }

    private void determinarResultadoJogo(String escolhaStringUsuario, String escolhaStringOponente) {
        textResultado = findViewById(R.id.textResultado);
        if (escolhaStringUsuario != null && escolhaStringOponente != null) {
            if (escolhaStringUsuario.equals(escolhaStringOponente)) {
                textResultado.setText("Empatou!");
            } else if ((escolhaStringUsuario.equals("pedra") && escolhaStringOponente.equals("tesoura")) ||
                    (escolhaStringUsuario.equals("tesoura") && escolhaStringOponente.equals("papel")) ||
                    (escolhaStringUsuario.equals("papel") && escolhaStringOponente.equals("pedra"))) {
                textResultado.setText("Eba! Você ganhou!");
            } else {
                textResultado.setText("Opa! Você perdeu.");
            }
        }
    }
}
