package com.example.loginsabado;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

 public class AdaptadorLista extends RecyclerView.Adapter<AdaptadorLista.viewHolder> {

   ArrayList<Trabajador> listaDeDatos;

    public AdaptadorLista(ArrayList<Trabajador> listaDeDatos) {
        this.listaDeDatos = listaDeDatos;

    }

    @NonNull
    @Override
    public AdaptadorLista.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vistaItemLista= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_de_lista,null,false);
        return new viewHolder(vistaItemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorLista.viewHolder holder, int position) {
        holder.actualizarDatosDeItem(listaDeDatos.get(position));
    }

    @Override
    public int getItemCount() {
        return listaDeDatos.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView nombre;
        ImageView foto, foto2, fondo;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            fondo = itemView.findViewById(R.id.fondo);
            foto = itemView.findViewById(R.id.foto);
            foto2 = itemView.findViewById(R.id.foto2);
            nombre = itemView.findViewById(R.id.nombre);

        }
        public void actualizarDatosDeItem(Trabajador Datos) {

            Picasso.with(itemView.getContext())
                    .load(Datos.getFondo())
                    .into(fondo);
            Picasso.with(itemView.getContext())
                    .load(Datos.getFoto())
                    .into(foto);
            Picasso.with(itemView.getContext())
                    .load(Datos.getFoto2())
                    .into(foto2);
            nombre.setText(Datos.getNombre());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(itemView.getContext(),MainActivity.class);
                    intent.putExtra("Trabajador",Datos);
                    itemView.getContext().startActivity(intent);

                }
            });
        }
    }
}

