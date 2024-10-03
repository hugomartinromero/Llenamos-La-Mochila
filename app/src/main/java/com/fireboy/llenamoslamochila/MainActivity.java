package com.fireboy.llenamoslamochila;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox cbGorras, cbBanadores, cbCamisetas, cbZapatos, cbPantalones, cbLibros;
    TextView lblPeso;
    Button btnBorrar;
    int kg = 0;
    String[] strPeso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializamos el array strPeso dentro de onCreate
        strPeso = new String[]{getString(R.string.peso), String.valueOf(kg), getString(R.string.kg)};

        cbGorras = findViewById(R.id.cbGorras);
        cbBanadores = findViewById(R.id.cbBanadores);
        cbCamisetas = findViewById(R.id.cbCamisetas);
        cbZapatos = findViewById(R.id.cbZapatos);
        cbPantalones = findViewById(R.id.cbPantacas);
        cbLibros = findViewById(R.id.cbLibros);

        lblPeso = findViewById(R.id.lblPeso);

        btnBorrar = findViewById(R.id.btnVaciar);

        cbGorras.setOnCheckedChangeListener((compoundButton, b) -> anadirPeso(compoundButton, 2));
        cbBanadores.setOnCheckedChangeListener((compoundButton, b) -> anadirPeso(compoundButton, 3));
        cbCamisetas.setOnCheckedChangeListener((compoundButton, b) -> anadirPeso(compoundButton, 3));
        cbZapatos.setOnCheckedChangeListener((compoundButton, b) -> anadirPeso(compoundButton, 5));
        cbPantalones.setOnCheckedChangeListener((compoundButton, b) -> anadirPeso(compoundButton, 5));
        cbLibros.setOnCheckedChangeListener((compoundButton, b) -> anadirPeso(compoundButton, 10));

        btnBorrar.setOnClickListener(v -> borrar());
    }

    private void anadirPeso(CompoundButton compoundButton, int peso) {
        String cadena = "";

        CheckBox cb = (CheckBox) compoundButton;

        if (cb.isChecked()) {
            kg += peso;
        } else {
            kg -= peso;
        }

        if (kg <= 0) {
            kg = 0;
        }

        strPeso[1] = String.valueOf(kg);

        for (int i = 0; i < strPeso.length; i++) {
            cadena += strPeso[i];

            if (i != strPeso.length - 1) {
                cadena += " ";
            }
        }

        cambiarColor();

        lblPeso.setText(cadena);
    }

    private void borrar() {
        String cadena = "";

        kg = 0;
        strPeso[1] = String.valueOf(kg);

        for (int i = 0; i < strPeso.length; i++) {
            cadena += strPeso[i];

            if (i != strPeso.length - 1) {
                cadena += " ";
            }
        }

        cbGorras.setChecked(false);
        cbBanadores.setChecked(false);
        cbCamisetas.setChecked(false);
        cbZapatos.setChecked(false);
        cbPantalones.setChecked(false);
        cbLibros.setChecked(false);

        lblPeso.setText(cadena);
    }

    private void cambiarColor() {
        if (kg > 20) {
            lblPeso.setTextColor(Color.RED);
        } else {
            lblPeso.setTextColor(Color.BLACK);
        }
    }

}
