package com.example.loginsabado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    ArrayList<Trabajador> listaDeDatos=new ArrayList<>();
    RecyclerView listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listado=findViewById(R.id.listado);
        listado.setHasFixedSize(true);
        listado.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        crearListado();

        AdaptadorLista adaptador= new AdaptadorLista(listaDeDatos);
        listado.setAdapter(adaptador);

    }

    private void crearListado() {

        listaDeDatos.add(new Trabajador(
                "Parque del cafe",
                getString(R.string.descripcion1),
                R.drawable.avatar1,
                R.drawable.foto1,
                R.drawable.fondo1
        ));

        listaDeDatos.add(new Trabajador(
                "Jardín Botánico Del Quindío",
                getString(R.string.descripcion2),
                R.drawable.avatar2,
                R.drawable.foto2,
                R.drawable.fondo2
        ));

        listaDeDatos.add(new Trabajador(
                "Museo del Oro Quimbaya",
                getString(R.string.descripcion3),
                R.drawable.avatar3,
                R.drawable.foto3,
                R.drawable.fondo3
        ));

        listaDeDatos.add(new Trabajador(
                "Parque De La Vida",
                getString(R.string.descripcion4),
                R.drawable.avatar4,
                R.drawable.foto4,
                R.drawable.fondo4
        ));
    }
}