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
                .inflate(R.layout.item_de_lista,parent,false);
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
        ImageView foto, foto2,fondo;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.nombre);
            foto=itemView.findViewById(R.id.foto);
            fondo=itemView.findViewById(R.id.fondo);
            foto2=itemView.findViewById(R.id.foto2);
        }

        public void actualizarDatosDeItem(Trabajador turismo) {

            nombre.setText(turismo.getNombre());
            Picasso.with(itemView.getContext())
                    .load(turismo.getFoto())
                    .into(foto);
            Picasso.with(itemView.getContext())
                    .load(turismo.getFoto())
                    .into(foto2);
            Picasso.with(itemView.getContext())
                    .load(turismo.getFoto())
                    .into(fondo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(itemView.getContext(),MainActivity.class);
                    intent.putExtra("trabajador",turismo);
                    itemView.getContext().startActivity(intent);

                }
            });
        }
    }
}

