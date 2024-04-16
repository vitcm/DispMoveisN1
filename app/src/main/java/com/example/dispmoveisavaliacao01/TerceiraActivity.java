package com.example.dispmoveisavaliacao01;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TerceiraActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textResultado;
    private boolean codificado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira);

        editText = findViewById(R.id.editText);
        textResultado = findViewById(R.id.textResultado);

        Button btnCodificar = findViewById(R.id.btnCodificar);
        btnCodificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                codificarTexto();
            }
        });

        Button btnDecodificar = findViewById(R.id.btnDecodificar);
        btnDecodificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decodificarTexto();
            }
        });
        Button btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == KeyEvent.KEYCODE_ENTER) {
                    ocultarTeclado();
                    return true;
                }
                return false;
            }
        });
    }

    private void codificarTexto() {
        String textoOriginal = editText.getText().toString();
        String textoCodificado = codificarTexto(textoOriginal);
        textResultado.setText(textoCodificado);
        codificado = true;
        ocultarTeclado();
    }

    private void decodificarTexto() {
        if (codificado) {
            String textoCodificado = editText.getText().toString();
            String textoDecodificado = decodificarTexto(textoCodificado);
            textResultado.setText(textoDecodificado);
            codificado = false;
        } else {
            Toast.makeText(TerceiraActivity.this, "Você precisa primeiro codificar uma palavra", Toast.LENGTH_SHORT).show();
        }
        ocultarTeclado();
    }

    private void ocultarTeclado() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    private String codificarTexto(String texto) {
        StringBuilder resultado = new StringBuilder();
        String textoInvertido = new StringBuilder(texto).reverse().toString();

        for (int i = 0; i < textoInvertido.length(); i++) {
            resultado.append("v").append(textoInvertido.charAt(i));
        }

        resultado.insert(0, "v").append("v");

        return resultado.toString();
    }

    private String decodificarTexto(String textoCodificado) {
        StringBuilder textoSemV = new StringBuilder();
        boolean primeiraLetra = true;
        for (int i = 0; i < textoCodificado.length(); i++) {
            char caractere = textoCodificado.charAt(i);

            if (caractere == 'v') {
                if (primeiraLetra || i == textoCodificado.length() - 1) {
                    textoSemV.append(caractere);
                }
            } else {
                textoSemV.append(caractere);
                primeiraLetra = false;
            }
        }
        return textoSemV.toString();
    }

}
