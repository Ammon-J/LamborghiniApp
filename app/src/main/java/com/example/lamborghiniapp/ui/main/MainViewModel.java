package com.example.lamborghiniapp.ui.main;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.lamborghiniapp.Car;
import com.example.lamborghiniapp.CarRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private CarRepository repository;
    private LiveData<List<Car>> allOwnedCars;
    private MutableLiveData<List<Car>> searchResults;

    public MainViewModel(Application application) {
        super(application);
        repository = new CarRepository(application);
        allOwnedCars = repository.getYourCars();
        searchResults = repository.getSearchResults();
    }

    MutableLiveData<List<Car>> getSearchResults(){ return searchResults; }
    LiveData<List<Car>> getYourCars() { return allOwnedCars; }
    public void addCarToCollection(Car car){ repository.addCarToCollection(car); }
    public void deleteCarFromCollection(Car car) { repository.deleteCarFromCollection(car.getModelName(), false); }
}