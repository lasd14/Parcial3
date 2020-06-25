package com.example.parcial3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OpcionesActivity extends AppCompatActivity {

    Button btnrecetas, btnagregar, btnfavoritas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);

        this.InicializarControles();

    }


    private void InicializarControles(){

        btnrecetas   = (Button)findViewById(R.id.btnrecetas);
        btnagregar   = (Button)findViewById(R.id.btnagregar);
        btnfavoritas = (Button)findViewById(R.id.btnfavoritas);

    }

    public void Recetas(View view) {
        Intent recetas = new Intent(getApplicationContext(), RecetasActivity.class);
        startActivity(recetas);
    }

    public void Agregar(View view) {
        Intent agregar = new Intent(getApplicationContext(), AgregarActivity.class);
        startActivity(agregar);
    }

    public void Favoritas(View view) {
        Intent favoritos = new Intent(getApplicationContext(), FavoritasActivity.class);
        startActivity(favoritos);
    }


}