package com.example.dispmoveisavaliacao01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SextaActivity extends AppCompatActivity {

    private List<String> valuesList = new ArrayList<>();
    private RecyclerView recyclerViewValues;
    private EditText editTextInput;
    private Button buttonRandomize, buttonInserir, btnVoltar;
    private ValuesAdapter valuesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sexta);

        editTextInput = findViewById(R.id.editTextInput);
        buttonInserir = findViewById(R.id.buttonInserir);
        buttonRandomize = findViewById(R.id.buttonRandomize);
        btnVoltar = findViewById(R.id.btnVoltar);
        recyclerViewValues = findViewById(R.id.recyclerViewValues);

        valuesList = new ArrayList<>();
        valuesAdapter = new ValuesAdapter(valuesList);
        recyclerViewValues.setAdapter(valuesAdapter);
        recyclerViewValues.setLayoutManager(new LinearLayoutManager(this));

        buttonInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inserirValor();
            }
        });

        buttonRandomize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomizeValue();
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void inserirValor() {
        String valor = editTextInput.getText().toString().trim();
        if (!valor.isEmpty()) {
            valuesList.add(valor);
            valuesAdapter.notifyDataSetChanged();
            editTextInput.setText("");
        } else {
            Toast.makeText(this, "Digite um valor ou palavra", Toast.LENGTH_SHORT).show();
        }
    }

    private void randomizeValue() {
        if (valuesList.isEmpty()) {
            Toast.makeText(this, "Insira pelo menos um valor ou palavra", Toast.LENGTH_SHORT).show();
            return;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(valuesList.size());
        String randomValue = valuesList.get(randomIndex);

        // Atualizar o texto do TextView com a palavra aleatória
        TextView textViewRandomWord = findViewById(R.id.textRandomResult);
        textViewRandomWord.setText("Palavra aleatória: " + randomValue);
    }
}
