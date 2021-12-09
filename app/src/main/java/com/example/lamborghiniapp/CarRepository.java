package com.example.lamborghiniapp;

import androidx.lifecycle.LiveData;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import androidx.lifecycle.MutableLiveData;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import android.app.Application;

public class CarRepository {
    private final MutableLiveData<List<Car>> searchResults =
            new MutableLiveData<>();
    private List<Car> results;
    private final LiveData<List<Car>> yourCars;
    private final LiveData<List<Car>> allCars;
    private final CarDao carDao;

    public CarRepository(Application application) {
        CarRoomDatabase db;
        db = CarRoomDatabase.getDatabase(application);
        carDao = db.CarDao();
        yourCars = carDao.getYourCars(true); // pass in true to get all the owned cars
        allCars = carDao.getAllCars();
    }

    public void insertCarIntoDb(Car car) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            carDao.insertCarIntoDb(car);
        });
        executor.shutdown();
    }

    public int deleteCarFromDb(String modelName) {
        AtomicInteger rows = new AtomicInteger();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            rows.set(carDao.deleteCarFromDb(modelName));
        });
        executor.shutdown();
        return rows.get();
    }

    public void addCarToCollection(String modelName) { // Add a car to your car collection
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            carDao.markCarAsOwnedOrRemove(modelName, true);
        });
        executor.shutdown();
    }

    public void deleteCarFromCollection(String modelName) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            carDao.markCarAsOwnedOrRemove(modelName, false); // Only delete a car from your car collection
        });
        executor.shutdown();
    }

    Handler handler = new Handler(Looper.getMainLooper()) {
        @Override public void handleMessage(Message msg) {
            searchResults.setValue(results);
        }
    };

    public LiveData<List<Car>> getYourCars() {
        return yourCars;
    }
    public LiveData<List<Car>> getAllCars() { return allCars; }
    public MutableLiveData<List<Car>> getSearchResults() {
        return searchResults;
    }
}
