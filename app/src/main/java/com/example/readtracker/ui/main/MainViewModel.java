package com.example.readtracker.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    LiveData<String> data;

    public LiveData<String> getData() {
        if (data == null) {
         //   data = dataRepository.loadData();
        }
        return data;
    }
}