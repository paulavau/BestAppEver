package com.example.bestappever.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bestappever.R;
import com.example.bestappever.ui.main.viewmodel.BaseViewModel;

public class StartScreenFragment extends Fragment {

    private BaseViewModel mViewModel;

    public static StartScreenFragment newInstance() {
        return new StartScreenFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_start_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final NavController controller = Navigation.findNavController(view);
        view.findViewById(R.id.accg).setOnClickListener(button -> {
            controller.navigate(
                    StartScreenFragmentDirections
                            .actionStartScreenFragmentToAccFragment("Acceleration without g"));
        });
    }
}