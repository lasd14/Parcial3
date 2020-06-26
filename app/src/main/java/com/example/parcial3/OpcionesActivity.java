package com.example.parcial3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class OpcionesActivity extends AppCompatActivity {

    Button btnrecetas, btnagregar, btnfavoritas;
    ListView lvrecetas;
    TextView tipousuario;
    String producto, foto, ingrediente1, ingrediente2, ingrediente3, ingrediente4, ingrediente5, preparacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);

        this.InicializarControles();


        SharedPreferences preferences1 = getSharedPreferences("login1", Context.MODE_PRIVATE);
        String userinfo = preferences1.getString("user", "");
        tipousuario.setText(userinfo);

        if (userinfo.equals("admin1")){
            btnfavoritas.setVisibility(View.GONE);
        } else if (userinfo.equals("consumer1")){
            btnagregar.setVisibility(View.GONE);
        }

    }


    private void InicializarControles(){

        btnrecetas   = (Button)findViewById(R.id.btnrecetas);
        btnagregar   = (Button)findViewById(R.id.btnagregar);
        btnfavoritas = (Button)findViewById(R.id.btnfavoritas);
        tipousuario  = (TextView)findViewById(R.id.tipousuario);
        lvrecetas    = (ListView)findViewById(R.id.lvtrecetas);

    }


    public void Recetas(View view) {

        Intent recetas = new Intent(getApplicationContext(), RecetasActivity.class);

            recetas.putExtra("producto", producto);
            recetas.putExtra("foto", foto);
            recetas.putExtra("ingrediente1", ingrediente1);
            recetas.putExtra("ingrediente2", ingrediente2);
            recetas.putExtra("ingrediente3", ingrediente3);
            recetas.putExtra("ingrediente4", ingrediente4);
            recetas.putExtra("ingrediente5", ingrediente5);
            recetas.putExtra("preparacion", preparacion);
            Log.e(producto, "Estamos aqui");
        producto     = getIntent().getStringExtra("producto");
        foto         = getIntent().getStringExtra("foto");
        ingrediente1 = getIntent().getStringExtra("ingrediente1");
        ingrediente2 = getIntent().getStringExtra("ingrediente2");
        ingrediente3 = getIntent().getStringExtra("ingrediente3");
        ingrediente4 = getIntent().getStringExtra("ingrediente4");
        ingrediente5 = getIntent().getStringExtra("ingrediente5");
        preparacion  = getIntent().getStringExtra("preparacion");
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