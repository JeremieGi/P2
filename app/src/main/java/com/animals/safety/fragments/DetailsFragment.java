package com.animals.safety.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;

import com.animals.safety.R;
import com.animals.safety.data.Animal;
import com.animals.safety.databinding.FragmentDetailsBinding;

public class DetailsFragment extends Fragment {

    public static final String KEY_ANIMAL = "ANIMAL";

    private FragmentDetailsBinding binding;

    private Animal getAnimal() {
        return (Animal) getArguments().getSerializable(KEY_ANIMAL);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.imageViewAvatar.setImageDrawable(AppCompatResources.getDrawable(getContext(), getAnimal().getBreed().getCover()));
        binding.textViewName.setText(getAnimal().getName());
        binding.textViewAge.setText(getString(R.string.value_age, String.valueOf(getAnimal().getAge())));
        binding.textViewWeight.setText(getString(R.string.value_weight, String.valueOf(getAnimal().getWeight())));
        binding.textViewHeight.setText(getString(R.string.value_height, String.valueOf(getAnimal().getHeight())));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}