package com.jonmid.segundoparcial.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jonmid.segundoparcial.Array.Images;
import com.jonmid.segundoparcial.Model.TeamModelSalasAlejandra;
import com.jonmid.segundoparcial.R;
import com.jonmid.segundoparcial.Views.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aula7 on 17/10/17.
 */

public class TeamAdapterSalasAlejandra extends RecyclerView.Adapter<TeamAdapterSalasAlejandra.ViewHolder>{

    List<TeamModelSalasAlejandra> teamModelSalasAlejandraList = new ArrayList<>();
    Context context;

    // Constructor de la clase
    public TeamAdapterSalasAlejandra(List<TeamModelSalasAlejandra> teamModelSalasAlejandras, Context context) {
        this.teamModelSalasAlejandraList = teamModelSalasAlejandras;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Configuracion del ViewAdapter

        // Obtener la vista (item.xml)
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team, parent, false);

        // Pasar la vista (item.xml) al ViewHolder
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Encargado de trabajar con el item.xml y sus componentes
        holder.textViewName.setText( teamModelSalasAlejandraList.get(position).getName());
        holder.textViewCode.setText(teamModelSalasAlejandraList.get(position).getCode());
        Picasso.with(context).load(Images.imageRandom()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return teamModelSalasAlejandraList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textViewName;
        TextView textViewCode;
        ImageView imageView;
        public ViewHolder(View item) {
            super(item);

            item.setOnClickListener(this);

            textViewCode = (TextView) item.findViewById(R.id.id_tv_cod_team);
            textViewName = (TextView) item.findViewById(R.id.id_tv_name_team);
            imageView = (ImageView) item.findViewById(R.id.id_img_team);
        }

        @Override
        public void onClick(View view) {
            Context contextItem = view.getContext();
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("name", teamModelSalasAlejandraList.get(getLayoutPosition()).getName());
            intent.putExtra("code", teamModelSalasAlejandraList.get(getLayoutPosition()).getCode());
            contextItem.startActivity(intent);


            //String valor = Integer.toString(albumModelList.get(getLayoutPosition()).getId());
            //Toast.makeText(contextItem, valor, Toast.LENGTH_SHORT).show();
        }
    }
}
