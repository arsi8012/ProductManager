package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Book book1 = new Book(1, "Windows", 25, "Torvalds");
    Book book2 = new Book(2, "Windows", 20, "Gates");
    Book book3 = new Book(3, "Android", 40, "Rubin");
    Smartphone smartphone1 = new Smartphone(4, "Smart1", 100, "Samsung");
    Smartphone smartphone2 = new Smartphone(5, "Smart2", 200, "Apple");
    Smartphone smartphone3 = new Smartphone(6, "Smart3", 300, "Sony");

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }

    @Test
    public void shouldSearchNameBook() {
        Product[] actual = manager.searchBy("Android");
        Product[] expected = new Product[]{book3};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAuthorBook() {
        Product[] actual = manager.searchBy("Torvalds");
        Product[] expected = new Product[]{book1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchManufacturerSmartphone() {
        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[]{smartphone2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNameSmartphone() {
        Product[] actual = manager.searchBy("Smart3");
        Product[] expected = new Product[]{smartphone3};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMultipleProducts() {
        Product[] actual = manager.searchBy("Windows");
        Product[] expected = new Product[]{book1, book2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNotFoundProduct() {
        Product[] actual = manager.searchBy("Smart4");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }
}
