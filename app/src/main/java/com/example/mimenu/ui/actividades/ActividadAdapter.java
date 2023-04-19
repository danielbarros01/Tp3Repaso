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

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
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

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaCadena = sdf.format(actividades.get(position).getFecha());
        holder.fecha.setText(fechaCadena);

        //Para obtener la hora con solo hora y minutos-------------------
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date hora = actividades.get(position).getHora();
        String horaYMinutos = dateFormat.format(hora);

        holder.hora.setText(horaYMinutos);
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
