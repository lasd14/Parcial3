package com.example.parcial3.Adaptador;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.parcial3.R;
import com.example.parcial3.entidades.Recetas;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapterRecetas extends ArrayAdapter<Recetas> {

    private List<Recetas> recetas = new ArrayList<>();

    public ListViewAdapterRecetas(Context context, List<Recetas> datos) {
        super(context, R.layout.listview_recetas, datos);
        recetas = datos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater =LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_recetas,null);

        TextView producto = (TextView)item.findViewById(R.id.tvproducto);
        producto.setText(recetas.get(position).getProducto());

        ImageView foto = (ImageView) item.findViewById(R.id.ivfoto);
        Picasso.get().load(String.valueOf(recetas.get(position).getFoto())).into(foto);

        TextView ingrediente1 = (TextView)item.findViewById(R.id.tving1);
        ingrediente1.setText(recetas.get(position).getIngrediente1());

        TextView ingrediente2 = (TextView)item.findViewById(R.id.tving2);
        ingrediente2.setText(recetas.get(position).getIngrediente2());

        TextView ingrediente3 = (TextView)item.findViewById(R.id.tving3);
        ingrediente3.setText(recetas.get(position).getIngrediente3());

        TextView ingrediente4 = (TextView)item.findViewById(R.id.tving4);
        ingrediente4.setText(recetas.get(position).getIngrediente4());

        TextView ingrediente5 = (TextView)item.findViewById(R.id.tving5);
        ingrediente5.setText(recetas.get(position).getIngrediente5());

        TextView preparacion = (TextView)item.findViewById(R.id.tvpreparacion);
        preparacion.setText(recetas.get(position).getPreparacion());

        return item;

    }
}
