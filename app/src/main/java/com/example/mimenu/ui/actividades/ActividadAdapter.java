package com.example.mimenu.ui.actividades;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mimenu.R;
import com.example.mimenu.modelo.Actividad;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;

public class ActividadAdapter extends RecyclerView.Adapter<ActividadAdapter.ViewHolder>{

    private Context context;
    private List<Actividad> actividades;
    private LayoutInflater inflater;

    public ActividadAdapter(Context context, List<Actividad> actividades, LayoutInflater inflater) {
        this.context = context;
        this.actividades = actividades;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //enterar al adapter que el item es el cardView item_actividad.xml
        View root = inflater.inflate(R.layout.item_actividad, parent, false);
        return new ViewHolder(root);
    }

    //Por cada item
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nombre.setText(actividades.get(position).getNombre());
        holder.fecha.setText((CharSequence) actividades.get(position).getFecha());

        //Para obtener la hora con solo hora y minutos-------------------
        Calendar hora = actividades.get(position).getHora();
        int minutos = 0;
        int segundos = 0;
        minutos = hora.MINUTE;
        segundos = hora.SECOND;

        holder.hora.setText(String.format("%02d:%02d", minutos, segundos));
        //----------------------------------------------------------------
    }

    @Override
    public int getItemCount() {
        return actividades.size();
    }

    //La que conoce nuestro item
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nombre, fecha, hora;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.tvNombre);
            fecha = itemView.findViewById(R.id.tvFecha);
            hora = itemView.findViewById(R.id.tvHora);
        }
    }
}
