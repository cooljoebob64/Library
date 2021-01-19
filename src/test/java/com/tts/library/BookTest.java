package com.tts.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    Book testBook;

    @BeforeEach
    void setUp() {
        testBook = new Book("Test Book!");
    }

    @Test
    void borrowed() {
//        fail();
    }

    @Test
    void returned() {
//        fail();
    }

    @Test
    void isBorrowed() {
//        fail();
    }

    @Test
    void getTitle() {
        String testTitle = testBook.getTitle();
        System.out.println(testTitle);
        assertEquals("Test Book!", testTitle);

    }

    @Test
    void main() {
        assertNotEquals(null, testBook);

    }

    @Test
    void constructorTest() {
        assertEquals(testBook.getTitle(), "Test Book!");
    }
}