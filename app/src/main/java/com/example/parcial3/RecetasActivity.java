package com.example.parcial3;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.parcial3.Adaptador.ListViewAdapterRecetas;
import com.example.parcial3.entidades.Recetas;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecetasActivity extends AppCompatActivity {

//    private static final String URL_INTERNET = "https://d25dk4h1q4vl9b.cloudfront.net/media/images/menu-content/CR/hamburguesas-de-carne/hamburguesa-con-queso_new_cr.png";
    ListView lvtrecetas;
    Button btnactualizar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetas);

        this.InicializarControles();

    }

    private void InicializarControles(){
        lvtrecetas = (ListView)findViewById(R.id.lvtrecetas);
        btnactualizar = (Button)findViewById(R.id.btnactualizar);
    }

    public void LoadListview(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "dbparcial3.db", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        List<Recetas> recetas = new ArrayList<>();

        String[] campos = new String[] {"producto", "foto", "ingrediente1", "ingrediente2", "ingrediente3", "ingrediente4", "ingrediente5", "preparacion"};

        Cursor c = BaseDeDatos.query("recetas",campos, null, null, null, null, null);
        if (c.moveToFirst()){
            do {
                Recetas recetas1 = new Recetas(
                        c.getString(0),
                        c.getString(1),
                        c.getString(2),
                        c.getString(3),
                        c.getString(4),
                        c.getString(5),
                        c.getString(6),
                        c.getString(7)
                );
                recetas.add(recetas1);
            } while (c.moveToNext());
        }

        ListViewAdapterRecetas adapter = new ListViewAdapterRecetas(getApplicationContext(), recetas);
        lvtrecetas.setAdapter(adapter);

    }


//    private void LoadImageByInternetUrlWithPicasso(){
//        Picasso.get().load(URL_INTERNET).into(ivfoto);
//    }

}