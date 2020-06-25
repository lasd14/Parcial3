package com.example.parcial3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class DetallesActivity extends AppCompatActivity {

    TextView tvdetalleproducto, tvdetallepreparacion, tvdetalleing1, tvdetalleing2, tvdetalleing3, tvdetalleing4, tvdetalleing5;
    ImageView ivdetallefoto;

    String producto, foto, ingrediente1, ingrediente2, ingrediente3, ingrediente4, ingrediente5, preparacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        this.InicializarControles();
        getAndSetIntentData();

    }

    private void InicializarControles() {

        tvdetalleproducto    = (TextView)findViewById(R.id.tvdetalleproducto);
        ivdetallefoto        = (ImageView)findViewById(R.id.ivdetallefoto);
        tvdetallepreparacion = (TextView)findViewById(R.id.tvdetallepreparacion);
        tvdetalleing1        = (TextView)findViewById(R.id.tvdetalleing1);
        tvdetalleing2        = (TextView)findViewById(R.id.tvdetalleing2);
        tvdetalleing3        = (TextView)findViewById(R.id.tvdetalleing3);
        tvdetalleing4        = (TextView)findViewById(R.id.tvdetalleing4);
        tvdetalleing5        = (TextView)findViewById(R.id.tvdetalleing5);

    }

    void getAndSetIntentData(){

            producto     = getIntent().getStringExtra("producto");
            foto         = getIntent().getStringExtra("foto");
            ingrediente1 = getIntent().getStringExtra("ingrediente1");
            ingrediente2 = getIntent().getStringExtra("ingrediente2");
            ingrediente3 = getIntent().getStringExtra("ingrediente3");
            ingrediente4 = getIntent().getStringExtra("ingrediente4");
            ingrediente5 = getIntent().getStringExtra("ingrediente5");
            preparacion = getIntent().getStringExtra("preparacion");

            tvdetalleproducto.setText(producto);
            Picasso.get().load(foto);
            tvdetallepreparacion.setText(preparacion);
            tvdetalleing1.setText(ingrediente1);
            tvdetalleing2.setText(ingrediente2);
            tvdetalleing3.setText(ingrediente3);
            tvdetalleing4.setText(ingrediente4);
            tvdetalleing5.setText(ingrediente5);
        }
}

