package com.example.readtracker.databases.appdatabases;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.readtracker.databases.daoses.BooksDao;
import com.example.readtracker.databases.tables.Books;

@Database(entities = {Books.class}, version = 1)
public abstract class AppDatabaseBooks extends RoomDatabase {
    public abstract BooksDao getBooksDao();
}