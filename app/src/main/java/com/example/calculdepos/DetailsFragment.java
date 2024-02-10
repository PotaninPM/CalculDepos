package com.example.calculdepos;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class DetailsFragment extends Fragment {


    public DetailsFragment() {
        
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Button btn_1 = view.findViewById(R.id.button1);

        EditText ed1 = view.findViewById(R.id.editTextNumber);
        EditText ed2 = view.findViewById(R.id.editTextNumber2);
        EditText ed3 = view.findViewById(R.id.editTextNumber3);

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amount = ed1.getText().toString();
                String percent = ed2.getText().toString();
                String month = ed3.getText().toString();

                double amount1 = Double.parseDouble(amount);
                double percent1 = Double.parseDouble(percent) / 100.0;
                int month1 = Integer.parseInt(month);

                double finalA = amount1 * Math.pow(1 + (percent1 / 12), month1);

                int result = (int) finalA;

                Bundle bundle = new Bundle();
                bundle.putString("param1", String.valueOf(result));
                Navigation.findNavController(requireView()).navigate(R.id.action_detailsFragment_to_resFragment, bundle);
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);
    }
}