package com.example.lamborghiniapp;

import androidx.lifecycle.LiveData;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import androidx.lifecycle.MutableLiveData;
import java.util.List;
import android.app.Application;

public class CarRepository {
    private final MutableLiveData<List<OwnedCars>> searchResults =
            new MutableLiveData<>();
    private List<OwnedCars> results;
    private final LiveData<List<Car>> allCars;
    private final LiveData<List<OwnedCars>> allOwnedCars;
    private final CarDao CarDao;
    private final OwnedCarDao OwnedCarDao;

    public CarRepository(Application application) {
        CarRoomDatabase db;
        db = CarRoomDatabase.getDatabase(application);
        CarDao = (com.example.lamborghiniapp.CarDao) db.CarDao();
        allCars = CarDao.getAllCars();
        OwnedCarDao = (com.example.lamborghiniapp.OwnedCarDao) db.CarDao();
        allOwnedCars = OwnedCarDao.getAllYourCars();
    }

    public void insertCar(Car car) { // Insert a car into the database
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            CarDao.insertCar(car);
        });
        executor.shutdown();
    }

    public void addCarToCollection(Car newCar) { // Add a car to your car collection
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            CarDao.insertCar(newCar);
        });
        executor.shutdown();
    }

    public void deleteCarFromCollection(String modelName) { // Only delete a car from your car collection
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            OwnedCarDao.deleteYourCar(modelName);
        });
        executor.shutdown();
    }

    Handler handler = new Handler(Looper.getMainLooper()) {
        @Override public void handleMessage(Message msg) {
            searchResults.setValue(results);
        }
    };

    public LiveData<List<OwnedCars>> getAllOwnedCars() {
        return allOwnedCars;
    }
    public MutableLiveData<List<OwnedCars>> getSearchResults() {
        return searchResults;
    }
}
