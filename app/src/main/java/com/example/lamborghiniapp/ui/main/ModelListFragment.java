package com.example.lamborghiniapp.ui.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lamborghiniapp.Car;
import com.example.lamborghiniapp.R;
import com.example.lamborghiniapp.databinding.ModelListFragmentBinding;

import java.util.List;

public class ModelListFragment extends Fragment {
    private ModelListViewModel mViewModel;
    private ModelListFragmentBinding binding;

    public static ModelListFragment newInstance() {
        return new ModelListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = ModelListFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ModelListViewModel.class);
        listenerSetup();
        observerSetup();
    }

    private void observerSetup() {
        mViewModel.getAllCars().observe(getViewLifecycleOwner(),
                new Observer<List<Car>>() {
                    @Override
                    public void onChanged(@Nullable final List<Car> allCars) {
                        if(allCars.size() == 0) {
                            Car centenario = new Car("Centenario", 1_900_000.00, 770, "Gasoline V12", 217, 2.8, false);
                            Car sian = new Car("Sian", 3_700_000.00, 774, "Hybrid V12", 217, 2.7, false);
                            Car aventador = new Car("Aventador", 350_000.00, 730, "Gasoline V12", 217, 2.9, false);
                            Car huracan = new Car("Huracan", 209_000.00, 620,"Gasoline V10", 200, 3.2, false);
                            allCars.add(centenario);
                            allCars.add(sian);
                            allCars.add(aventador);
                            allCars.add(huracan);
                            mViewModel.insertCarIntoDb(centenario);
                            mViewModel.insertCarIntoDb(sian);
                            mViewModel.insertCarIntoDb(aventador);
                            mViewModel.insertCarIntoDb(huracan);
                        }
                    }
                });
    }

    private void listenerSetup() {
        binding.centenarioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.addCarToCollection("Centenario");
                Toast.makeText(getContext(), "Lamborghini Centenario was successfully added to your collection", Toast.LENGTH_SHORT).show();
            }
        });
        binding.sianBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.addCarToCollection("Sian");
                Toast.makeText(getContext(), "Lamborghini Sián was successfully added to your collection", Toast.LENGTH_SHORT).show();
            }
        });
        binding.aventadorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.addCarToCollection("Aventador");
                Toast.makeText(getContext(), "Lamborghini Aventador was successfully added to your collection", Toast.LENGTH_SHORT).show();
            }
        });
        binding.huracanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.addCarToCollection("Huracan");
                Toast.makeText(getContext(), "Lamborghini Huracán was successfully added to your collection", Toast.LENGTH_SHORT).show();
            }
        });
    }
}