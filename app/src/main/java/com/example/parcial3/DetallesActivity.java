package com.example.parcial3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class DetallesActivity extends AppCompatActivity {

    TextView tvdetalleproducto, tvdetallepreparacion, tvdetalleing1, tvdetalleing2, tvdetalleing3, tvdetalleing4, tvdetalleing5;
    ImageView ivdetallefoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        this.InicializarControles();
        DetallesReceta();
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

    private void DetallesReceta(){

        try {
            AdminSQLiteOpenHelper recetasSQLiteHelper = new AdminSQLiteOpenHelper(this,"dbparcial3.db",null,1);
            SQLiteDatabase BaseDeDatos = recetasSQLiteHelper.getReadableDatabase();

            if (BaseDeDatos !=null){
                String[] campos = new String[] {"producto", "foto", "ingrediente1", "ingrediente2", "ingrediente3", "ingrediente4", "ingrediente5", "preparacion"};
                Intent i = getIntent();
                String nombre = i.getStringExtra("producto");
                String[] args = new String[]{nombre};
                Cursor cursor = BaseDeDatos.query("recetas", campos, "producto = ?", args, null, null, null);
                if (cursor.moveToFirst()){
                    do {
                        tvdetalleproducto.setText(cursor.getString(0));
                        Picasso.get().load(cursor.getString(1)).into(ivdetallefoto);
                        tvdetalleing1.setText(cursor.getString(2));
                        tvdetalleing2.setText(cursor.getString(3));
                        tvdetalleing3.setText(cursor.getString(4));
                        tvdetalleing4.setText(cursor.getString(5));
                        tvdetalleing5.setText(cursor.getString(6));
                        tvdetallepreparacion.setText(cursor.getString(7));
                    }while (cursor.moveToNext());
                }
            }
        }catch (Exception e){
            Toast.makeText(this,"No tienes data" + e.getMessage().toString(), Toast.LENGTH_LONG).show();
        }
    }
}

