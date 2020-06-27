package com.example.parcial3.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.parcial3.R;
import com.example.parcial3.entidades.Recetas;
import com.example.parcial3.entidades.RecetasFavoritas;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapterRecetasFavoritas extends ArrayAdapter<RecetasFavoritas> {

    private List<RecetasFavoritas> recetasfavoritas = new ArrayList<>();

    public ListViewAdapterRecetasFavoritas(Context context, List<RecetasFavoritas> datos) {
        super(context, R.layout.listview_recetasfavoritas, datos);
        recetasfavoritas = datos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater =LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_recetasfavoritas,null);

        TextView producto = (TextView)item.findViewById(R.id.tvproducto);
        producto.setText(recetasfavoritas.get(position).getProducto());

        ImageView foto = (ImageView) item.findViewById(R.id.ivfoto);
        Picasso.get().load(String.valueOf(recetasfavoritas.get(position).getFoto())).into(foto);

        TextView preparacion = (TextView)item.findViewById(R.id.tvpreparacion);
        preparacion.setText(recetasfavoritas.get(position).getPreparacion());

        TextView comentario = (TextView)item.findViewById(R.id.tvcomentario);
        comentario.setText(recetasfavoritas.get(position).getComentario());

        final ImageView botonmegusta = (ImageView) item.findViewById(R.id.btnlike);
        botonmegusta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (botonmegusta.isPressed()){
                    botonmegusta.setImageResource(R.drawable.likeon);
                } else if (botonmegusta.isPressed()){
                    botonmegusta.setImageResource(R.drawable.like);
                }
            }
        });

        return item;

    }

}
