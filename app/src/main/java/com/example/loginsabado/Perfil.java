package com.example.loginsabado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Locale;

public class Perfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
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
                Intent intent = new Intent(Perfil.this,Home.class);
                startActivity(intent);
                break;

            case (R.id.opcion2):
                this.cambiarIdioma("en");
                Intent intent2 = new Intent(Perfil.this,Perfil.class);
                startActivity(intent2);

                break;

            case (R.id.opcion3):
                this.cambiarIdioma("es");
                Intent intent3 = new Intent(Perfil.this,Perfil.class);
                startActivity(intent3);
                break;
        }
        return  super.onOptionsItemSelected(opcion);
    }
}