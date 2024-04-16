package com.example.dispmoveisavaliacao01;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuintaActivity extends AppCompatActivity {

    private List<Integer> numeroSecreto = new ArrayList<>();
    private List<List<EditText>> linhasEdit = new ArrayList<>();
    private int tentativaAtual = 0;

    private int totalAcertos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quinta);

        gerarNumeroSecreto();

        for (int i = 1; i <= 5; i++) {
            List<EditText> linhaEdit = new ArrayList<>();
            for (int j = 1; j <= 4; j++) {
                int editTextId = getResources().getIdentifier("edtNumero" + i + "_" + j, "id", getPackageName());
                EditText editText = findViewById(editTextId);
                linhaEdit.add(editText);
            }
            linhasEdit.add(linhaEdit);
        }

        configurarEditTexts(linhasEdit.get(0));

        Button btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuintaActivity.this, SegundaActivity.class);
                startActivity(intent);
            }
        });
    }

    private void configurarEditTexts(List<EditText> editTexts) {
        for (final EditText editText : editTexts) {
            editText.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                        boolean linhaCompleta = true;
                        for (EditText edt : linhasEdit.get(tentativaAtual)) {
                            if (edt.getText().toString().isEmpty()) {
                                linhaCompleta = false;
                                break;
                            }
                        }
                        if (linhaCompleta) {
                            verificarEntradaUsuario();
                        }
                        return true;
                    }
                    return false;
                }
            });
        }
    }


    private void gerarNumeroSecreto() {
        Random random = new Random();
        while (numeroSecreto.size() < 4) {
            int digito = random.nextInt(10);
            if (!numeroSecreto.contains(digito)) {
                numeroSecreto.add(digito);
            }
        }
        // Imprimir o número secreto no logcat
        Log.d("NumeroSecreto", "Número secreto: " + numeroSecreto.toString());
    }

    private void verificarEntradaUsuario() {
        List<Integer> entradaUsuario = new ArrayList<>();
        List<EditText> linhaAtual = linhasEdit.get(tentativaAtual);
        for (EditText editText : linhaAtual) {
            int numeroDigitado = Integer.parseInt(editText.getText().toString());
            entradaUsuario.add(numeroDigitado);
        }

        int[] resultados = new int[4];

        for (int i = 0; i < 4; i++) {
            int numero = entradaUsuario.get(i);
            if (numero == numeroSecreto.get(i)) {
                resultados[i] = 2;
            } else if (numeroSecreto.contains(numero)) {
                resultados[i] = 1;
            } else {
                resultados[i] = 0;
            }
        }

        for (int i = 0; i < 4; i++) {
            EditText editText = linhaAtual.get(i);
            switch (resultados[i]) {
                case 0:
                    editText.setBackgroundColor(Color.RED);
                    break;
                case 1:
                    editText.setBackgroundColor(Color.YELLOW);
                    break;
                case 2:
                    editText.setBackgroundColor(Color.GREEN);
                    totalAcertos++;
                    break;
            }
        }

        tentativaAtual++;

        if (tentativaAtual < 5) {
            configurarEditTexts(linhasEdit.get(tentativaAtual));
        }
            verificarResultadoJogo();

    }

    private void verificarResultadoJogo() {
        Log.d("Total acertos", "total acertos: " + totalAcertos);

        if (totalAcertos == 4) {
            Intent intent = new Intent(QuintaActivity.this, GanhouJogo.class);
            startActivity(intent);
            finish();
        } else if (tentativaAtual == 5) {
            Intent intent = new Intent(QuintaActivity.this, PerdeuJogo.class);
            startActivity(intent);
            finish();
        }

        totalAcertos = 0;
    }


}
