package com.example.lamborghiniapp.ui.collection;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.lamborghiniapp.Car;
import com.example.lamborghiniapp.CarRepository;

import java.util.List;

public class CollectionViewModel extends AndroidViewModel {
    private CarRepository repository;
    private LiveData<List<Car>> allOwnedCars;
    private LiveData<List<Car>> allCars;
    private MutableLiveData<List<Car>> searchResults;

    public CollectionViewModel(Application application) {
        super(application);
        repository = new CarRepository(application);
        allOwnedCars = repository.getYourCars();
        searchResults = repository.getSearchResults();
        allCars = repository.getAllCars();
    }

    MutableLiveData<List<Car>> getSearchResults(){ return searchResults; }
    public LiveData<List<Car>> getYourCars() { return allOwnedCars; }
    public LiveData<List<Car>> getAllCars() { return allCars; }
    public void addCarToCollection(String modelName){ repository.addCarToCollection(modelName); }
    public void deleteCarFromCollection(String modelName) { repository.deleteCarFromCollection(modelName); }
    public void insertCarIntoDb(Car car){ repository.insertCarIntoDb(car); }
    public int deleteCarFromDb(String modelName) { return repository.deleteCarFromDb(modelName); }
}