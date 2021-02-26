package com.example.readtracker.databases.daoses;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.readtracker.databases.tables.Books;

import java.util.List;

@Dao
public interface BooksDao {
    @Query("SELECT * FROM books WHERE reading_date IN (:date)")
    List<Books> findBookByDate(String date);

    @Query("SELECT * FROM books as b1 WHERE reading_date IN (SELECT max(reading_date) FROM books as b2 WHERE b2.book_name = b1.book_name)")
    List<Books> getFinalReadingAllBooks();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Books... books);
}
