package com.example.mimenu.ui.actividades;

import android.app.Application;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mimenu.modelo.Actividad;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ActividadViewModel extends AndroidViewModel {

    ArrayList<Actividad> lista = new ArrayList<>();
    private MutableLiveData<ArrayList<Actividad>> actividades;


    public ActividadViewModel(@NonNull Application application) {
        super(application);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 10);
        cal.set(Calendar.MINUTE, 30);
        Date hora = cal.getTime();

        lista.add(new Actividad("Ir al gimnasio", "Tengo que hacer pesas y cardio", new Date(), hora));
        lista.add(new Actividad("Ir al cine", "Ver la última película de acción", new Date(), hora));
        lista.add(new Actividad("Comprar comestibles", "Ir al supermercado y comprar comida para la semana", new Date(), hora));
        lista.add(new Actividad("Hacer una llamada", "Llamar a mi amigo para ponerme al día", new Date(), hora));
        lista.add(new Actividad("Leer un libro", "Terminar el libro que empecé la semana pasada", new Date(), hora));
        lista.add(new Actividad("Ir al parque", "Hacer una caminata y disfrutar del aire libre", new Date(), hora));

        actividades.setValue(lista);
    }

    public LiveData<ArrayList<Actividad>> getActividades() {
        if (actividades.getValue() == null) {
            this.actividades = new MutableLiveData<>();
        }

        return actividades;
    }
}