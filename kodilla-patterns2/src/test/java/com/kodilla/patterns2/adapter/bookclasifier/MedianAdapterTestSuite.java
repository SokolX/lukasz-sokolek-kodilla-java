package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MedianAdapterTestSuite {

    @Test
    void publicationYearMedianTest() {
        //Given
        Set<Book> books = new HashSet<>();
        books.add(new Book("Author1", "Title1", 1989, "198901"));
        books.add(new Book("Author2", "Title2", 2010, "201001"));
        books.add(new Book("Author3", "Title3", 2022, "202201"));
        books.add(new Book("Author4", "Title4", 1950, "195001"));
        books.add(new Book("Author5", "Title5", 1951, "195101"));
        books.add(new Book("Author6", "Title6", 1953, "195301"));
        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        int medianPublicationYear = medianAdapter.publicationYearMedian(books);

        //Then
        assertEquals(1989, medianPublicationYear);
    }
}