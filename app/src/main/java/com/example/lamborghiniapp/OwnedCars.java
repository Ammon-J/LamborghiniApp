package com.example.lamborghiniapp;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "OwnedCars")

public class OwnedCars {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "OwnerId")

    private int id;

    @ColumnInfo(name = "modelName")
    private String modelName;

    @ColumnInfo(name = "Price")
    private double price;

    @ColumnInfo(name = "EngineType")
    private String engineType;

    @ColumnInfo(name = "TopSpeed")
    private double topSpeed;

    @ColumnInfo(name = "YearMade")
    private int yearMade;

    public OwnedCars(String modelName, double price, String engineType, double topSpeed, int yearMade) {
        this.modelName = modelName;
        this.price = price;
        this.engineType = engineType;
        this.topSpeed = topSpeed;
        this.yearMade = yearMade;
    }

    public String getModelName() {
        return this.modelName;
    }

    public double getPrice() {
        return this.price;
    }

    public String getEngineType() {
        return this.engineType;
    }

    public double getTopSpeed() {
        return this.topSpeed;
    }

    public int getYearMade() {
        return this.yearMade;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public void setTopSpeed(double topSpeed) {
        this.topSpeed = topSpeed;
    }

    public void setYearMade(int yearMade) {
        this.yearMade = yearMade;
    }
}
