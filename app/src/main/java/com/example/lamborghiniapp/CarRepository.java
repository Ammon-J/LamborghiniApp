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
    private final MutableLiveData<List<Car>> searchResults =
            new MutableLiveData<>();
    private List<Car> results;
    private final LiveData<List<Car>> yourCars;
    private final CarDao carDao;

    public CarRepository(Application application) {
        CarRoomDatabase db;
        db = CarRoomDatabase.getDatabase(application);
        carDao = db.CarDao();
        yourCars = carDao.getYourCars(true); // pass in true to get all the owned cars
    }

    public void addCarToCollection(Car car) { // Add a car to your car collection
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            carDao.markCarAsOwned(car.getModelName(), car.getIsCarOwned());
        });
        executor.shutdown();
    }

    public void deleteCarFromCollection(String modelName, boolean isCarOwned) { // Only delete a car from your car collection
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            carDao.removeCarAsOwned(modelName, isCarOwned);
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
    public MutableLiveData<List<Car>> getSearchResults() {
        return searchResults;
    }
}
