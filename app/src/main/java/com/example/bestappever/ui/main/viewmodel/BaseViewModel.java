package com.example.bestappever.ui.main.viewmodel;

import android.app.Application;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.bestappever.ui.main.AccDatabase;
import com.example.bestappever.ui.main.AccelerationInformation;
import com.example.bestappever.ui.main.DBApplication;

public abstract class BaseViewModel extends AndroidViewModel {

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    public AccDatabase getDatabase() {
        return ((DBApplication)getApplication()).getAccDatabase();
    }
}
