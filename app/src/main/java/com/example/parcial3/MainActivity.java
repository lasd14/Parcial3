package com.example.parcial3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

        //Aqui es el onclick del boton acceder
        botonacceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user     = txtusuario.getText().toString();
                String password = txtpassword.getText().toString();
                Boolean checkuserpass = BaseDeDatos.userpassword(user,password);
                //Verificamos que el usuario este registrado en la BD (Esa insercion se hizo de manera manual, lo puede ver en AdminSQLiteOpenHelper)
                //Para el usuario administrador es "admin1" y password "admin"
                //Para el usuario comun es "consumer1" y password "consumer"
                    if (checkuserpass==true){
                        //Aqui trabajamos con sharedpreferences para delimitar lo que pueda ver y hacer cada uno en las siguientes pantallas
                        if (user.equals("admin1") && password.equals("admin")){
                            SharedPreferences preferences1 = getSharedPreferences("login1", Context.MODE_PRIVATE);
                            SharedPreferences.Editor edit = preferences1.edit();
                            edit.putString("user", user);
                            edit.putString("password", password);
                            edit.commit();
                            Toast.makeText(MainActivity.this, "Inicio Exitoso como Administrador", Toast.LENGTH_SHORT).show();
                            Intent login = new Intent(getApplicationContext(), OpcionesActivity.class);
                            startActivity(login);
                        } else if (user.equals("consumer1") && password.equals("consumer")){
                            SharedPreferences preferences1 = getSharedPreferences("login1", Context.MODE_PRIVATE);
                            SharedPreferences.Editor edit = preferences1.edit();
                            edit.putString("user", user);
                            edit.putString("password", password);
                            edit.commit();
                            Toast.makeText(MainActivity.this, "Inicio Exitoso como Usuario", Toast.LENGTH_SHORT).show();
                            Intent login = new Intent(getApplicationContext(), OpcionesActivity.class);
                            startActivity(login);
                        }

                    }else {
                        Toast.makeText(MainActivity.this, "No se encuentra registrado", Toast.LENGTH_SHORT).show();
                    }
            }
        });
        }

}




