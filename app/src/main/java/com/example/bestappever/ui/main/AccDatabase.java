package com.example.bestappever.ui.main;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.bestappever.ui.main.dao.AccDao;

@Database(entities = {AccelerationInformation.class}, version = 1)
public abstract class AccDatabase extends RoomDatabase {
    public abstract AccDao getAccDao();
}
