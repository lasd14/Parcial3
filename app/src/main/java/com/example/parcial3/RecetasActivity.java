package com.example.parcial3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.parcial3.Adaptador.ListViewAdapterRecetas;
import com.example.parcial3.entidades.Recetas;
import java.util.ArrayList;
import java.util.List;

public class RecetasActivity extends AppCompatActivity {

    ListView lvtrecetas;
    EditText txtborrar;
    Button btnactualizar, btnborrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetas);

        this.InicializarControles();
        seleccionarReceta();

        //Sharedpreferences para designar que pueden ver los usuarios y que no
        SharedPreferences preferences1 = getSharedPreferences("login1", Context.MODE_PRIVATE);
        String userinfo = preferences1.getString("user", "");

        if (userinfo.equals("consumer1")){
            txtborrar.setVisibility(View.GONE);
            btnborrar.setVisibility(View.GONE);
        }


    }

    //Metodo para inicializar controles
    private void InicializarControles(){
        lvtrecetas    = (ListView)findViewById(R.id.lvtrecetas);
        btnactualizar = (Button)findViewById(R.id.btnactualizar);
        txtborrar     = (EditText)findViewById(R.id.txtborrar);
        btnborrar     = (Button)findViewById(R.id.btnborrar);
    }


    //Metodo para cargar en el listview nuestros datoss de la BD agregados por el admin
    public void LoadListview(View view){
        //Abrimos la BD
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

    //Metodo para eliminar una receta, se debe colocar el producto ya que actua como primary key y luego darle al boton para borrarlo
    //Luego debemos actualizar y veremos que no estara
    public void Eliminar(View view){
        try {
            String producto = txtborrar.getText().toString();
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "dbparcial3.db", null, 1);
            SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

            if (!producto.isEmpty()){
                if (BaseDeDatos != null){
                    BaseDeDatos.delete("recetas", "producto='"+producto+"'", null);
                    Toast.makeText(this, "Se ha eliminado la receta", Toast.LENGTH_SHORT).show();
                    txtborrar.setText("");
                }
            } else {
                Toast.makeText(this, "Llene el campo para eliminar", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e){
            Toast.makeText(this, "Error: "+ e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }

    }

    //Metodo para seleccionar que cosas mandaremos a los detalles de las recetas
    private void seleccionarReceta(){

        lvtrecetas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent detalles = new Intent(getApplicationContext(), DetallesActivity.class);
                String productoescogido = ((Recetas)adapterView.getItemAtPosition(i)).getProducto();
                detalles.putExtra("producto", productoescogido);
                String fotoescogida = ((Recetas)adapterView.getItemAtPosition(i)).getFoto();
                detalles.putExtra("foto", fotoescogida);
                String preparacionescogida = ((Recetas)adapterView.getItemAtPosition(i)).getPreparacion();
                detalles.putExtra("preparacion", preparacionescogida);
                Toast.makeText(RecetasActivity.this, "Receta: "+ productoescogido, Toast.LENGTH_SHORT).show();
                startActivity(detalles);
            }
        });
    }



}