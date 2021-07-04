package com.example.bestappever.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bestappever.R;
import com.example.bestappever.ui.main.viewmodel.AccViewModel;
import com.example.bestappever.ui.main.viewmodel.BaseViewModel;

public class MonitoringFragment extends Fragment {
    private AccViewModel accViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        accViewModel = new ViewModelProvider(
                getActivity(),
                ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication())
        ).get(AccViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_monitoring,container,false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final TextView textView2 = view.findViewById(R.id.textView2);
        final TextView textView3 = view.findViewById(R.id.textView3);
        final TextView textView4 = view.findViewById(R.id.textView4);
        final TextView textView5 = view.findViewById(R.id.textView5);
        final TextView textView6 = view.findViewById(R.id.textView6);
        final TextView textView7 = view.findViewById(R.id.textView7);
        final TextView textView8 = view.findViewById(R.id.textView8);
        final TextView textView9 = view.findViewById(R.id.textView9);
        final TextView textView10 = view.findViewById(R.id.textView10);
        final TextView textView11 = view.findViewById(R.id.textView11);


        accViewModel.getAccelerationData().observe(getViewLifecycleOwner(), (accelerationInformation) -> {
            textView2.setText("x: " + accelerationInformation.get(0).getX() + " y: "
                    + accelerationInformation.get(0).getY() + " z: "
                    +accelerationInformation.get(0).getZ());
        });
        accViewModel.getAccelerationData().observe(getViewLifecycleOwner(), (accelerationInformation) -> {
            textView3.setText("x: " + accelerationInformation.get(1).getX() + " y: "
                    + accelerationInformation.get(1).getY() + " z: "
                    +accelerationInformation.get(1).getZ());
        });
        accViewModel.getAccelerationData().observe(getViewLifecycleOwner(), (accelerationInformation) -> {
            textView4.setText("x: " + accelerationInformation.get(2).getX() + " y: "
                    + accelerationInformation.get(2).getY() + " z: "
                    +accelerationInformation.get(2).getZ());
        });
        accViewModel.getAccelerationData().observe(getViewLifecycleOwner(), (accelerationInformation) -> {
            textView5.setText("x: " + accelerationInformation.get(3).getX() + " y: "
                    + accelerationInformation.get(3).getY() + " z: "
                    +accelerationInformation.get(3).getZ());
        });
        accViewModel.getAccelerationData().observe(getViewLifecycleOwner(), (accelerationInformation) -> {
            textView6.setText("x: " + accelerationInformation.get(4).getX() + " y: "
                    + accelerationInformation.get(4).getY() + " z: "
                    +accelerationInformation.get(4).getZ());
        });
        accViewModel.getAccelerationData().observe(getViewLifecycleOwner(), (accelerationInformation) -> {
            textView7.setText("x: " + accelerationInformation.get(5).getX() + " y: "
                    + accelerationInformation.get(5).getY() + " z: "
                    +accelerationInformation.get(5).getZ());
        });
        accViewModel.getAccelerationData().observe(getViewLifecycleOwner(), (accelerationInformation) -> {
            textView8.setText("x: " + accelerationInformation.get(6).getX() + " y: "
                    + accelerationInformation.get(6).getY() + " z: "
                    +accelerationInformation.get(6).getZ());
        });
        accViewModel.getAccelerationData().observe(getViewLifecycleOwner(), (accelerationInformation) -> {
            textView9.setText("x: " + accelerationInformation.get(7).getX() + " y: "
                    + accelerationInformation.get(7).getY() + " z: "
                    +accelerationInformation.get(7).getZ());
        });
        accViewModel.getAccelerationData().observe(getViewLifecycleOwner(), (accelerationInformation) -> {
            textView10.setText("x: " + accelerationInformation.get(8).getX() + " y: "
                    + accelerationInformation.get(8).getY() + " z: "
                    +accelerationInformation.get(8).getZ());
        });
        accViewModel.getAccelerationData().observe(getViewLifecycleOwner(), (accelerationInformation) -> {
            textView11.setText("x: " + accelerationInformation.get(9).getX() + " y: "
                    + accelerationInformation.get(9).getY() + " z: "
                    +accelerationInformation.get(9).getZ());
        });
    }
}
