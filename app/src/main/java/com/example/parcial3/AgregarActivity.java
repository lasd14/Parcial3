package com.example.parcial3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarActivity extends AppCompatActivity {

    EditText txtproducto, txtfoto, txtingrediente1, txtingrediente2, txtingrediente3, txtingrediente4, txtingrediente5, txtpreparacion;
    Button btnagregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        this.InicializarControles();
    }

    private void InicializarControles() {

        txtproducto     = (EditText)findViewById(R.id.txtproducto);
        txtfoto         = (EditText)findViewById(R.id.txtfoto);
        txtingrediente1 = (EditText)findViewById(R.id.txtingrediente1);
        txtingrediente2 = (EditText)findViewById(R.id.txtingrediente2);
        txtingrediente3 = (EditText)findViewById(R.id.txtingrediente3);
        txtingrediente4 = (EditText)findViewById(R.id.txtingrediente4);
        txtingrediente5 = (EditText)findViewById(R.id.txtingrediente5);
        btnagregar      = (Button)findViewById(R.id.btnagregar);

    }

    public void RegistrarRecetas(View view){
        //Hemos creado la conexion con la base de datos
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "parcial3.db", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        //Para tomar lo que se esta escribiendo
        String producto       = txtproducto.getText().toString();
        String foto           = txtfoto.getText().toString();
        String ingrediente1  = txtingrediente1.getText().toString();
        String ingrediente2  = txtingrediente2.getText().toString();
        String ingrediente3  = txtingrediente3.getText().toString();
        String ingrediente4  = txtingrediente4.getText().toString();
        String ingrediente5  = txtingrediente5.getText().toString();
//        String[] ingredientes = {ingredientes1,ingredientes2,ingredientes3,ingredientes4,ingredientes5};
//        StringBuffer arreglo = new StringBuffer();
        String preparacion    = txtpreparacion.getText().toString();

//        //Recorre el arreglo de ingredientes
//        for (int a = 0; a<ingredientes.length; a++){
//            arreglo = arreglo.append("N°"+(a+1)+"Ingrediente"+":"+ingredientes[a]);
//        }

        //Verificamos que no esten vacios los campos
        if (!producto.isEmpty() && !foto.isEmpty() && !preparacion.isEmpty() && !ingrediente1.isEmpty()){

            ContentValues registro = new ContentValues();
            //Guardar los valores en el content value
            registro.put("producto", producto);
            registro.put("foto", foto);
            registro.put("ingrediente1", ingrediente1);
            registro.put("ingrediente2", ingrediente2);
            registro.put("ingrediente3", ingrediente3);
            registro.put("ingrediente4", ingrediente4);
            registro.put("ingrediente5", ingrediente5);
//            registro.put("ingredientes", arreglo.toString());
            registro.put("preparacion", preparacion);

            //Insertar los valores que hemos guardado en la BD
            BaseDeDatos.insert("recetas", null, registro);
            //Cerramos la BD
            BaseDeDatos.close();
            //Limpiamos los campos
            txtproducto.setText("");
            txtfoto.setText("");
            txtingrediente1.setText("");
            txtingrediente2.setText("");
            txtingrediente3.setText("");
            txtingrediente4.setText("");
            txtingrediente5.setText("");

        } else {
            Toast.makeText(this, "Debes llenar los campos", Toast.LENGTH_SHORT).show();
        }




    }

}