package com.example.bestappever.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        final TextView textView2 = v.findViewById(R.id.textView2);

        accViewModel.getAccelerationData().observe(getViewLifecycleOwner(), (accelerationInformation) -> {
                    textView2.setText("x: " + accelerationInformation.get(0).getX() + " y: "
                            + accelerationInformation.get(0).getY() + " z: "
                            +accelerationInformation.get(0).getZ());
        });
        return v;
    }
}
