package com.example.lamborghiniapp;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Car.class}, version = 1)

public abstract class CarRoomDatabase extends RoomDatabase{
    public abstract CarDao CarDao();
    private static CarRoomDatabase INSTANCE;
    static CarRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CarRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE =
                            Room.databaseBuilder(context.getApplicationContext(),
                                    CarRoomDatabase.class,
                                    "Lamborghini_Database").build();
                }
            }
        }
        return INSTANCE;
    }
}
