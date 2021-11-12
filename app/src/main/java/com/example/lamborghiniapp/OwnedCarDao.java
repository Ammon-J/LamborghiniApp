package com.example.lamborghiniapp;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
@Dao

public interface OwnedCarDao {
    @Insert // Insert into OwnedCars table
    void addCar(OwnedCars newCar);
    @Query("SELECT * FROM OwnedCars WHERE ModelName = :modelName")
    List<OwnedCars> findYourCar(String modelName);
    @Query("DELETE FROM OwnedCars WHERE ModelName = :modelName")
    void deleteYourCar(String modelName);
    @Query("SELECT * FROM OwnedCars")
    LiveData<List<OwnedCars>> getAllYourCars();
}
