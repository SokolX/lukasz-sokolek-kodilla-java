package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //given
        Library library = new Library("Library");
        library.getBooks().add(new Book("Secrets of Alamo", "John Smith", LocalDate.of(2008,1,1)));

        Library shallowClonedLibrary = null;
        try {
            shallowClonedLibrary = library.shallowCopy();
            shallowClonedLibrary.setName("Library shallow");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Library deep");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        //when
        library.getBooks().add(new Book("Secrets of Java", "Ian Tenewitch", LocalDate.of(2010,1,1)));

        //then
        System.out.println(library);
        System.out.println(shallowClonedLibrary);
        System.out.println(deepClonedLibrary);
        assertEquals(2, library.getBooks().size());
        assertEquals(2, shallowClonedLibrary.getBooks().size());
        assertEquals(library.getBooks().size(),shallowClonedLibrary.getBooks().size());
        assertEquals(1, deepClonedLibrary.getBooks().size());
        assertNotEquals(library.getBooks().size(), deepClonedLibrary.getBooks().size());
    }
}