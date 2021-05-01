package com.example.loginsabado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //ATRIBUTOS
    EditText cajaHorasTrabajadas;
    Button botonCalcularSalario;
    TextView cajaResultado,nombre,descripcion;
    ImageView foto, foto2,fondo;

    Trabajador empleado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre=findViewById(R.id.nombreMain);
        descripcion=findViewById(R.id.descripcionMain);
        foto=findViewById(R.id.fotoMain);
        //foto2=findViewById(R.id.foto2);
        //fondo=findViewById(R.id.fondo);

        empleado = (Trabajador)getIntent().getSerializableExtra("trabajador");

        nombre.setText(empleado.getNombre());
        descripcion.setText(empleado.getDescripcion());
        foto.setImageResource(empleado.getFoto());
        //foto2.setImageResource(empleado.getFoto2());
        //fondo.setImageResource(empleado.getFondo());
    }
}