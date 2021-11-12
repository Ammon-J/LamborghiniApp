package com.example.lamborghiniapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
@Dao

public interface CarDao {
    @Insert // Insert into Cars table
    void insertCar(Car car);
    @Query("SELECT * FROM Cars WHERE ModelName = :modelName")
    List<Car> findCar(String modelName);
    @Query("DELETE FROM Cars WHERE ModelName = :modelName")
    void deleteCar(String modelName);
    @Query("SELECT * FROM Cars")
    LiveData<List<Car>> getAllCars();
}
