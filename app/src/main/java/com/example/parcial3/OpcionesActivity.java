package com.example.parcial3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.parcial3.Adaptador.ListViewAdapterRecetas;
import com.example.parcial3.entidades.Recetas;

import java.util.ArrayList;
import java.util.List;

public class OpcionesActivity extends AppCompatActivity {

    Button btnrecetas, btnagregar, btnfavoritas;
    ListView lvrecetas;

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
        lvrecetas    = (ListView)findViewById(R.id.lvtrecetas);

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