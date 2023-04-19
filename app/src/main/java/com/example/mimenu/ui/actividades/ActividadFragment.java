package com.example.mimenu.ui.actividades;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mimenu.R;
import com.example.mimenu.databinding.FragmentActividadBinding;
import com.example.mimenu.databinding.FragmentSlideshowBinding;
import com.example.mimenu.modelo.Actividad;

import java.util.ArrayList;

public class ActividadFragment extends Fragment {

    private ActividadViewModel viewModel;
    private FragmentActividadBinding binding;

    public static ActividadFragment newInstance() {
        return new ActividadFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentActividadBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(ActividadViewModel.class);
        // TODO: Use the ViewModel

        RecyclerView rv = binding.rvLista;
        GridLayoutManager grilla = new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false);
        rv.setLayoutManager(grilla);

        viewModel.getActividades().observe(this, new Observer<ArrayList<Actividad>>() {
            @Override
            public void onChanged(ArrayList<Actividad> actividades) {
                ActividadAdapter adapter = new ActividadAdapter(getContext(), actividades, getLayoutInflater());
                rv.setAdapter(adapter);
            }
        });
    }

}