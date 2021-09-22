package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.domain.ProductRepository;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    @Test
    public void shouldSearch1() {
        Product[] actual = manager.searchBy("Android");
        Product[] expected = {new Book(3, "Android", 40, "Rubin")};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearch2() {
        Product[] actual = manager.searchBy("Torvalds");
        Product[] expected = {new Book(1, "Ubuntu", 25, "Torvalds")};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearch3() {
        Product[] actual = manager.searchBy("Apple");
        Product[] expected = {new Smartphone(5, "Smart2", 200, "Apple")};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearch4() {
        Product[] actual = manager.searchBy("Smart3");
        Product[] expected = {new Smartphone(6, "Smart3", 300,"Sony")};
        assertArrayEquals(expected, actual);
    }
}
