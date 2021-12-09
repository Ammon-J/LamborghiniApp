package com.example.lamborghiniapp.ui.main;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.lamborghiniapp.Car;
import com.example.lamborghiniapp.CarRepository;

import java.util.List;

public class ModelListViewModel extends AndroidViewModel {
    private CarRepository repository;
    private LiveData<List<Car>> allOwnedCars;
    private LiveData<List<Car>> allCars;

    public ModelListViewModel(Application application) {
        super(application);
        repository = new CarRepository(application);
        allOwnedCars = repository.getYourCars();
        allCars = repository.getAllCars();
    }

    public void insertCarIntoDb(Car car){ repository.insertCarIntoDb(car); }
    public void addCarToCollection(String modelName){ repository.addCarToCollection(modelName); }
    public LiveData<List<Car>> getYourCars() { return allOwnedCars; }
    public LiveData<List<Car>> getAllCars() { return allCars; }
}