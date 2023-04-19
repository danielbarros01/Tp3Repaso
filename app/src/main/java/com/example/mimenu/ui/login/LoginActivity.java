package com.example.mimenu.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mimenu.MainActivity;
import com.example.mimenu.databinding.ActivityLoginBinding;
import com.example.mimenu.modelo.User;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private LoginActivityViewModel viewModel;
    private TextView email, password;
    private Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(LoginActivityViewModel.class);

        configView();

        viewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                Intent iniciar = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(iniciar);
            }
        });
    }

    private void configView(){
        email = binding.etEmail;
        password = binding.etPass;
        btnEntrar = binding.btnEntrar;

        btnEntrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                User user = new User(email.getText().toString(), password.getText().toString());
                viewModel.validarDatos(user);
            }
        });
    }
}