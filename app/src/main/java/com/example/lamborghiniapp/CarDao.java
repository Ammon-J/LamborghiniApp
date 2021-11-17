package com.example.lamborghiniapp;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
@Dao

public interface CarDao {
    @Insert // Insert into OwnedCars table
    void addCar(Car newCar);
    @Query("UPDATE Cars SET IsCarOwned = :isCarOwned WHERE ModelName = :modelName")
    void removeCarAsOwned(String modelName, boolean isCarOwned);
    @Query("SELECT * FROM Cars WHERE IsCarOwned = :isCarOwned")
    LiveData<List<Car>> getYourCars(boolean isCarOwned);
    @Query(("UPDATE Cars SET IsCarOwned = :isCarOwned WHERE ModelName = :modelName"))
    void markCarAsOwned(String modelName, boolean isCarOwned);
}
