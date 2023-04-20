package com.example.mimenu.ui.llamar;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class LlamarViewModel extends AndroidViewModel {
    private Context context;

    //String, número de teléfono puede contener caracteres que no son numeros como guiones o espacios
    private MutableLiveData<String> numero= new MutableLiveData<>();

    public LlamarViewModel(@NonNull Application application) {
        super(application);
        this.context=application.getApplicationContext();
    }

    public LiveData<String> getNumero() {
        if(numero==null){
            this.numero=new MutableLiveData<>();
        }

        return numero;
    }

    public void setNumero(String numero) {
        if (numero.matches("^[\\d -]{3,20}$")) {
            this.numero.setValue(numero);
        } else {
            Toast.makeText(context, "Ingrese un numero valido", Toast.LENGTH_SHORT).show();
        }
    }
}