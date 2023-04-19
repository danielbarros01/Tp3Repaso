package com.example.mimenu.ui.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.service.autofill.UserData;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mimenu.MainActivity;
import com.example.mimenu.modelo.User;

public class LoginActivityViewModel extends AndroidViewModel {
    private Context context;

    private User user;
    private MutableLiveData<User> userData;

    public LoginActivityViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();

        user = new User("danibelgranocab@hotmail.com", "123456");
    }

    public LiveData<User> getUser(){
        if (userData == null) {
            this.userData = new MutableLiveData<>();
        }

        return userData;
    }

    public void validarDatos(User u) {
        if(user != null && user.getEmail().equals(u.getEmail()) && user.getPassword().equals(u.getPassword())){
            userData.setValue(user);
        }else{
            Toast.makeText(context, "Email o contraseña equivocado", Toast.LENGTH_LONG).show();
        }
    }
}
