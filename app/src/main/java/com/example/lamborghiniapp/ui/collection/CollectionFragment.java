package com.example.lamborghiniapp.ui.collection;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lamborghiniapp.Car;
import com.example.lamborghiniapp.CollectionListAdapter;
import com.example.lamborghiniapp.R;
import com.example.lamborghiniapp.databinding.CollectionFragmentBinding;
import com.example.lamborghiniapp.databinding.MainFragmentBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CollectionFragment extends Fragment {
    private CollectionViewModel cViewModel;
    private CollectionFragmentBinding binding;
    private CollectionListAdapter adapter;

    public static CollectionFragment newInstance() {
        return new CollectionFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = CollectionFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    private void clearFields() {
        binding.carName.setText("");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        cViewModel = new ViewModelProvider(this).get(CollectionViewModel.class);
        super.onActivityCreated(savedInstanceState);
        listenerSetup();
        observerSetup();
        recyclerSetup();
    }

    private void listenerSetup() {
        binding.deleteCarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> validModelNames = new ArrayList<>();
                validModelNames.add("Centenario");
                validModelNames.add("Sian");
                validModelNames.add("Aventador");
                validModelNames.add("Huracan");

                String name = binding.carName.getText().toString().trim();

                if (!name.equals("") && validModelNames.contains(name)) {
                    cViewModel.deleteCarFromCollection(name);
                    clearFields();
                    Toast.makeText(getContext(), "Lamborghini " + name + " was successfully removed from your collection", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Please enter a valid Model Name", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.carName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.carName.getText().toString().equals("Model Name"))
                    binding.carName.setText("");
            }
        });
    }

    private void observerSetup() {
        cViewModel.getYourCars().observe(getViewLifecycleOwner(),
                new Observer<List<Car>>() {
                    @Override
                    public void onChanged(@Nullable final List<Car> yourCars) {
                        adapter.setCarList(yourCars);
                    }
                });
    }

    private void recyclerSetup() {
        adapter = new CollectionListAdapter(R.layout.collection_list_item);
        binding.carRecycler.setLayoutManager(
                new LinearLayoutManager(getContext()));
        binding.carRecycler.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}