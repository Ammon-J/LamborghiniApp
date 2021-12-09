package com.example.lamborghiniapp;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Cars")

public class Car {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "CarId")
    private int id;

    @ColumnInfo(name = "HorsePower")
    private int horsePower;

    @ColumnInfo(name = "IsCarOwned")
    private boolean isCarOwned;

    @ColumnInfo(name = "ModelName")
    private String modelName;

    @ColumnInfo(name = "Price")
    private double price;

    @ColumnInfo(name = "EngineType")
    private String engineType;

    @ColumnInfo(name = "TopSpeed")
    private double topSpeed;

    @ColumnInfo(name = "ZeroToSixty")
    private double zeroToSixty;

    public Car(String modelName, double price, int horsePower, String engineType, double topSpeed, double zeroToSixty, boolean isCarOwned) {
        this.modelName = modelName;
        this.price = price;
        this.engineType = engineType;
        this.horsePower = horsePower;
        this.topSpeed = topSpeed;
        this.zeroToSixty = zeroToSixty;
        this.isCarOwned = isCarOwned;
    }
    public int getId() {
        return this.id;
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

    public int getHorsePower() {
        return this.horsePower;
    }

    public double getTopSpeed() {
        return this.topSpeed;
    }

    public double getZeroToSixty() {
        return this.zeroToSixty;
    }

    public boolean getIsCarOwned() { return this.isCarOwned; }

    public void setId(int id) {
        this.id = id;
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

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setTopSpeed(double topSpeed) {
        this.topSpeed = topSpeed;
    }

    public void setZeroToSixty(int yearMade) {
        this.zeroToSixty = zeroToSixty;
    }

    public void setIsCarOwned(boolean isCarOwned) { this.isCarOwned = isCarOwned;}
}
