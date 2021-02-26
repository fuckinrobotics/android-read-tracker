package com.example.readtracker.app;

import android.app.Application;

import com.example.readtracker.databases.workingmethods.BooksWorkingMethods;

public class ReadTrackerApp extends Application {
    public static ReadTrackerApp instance;

    private BooksWorkingMethods repo;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        repo = new BooksWorkingMethods(this);
    }

    public static ReadTrackerApp getInstance() {
        return instance;
    }

    public BooksWorkingMethods getRepo() {
        return repo;
    }
}

