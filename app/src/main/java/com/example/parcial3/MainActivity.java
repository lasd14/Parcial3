package com.example.parcial3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtusuario, txtpassword;
    Button botonacceder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.InicializarControles();

    }

    //Metodo para inicializar controles
    private void InicializarControles() {

        txtusuario   = (EditText)findViewById(R.id.txtusuario);
        txtpassword  = (EditText)findViewById(R.id.txtpassword);
        botonacceder = (Button)findViewById(R.id.botonacceder);

        botonacceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user           = txtusuario.getText().toString();
                String password       = txtpassword.getText().toString();

            }
        });


    }




}
