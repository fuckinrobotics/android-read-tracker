package com.example.readtracker.databases.tables;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Books {
    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "book_name")
    public String bookName;

    @ColumnInfo(name = "final_read_page_number")
    public int finalPage;

    @ColumnInfo(name = "reading_date")
    public String readingDate;
}
