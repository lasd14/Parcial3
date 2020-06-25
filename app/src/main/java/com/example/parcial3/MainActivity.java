package com.example.parcial3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtusuario, txtpassword;
    Button botonacceder;
    AdminSQLiteOpenHelper BaseDeDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.InicializarControles();

    }

    //Metodo para inicializar controles
    private void InicializarControles() {

        BaseDeDatos  = new AdminSQLiteOpenHelper(this, "dbparcial3.db", null, 1);
        txtusuario   = (EditText)findViewById(R.id.txtusuario);
        txtpassword  = (EditText)findViewById(R.id.txtpassword);
        botonacceder = (Button)findViewById(R.id.botonacceder);

        botonacceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user     = txtusuario.getText().toString();
                String password = txtpassword.getText().toString();
                Boolean checkuserpass = BaseDeDatos.userpassword(user,password);
                    if (checkuserpass==true){
                        Toast.makeText(MainActivity.this, "Inicio Exitoso", Toast.LENGTH_SHORT).show();
                        Intent login = new Intent(getApplicationContext(), OpcionesActivity.class);
                        startActivity(login);
                    }else {
                        Toast.makeText(MainActivity.this, "No se encuentra registrado", Toast.LENGTH_SHORT).show();
                    }
            }
        });
        }

}




