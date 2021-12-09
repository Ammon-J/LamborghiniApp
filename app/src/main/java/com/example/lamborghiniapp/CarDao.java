package com.example.lamborghiniapp;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao

public interface CarDao {
    @Insert
    void insertCarIntoDb(Car car);
    @Query("DELETE FROM Cars WHERE ModelName = :modelName")
    int deleteCarFromDb(String modelName);
    @Query("SELECT * FROM Cars")
    LiveData<List<Car>> getAllCars();
    @Query(("UPDATE Cars SET IsCarOwned = :isCarOwned WHERE ModelName = :modelName"))
    void markCarAsOwnedOrRemove(String modelName, boolean isCarOwned);
    @Query("SELECT * FROM Cars WHERE IsCarOwned = :isCarOwned")
    LiveData<List<Car>> getYourCars(boolean isCarOwned);
}
