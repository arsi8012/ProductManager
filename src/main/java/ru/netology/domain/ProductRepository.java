package ru.netology.domain;

public class ProductRepository {
    Product[] items = {new Book(1, "Ubuntu", 25, "Torvalds"),
    new Book(2, "Windows", 20, "Gates"),
    new Book(3, "Android", 40, "Rubin"),
    new Smartphone(4, "Smart1", 100, "Samsung"),
    new Smartphone(5, "Smart2", 200, "Apple"),
    new Smartphone(6, "Smart3", 300,"Sony")};

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] getAll() {
        return items;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}