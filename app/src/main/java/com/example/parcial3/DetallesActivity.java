package com.example.parcial3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class DetallesActivity extends AppCompatActivity {

    TextView tvdetalleproducto, tvdetallepreparacion, tvdetalleing1, tvdetalleing2, tvdetalleing3, tvdetalleing4, tvdetalleing5;
    ImageView ivdetallefoto;
    EditText txtcomentario;
    Button btnguardadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        this.InicializarControles();
        DetallesReceta();

        //Sharedpreferences para desginar que pueden ver los usuarios
        SharedPreferences preferences1 = getSharedPreferences("login1", Context.MODE_PRIVATE);
        String userinfo = preferences1.getString("user", "");

        if (userinfo.equals("admin1")){
            btnguardadas.setVisibility(View.GONE);
            txtcomentario.setVisibility(View.GONE);
        } else if (userinfo.equals("consumer1")){
            btnguardadas.setVisibility(View.VISIBLE);
            txtcomentario.setVisibility(View.VISIBLE);
        }

    }


    //Metodo para inicializar controles
    private void InicializarControles() {

        tvdetalleproducto    = (TextView)findViewById(R.id.tvdetalleproducto);
        ivdetallefoto        = (ImageView)findViewById(R.id.ivdetallefoto);
        tvdetallepreparacion = (TextView)findViewById(R.id.tvdetallepreparacion);
        tvdetalleing1        = (TextView)findViewById(R.id.tvdetalleing1);
        tvdetalleing2        = (TextView)findViewById(R.id.tvdetalleing2);
        tvdetalleing3        = (TextView)findViewById(R.id.tvdetalleing3);
        tvdetalleing4        = (TextView)findViewById(R.id.tvdetalleing4);
        tvdetalleing5        = (TextView)findViewById(R.id.tvdetalleing5);
        btnguardadas         = (Button)findViewById(R.id.btnguardadas);
        txtcomentario        = (EditText)findViewById(R.id.txtcomentario);

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

    public void Favoritos(View view){
        Intent i = getIntent();
        String nombre = i.getStringExtra("producto");
        String foto = i.getStringExtra("foto");
        String preparacion = i.getStringExtra("preparacion");
        String comentario = txtcomentario.getText().toString();
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"dbparcial3.db",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        if(BaseDeDatos !=null){
            try{
                ContentValues favoritos = new ContentValues();
                favoritos.put("producto",nombre);
                favoritos.put("foto",foto);
                favoritos.put("preparacion",preparacion);
                favoritos.put("comentario",comentario);
                BaseDeDatos.insert("favoritos",null,favoritos);
                Toast.makeText(getApplicationContext(),"Guardado correctamente",Toast.LENGTH_SHORT).show();
                BaseDeDatos.close();
                txtcomentario.setText("");

            }catch (Exception e){

                Toast.makeText(this,"Error" + e.getMessage().toString(), Toast.LENGTH_LONG).show();


            }

        }
    }


}

