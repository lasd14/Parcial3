package com.example.parcial3;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.parcial3.Adaptador.ListViewAdapterRecetas;
import com.example.parcial3.Adaptador.ListViewAdapterRecetasFavoritas;
import com.example.parcial3.entidades.Recetas;
import com.example.parcial3.entidades.RecetasFavoritas;

import java.util.ArrayList;
import java.util.List;

public class FavoritasActivity extends AppCompatActivity {

    ListView lvrecetasfavoritas;
    Button btnactualizarfav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas);

        this.InicializarControles();

    }

    private void InicializarControles(){

        lvrecetasfavoritas = (ListView)findViewById(R.id.lvrecetasfavoritas);
        btnactualizarfav = (Button)findViewById(R.id.btnactualizarfav);

    }

    public void LoadListViewFavoritas(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "dbparcial3.db", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        List<RecetasFavoritas> recetasFavoritas = new ArrayList<>();

        String[] campos = new String[] {"producto", "foto", "preparacion", "comentario"};

        Cursor c = BaseDeDatos.query("favoritos",campos, null, null, null, null, null);
        if (c.moveToFirst()){
            do {
                RecetasFavoritas recetasFavoritas1 = new RecetasFavoritas(
                        c.getString(0),
                        c.getString(1),
                        c.getString(2),
                        c.getString(3)
                );
                recetasFavoritas.add(recetasFavoritas1);
            } while (c.moveToNext());
        }

        ListViewAdapterRecetasFavoritas adapter = new ListViewAdapterRecetasFavoritas(getApplicationContext(), recetasFavoritas);
        lvrecetasfavoritas.setAdapter(adapter);

    }




}