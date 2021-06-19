package com.example.loginsabado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    //ATRIBUTOS
    TextView nombre;
    ImageView foto, foto2,fondo;


    //Trabajador Trabajador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //nombre=findViewById(R.id.nombre);
        //foto=findViewById(R.id.foto);
        //foto2=findViewById(R.id.foto2);
        //fondo=findViewById(R.id.fondo);

        //Trabajador = (Trabajador)getIntent().getSerializableExtra("Trabajador");

        //nombre.setText(Trabajador.getNombre());
        //foto.setImageResource(Trabajador.getFoto());
        //fondo.setImageResource(Trabajador.getFondo());
        //foto2.setImageResource(Trabajador.getFoto2());

    }


    //Metodo para configurar el idioma de mi telefono
    public void  cambiarIdioma(String lenguaje){

        Locale idioma = new Locale(lenguaje); //Tipo de local que recibe el idioma deseado
        Locale.setDefault(idioma); //Se establece el idioma en la variable de entorno

        Configuration configurationTelefono = getResources().getConfiguration();
        configurationTelefono.locale = idioma;

        getBaseContext().getResources().updateConfiguration(configurationTelefono,getBaseContext().getResources().getDisplayMetrics());
    }

    //Metido que infla(PINTA) el menu
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //El metodo que controla la accion de cada opcion del menu
    public boolean onOptionsItemSelected(MenuItem opcion){

        int id=opcion.getItemId();

        switch (id){

            case (R.id.opcion1):
                Intent intent = new Intent(MainActivity.this,Perfil.class);
                startActivity(intent);
                break;

            case (R.id.opcion2):
                this.cambiarIdioma("en");
                Intent intent2 = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent2);

                break;

            case (R.id.opcion3):
                this.cambiarIdioma("es");
                Intent intent3 = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent3);
                break;
        }
        return  super.onOptionsItemSelected(opcion);
    }
}