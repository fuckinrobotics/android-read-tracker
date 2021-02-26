package com.example.readtracker.databases.workingmethods;

import android.content.Context;

import androidx.room.Room;

import com.example.readtracker.databases.appdatabases.AppDatabaseBooks;
import com.example.readtracker.databases.tables.Books;

import java.util.ArrayList;
import java.util.List;

public class BooksWorkingMethods {
    private final AppDatabaseBooks db;
    private final Context applicationContext;

    public BooksWorkingMethods(Context inputContext) {
        applicationContext = inputContext;
        db = Room.databaseBuilder(applicationContext, AppDatabaseBooks.class, "books-database")
                .fallbackToDestructiveMigration()
                .build();
    }

    public void saveBook(String nameBook, int numberFinalReadPage, String readingDate){
        Books inputBook = new Books();
        inputBook.bookName = nameBook;
        inputBook.finalPage = numberFinalReadPage;
        inputBook.readingDate = readingDate;
        db.getBooksDao().insert(inputBook);
    }

    public List<String> getNameBooksAndNumberPagesFromDate(String date){
        List<Books> storeBooksByDate = db.getBooksDao().findBookByDate(date);
        List<String> bookAndNumberPageList = new ArrayList<>();
        for(int i = 0; i < storeBooksByDate.size(); i++){
            bookAndNumberPageList.add(storeBooksByDate.get(i).bookName);
            bookAndNumberPageList.add(Integer.toString(storeBooksByDate.get(i).finalPage));
        }
        return bookAndNumberPageList;
    }

    public List<String> getNameBooksAndFinalPages(){
        List<Books> storeBooksSortByFinalPage = db.getBooksDao().getFinalReadingAllBooks();
        List<String> nameBookAndFinalPageList = new ArrayList<>();
        for(int i = 0; i < storeBooksSortByFinalPage.size(); i++){
            nameBookAndFinalPageList.add(storeBooksSortByFinalPage.get(i).bookName);
            nameBookAndFinalPageList.add(Integer.toString(storeBooksSortByFinalPage.get(i).finalPage));
        }
        return nameBookAndFinalPageList;
    }
}
