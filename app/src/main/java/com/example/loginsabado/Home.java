package com.example.loginsabado;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Locale;

 public class Home extends AppCompatActivity {

    ArrayList<Trabajador> listaDeDatos = new ArrayList<>();
    RecyclerView listado;
    FirebaseFirestore baseDatos = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listado=findViewById(R.id.listado);
        listado.setHasFixedSize(true);
        listado.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        //Metodo que se crea para cargar los datos
        crearListado();

    }

    private void crearListado() {

        baseDatos.collection("turismo")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {

                            for (QueryDocumentSnapshot document : task.getResult()) {

                                String nombre = document.get("nombre").toString();
                                String foto = document.get("foto").toString();
                                String foto2 = document.get("foto2").toString();
                                String fondo = document.get("fondo").toString();
                                listaDeDatos.add(new Trabajador(nombre, foto, foto2, fondo));
                            }

                            AdaptadorLista adaptador = new AdaptadorLista(listaDeDatos);
                            listado.setAdapter(adaptador);

                        } else {
                            Toast.makeText(getApplicationContext(), "No se encotraron las imagenes", Toast.LENGTH_LONG).show();
                        }
                    }
                });
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
                Intent intent = new Intent(Home.this,Perfil.class);
                startActivity(intent);
                break;

            case (R.id.opcion2):
                this.cambiarIdioma("en");
                Intent intent2 = new Intent(Home.this,Home.class);
                startActivity(intent2);

                break;

            case (R.id.opcion3):
                this.cambiarIdioma("es");
                Intent intent3 = new Intent(Home.this,Home.class);
                startActivity(intent3);
                break;
        }
        return  super.onOptionsItemSelected(opcion);
    }
}
