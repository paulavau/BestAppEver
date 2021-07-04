package com.example.bestappever.ui.main;

import android.app.Application;

import androidx.room.Room;

public class DBApplication extends Application {
    private AccDatabase accDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        accDatabase = Room
                .databaseBuilder(this,AccDatabase.class,"bestapp")
                .build();
    }

    public AccDatabase getAccDatabase() {
        return accDatabase;
    }
}
