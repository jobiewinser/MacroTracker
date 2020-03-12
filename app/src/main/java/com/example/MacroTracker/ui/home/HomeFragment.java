package com.example.MacroTracker.ui.home;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.MacroTracker.MainActivity;
import com.example.MacroTracker.R;

import static android.content.Context.MODE_PRIVATE;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private static final String MACRO_COUNT = "Macro prefs";

    private HomeViewModel homeViewModel;
    SharedPreferences settings;
    SharedPreferences.Editor prefEditor;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        settings = getActivity().getSharedPreferences(MACRO_COUNT, MODE_PRIVATE);
        prefEditor = settings.edit();

        final TextView calCount = root.findViewById(R.id.text_calories);
        final TextView proCount = root.findViewById(R.id.text_protein);

        //Create your buttons and set their onClickListener to "this"
        Button b1 = root.findViewById(R.id.plus1C);
        b1.setOnClickListener(this);
        Button b2 = root.findViewById(R.id.plus10C);
        b2.setOnClickListener(this);
        Button b3 = root.findViewById(R.id.plus100C);
        b3.setOnClickListener(this);
        Button b4 = root.findViewById(R.id.plus1000C);
        b4.setOnClickListener(this);
        Button b5 = root.findViewById(R.id.minus1C);
        b5.setOnClickListener(this);
        Button b6 = root.findViewById(R.id.minus10C);
        b6.setOnClickListener(this);
        Button b7 = root.findViewById(R.id.minus100C);
        b7.setOnClickListener(this);
        Button b8 = root.findViewById(R.id.minus1000C);
        b8.setOnClickListener(this);
        Button b9 = root.findViewById(R.id.plus1P);
        b9.setOnClickListener(this);
        Button b10 = root.findViewById(R.id.plus10P);
        b10.setOnClickListener(this);
        Button b11 = root.findViewById(R.id.plus100P);
        b11.setOnClickListener(this);
        Button b12 = root.findViewById(R.id.plus1000P);
        b12.setOnClickListener(this);
        Button b13 = root.findViewById(R.id.minus1P);
        b13.setOnClickListener(this);
        Button b14 = root.findViewById(R.id.minus10P);
        b14.setOnClickListener(this);
        Button b15 = root.findViewById(R.id.minus100P);
        b15.setOnClickListener(this);
        Button b16 = root.findViewById(R.id.minus1000P);
        b16.setOnClickListener(this);


        calCount.setText(String.format(getString(R.string.calorie_display_english), settings.getInt("Calories",0)));
        proCount.setText(String.format(getString(R.string.protein_display_english), settings.getInt("Protein",0)));
        return root;
    }
    //implement the onClick method here
    public void onClick(View v) {
        Integer cValue = 0;
        Integer pValue = 0;
        // Perform action on click
        switch(v.getId()) {
            case R.id.plus1C:
                cValue = 1;
                break;
            case R.id.plus10C:
                cValue = 10;
                break;
            case R.id.plus100C:
                cValue = 100;
                break;
            case R.id.plus1000C:
                cValue = 1000;
                break;
            case R.id.minus1C:
                cValue = -1;
                break;
            case R.id.minus10C:
                cValue = -10;
                break;
            case R.id.minus100C:
                cValue = -100;
                break;
            case R.id.minus1000C:
                cValue = -1000;
                break;
            case R.id.plus1P:
                pValue = 1;
                break;
            case R.id.plus10P:
                pValue = 10;
                break;
            case R.id.plus100P:
                pValue = 100;
                break;
            case R.id.plus1000P:
                pValue = 1000;
                break;
            case R.id.minus1P:
                pValue = -1;
                break;
            case R.id.minus10P:
                pValue = -10;
                break;
            case R.id.minus100P:
                pValue = -100;
                break;
            case R.id.minus1000P:
                pValue = -1000;
                break;
        }
        prefEditor.putInt("Calories", settings.getInt("Calories",0) + cValue);
        prefEditor.putInt("Protein", settings.getInt("Protein",0) + pValue);
        prefEditor.commit();
        TextView calCount = getView().findViewById(R.id.text_calories);
        TextView proCount = getView().findViewById(R.id.text_protein);
        calCount.setText(String.format(getString(R.string.calorie_display_english), settings.getInt("Calories",0)));
        proCount.setText(String.format(getString(R.string.protein_display_english), settings.getInt("Protein",0)));
    }
}
