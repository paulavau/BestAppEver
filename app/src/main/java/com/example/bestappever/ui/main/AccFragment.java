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
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.bestappever.R;
import com.example.bestappever.ui.main.viewmodel.AccViewModel;

public class AccFragment extends Fragment {
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
        View v = inflater.inflate(R.layout.fragment_acc, container, false);
        return v;
    }

    //arg übergabe für Titel unnötig, da statisch
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        TextView accFragmentTitleView = view.findViewById(R.id.textView);

        Bundle args = getArguments();
        AccFragmentArgs accFragmentArgs = null;

        final NavController controller = Navigation.findNavController(view);
        view.findViewById(R.id.monitoring).setOnClickListener(button -> {
            controller.navigate(
                    AccFragmentDirections
                            .actionAccFragmentToMonitoringFragment());
        });

        final NavController controller2 = Navigation.findNavController(view);
        view.findViewById(R.id.back).setOnClickListener(button -> {
            controller2.navigate(
                    AccFragmentDirections
                            .actionAccFragmentToStartScreenFragment());
        });

        accViewModel = new ViewModelProvider(
                this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication())
        ).get(AccViewModel.class);



        final TextView vendor = view.findViewById(R.id.vendor);
        final TextView name = view.findViewById(R.id.name);
        final TextView version = view.findViewById(R.id.version);
        final TextView resolution = view.findViewById(R.id.resolution);
        final TextView maxrange = view.findViewById(R.id.maxrange);
        final TextView power = view.findViewById(R.id.power);
        final TextView xyz = view.findViewById(R.id.xyz);

        accViewModel.accelerationLiveData.observe(getViewLifecycleOwner(), (accelerationInformation) -> {
            vendor.setText("Vendor " + accelerationInformation.getSensor().getVendor());
            name.setText("Name " + accelerationInformation.getSensor().getName());
            version.setText("Version " + accelerationInformation.getSensor().getVersion());
            resolution.setText("Resolution " + accelerationInformation.getSensor().getResolution());
            maxrange.setText("maxRange " + accelerationInformation.getSensor().getMaximumRange());
            power.setText("Power mA " + accelerationInformation.getSensor().getPower());
            xyz.setText(
                    "x: " + accelerationInformation.getX() + " y: " + accelerationInformation.getY() + " z: " + accelerationInformation.getZ()
            );
            insertAccInf(accelerationInformation);
        });

        if (args != null) {
            accFragmentArgs = AccFragmentArgs.fromBundle(args);
        }

        if (accFragmentArgs != null) {
            accFragmentTitleView.setText(accFragmentArgs.getAccFragmentTitle());
        }
    }

    void insertAccInf(AccelerationInformation accelerationInformation) {
        Runnable r = () -> {
            accViewModel.getDatabase().getAccDao().insert(accelerationInformation);
            //System.out.println("X" + accelerationInformation.getX());
        };
        Thread t = new Thread(r);
        t.start();
    }
}
