package org.example.book;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



@ExtendWith(MockitoExtension.class)
class BookServiceTest {
    @Mock
    private BookRepository mockBookService;

    @InjectMocks
    private BookService bookService;

    @Test
    public void findBookById() {

        when(mockBookService.findById("1")).thenReturn(new Book("1", "SomeTitle", "SomeAuthor"));
        String expectedBookId = "1";
        String actualBookId = bookService.findBookById("1").getId();
        verify(mockBookService).findById("1");
        assertEquals(expectedBookId, actualBookId, "Метод findBookById работает не корректно");
    }

    @Test
    public void findAllBooks() {
        when(mockBookService.findAll()).thenReturn(new ArrayList<>(Arrays.asList(new Book("1"), new Book("2"), new Book("3"))));
        int expectedSizeListBooks = 3;
        int actualSizeListBooks = bookService.findAllBooks().size();
        verify(mockBookService).findAll();
        assertEquals(expectedSizeListBooks, actualSizeListBooks,"Метод findAllBooks работает не корректно");
    }
}