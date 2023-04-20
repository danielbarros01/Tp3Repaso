package com.example.mimenu.ui.llamar;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.mimenu.R;
import com.example.mimenu.databinding.FragmentLlamarBinding;
import com.example.mimenu.databinding.FragmentMapaMercadosBinding;
import com.example.mimenu.ui.mapa.MapaMercadosViewModel;

public class LlamarFragment extends Fragment {

    private LlamarViewModel viewModel;
    private FragmentLlamarBinding binding;

    private EditText numero;
    private ImageButton btnLlamar;

    public static LlamarFragment newInstance() {
        return new LlamarFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(LlamarViewModel.class);

        viewModel.getNumero().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String number) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                startActivity(intent);
            }
        });
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentLlamarBinding.inflate(inflater, container, false);
        numero = binding.tvNumero;
        btnLlamar = binding.btnLlamar;

        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.setNumero(binding.tvNumero.getText().toString());
            }
        });
    }
}