package com.example.bestappever.ui.main.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.bestappever.ui.main.AccelerationInformation;

import java.util.ArrayList;
import java.util.List;

@Dao
public abstract class AccDao {

    @Query("SELECT * FROM acceleration")
    public abstract LiveData<List<AccelerationInformation>> getAcceleration();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insert(AccelerationInformation accelerationInformation);
}
