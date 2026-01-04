package com.example.zomatoclone;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ProfileFragment extends Fragment {

    Button btnLogout;

    public ProfileFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        btnLogout = v.findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(view -> {
            SharedPreferences prefs = requireActivity().getSharedPreferences("user_prefs", requireActivity().MODE_PRIVATE);
            prefs.edit().clear().apply();

            startActivity(new Intent(requireActivity(), LoginActivity.class));
            requireActivity().finish();
        });

        return v;
    }
}
