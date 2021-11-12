package com.example.lamborghiniapp.ui.main;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.lamborghiniapp.Car;
import com.example.lamborghiniapp.CarRepository;
import com.example.lamborghiniapp.OwnedCars;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private CarRepository repository;
    private LiveData<List<OwnedCars>> allOwnedCars;
    private MutableLiveData<List<OwnedCars>> searchResults;

    public MainViewModel(Application application) {
        super(application);
        repository = new CarRepository(application);
        allOwnedCars = repository.getAllOwnedCars();
        searchResults = repository.getSearchResults();
    }

    MutableLiveData<List<OwnedCars>> getSearchResults(){ return searchResults; }
    LiveData<List<OwnedCars>> getAllOwnedCars() { return allOwnedCars; }
    public void addCarToCollection(Car car){ repository.addCarToCollection(car); }
    public void deleteCarFromCollection(OwnedCars ownedCar) { repository.deleteCarFromCollection(ownedCar.getModelName()); }
}