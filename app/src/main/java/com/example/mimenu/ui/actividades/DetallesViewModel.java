package com.example.mimenu.ui.actividades;

import android.app.Application;

import androidx.annotation.NonNull;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.example.mimenu.modelo.Actividad;

public class DetallesViewModel extends AndroidViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<Actividad> actividad = new MutableLiveData<>();;

    public DetallesViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Actividad> getActividad() {
        if (actividad.getValue() == null) {
            this.actividad = new MutableLiveData<>();
        }

        return actividad;
    }

    public void setActividad(Actividad a) {
        actividad.setValue(a);
    }
}