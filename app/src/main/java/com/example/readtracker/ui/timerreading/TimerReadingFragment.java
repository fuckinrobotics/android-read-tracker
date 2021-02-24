package com.example.readtracker.ui.timerreading;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.readtracker.R;
import com.example.readtracker.viewmodel.timerreading.TimerReadingViewModel;

public class TimerReadingFragment extends Fragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button buttonStartTimer = view.findViewById(R.id.button_startTimer);
        Button buttonSaveBook = view.findViewById(R.id.button_saveBook);
        EditText editNameBook = view.findViewById(R.id.plain_text_nameBook);
        EditText editNumberPages = view.findViewById(R.id.plain_text_numberPages);
        TextView textViewNameBook = view.findViewById(R.id.textView_nameBook);
        TextView textViewNumberPages = view.findViewById(R.id.textView_numberPages);
        buttonSaveBook.setOnClickListener(v -> {
            editNameBook.setVisibility(View.GONE);
            editNumberPages.setVisibility(View.GONE);
            textViewNameBook.setVisibility(View.GONE);
            buttonSaveBook.setVisibility(View.GONE);
            textViewNumberPages.setVisibility(View.GONE);
            buttonStartTimer.setVisibility(View.VISIBLE);
        });
        Chronometer chronometerTimerReading = view.findViewById(R.id.chronometerTimerReading);
chronometerTimerReading.setFormat("%s");

        chronometerTimerReading.setOnClickListener(v -> {
            editNameBook.setVisibility(View.VISIBLE);
            editNumberPages.setVisibility(View.VISIBLE);
            textViewNameBook.setVisibility(View.VISIBLE);
            buttonSaveBook.setVisibility(View.VISIBLE);
            textViewNumberPages.setVisibility(View.VISIBLE);
            chronometerTimerReading.stop();
            chronometerTimerReading.setVisibility(View.GONE);
        });
        buttonStartTimer.setOnClickListener(v -> {
           buttonStartTimer.setVisibility(View.GONE);
           chronometerTimerReading.setVisibility(View.VISIBLE);
           chronometerTimerReading.setBase(SystemClock.elapsedRealtime());
           chronometerTimerReading.start();
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.timer_reading_fragment, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TimerReadingViewModel model = new ViewModelProvider(this).get(TimerReadingViewModel.class);
        /* model.getUsers().observe(this, users -> {
            // update UI
        });*/
    }
}