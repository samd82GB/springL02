package ru.samd82.context;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

@Component

public class ProductRepository {

    private List<Product> products;

    @PostConstruct
    public void init(){
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Bread", 50),
                new Product(2L, "Milk", 80),
                new Product(3L, "Orange", 100),
                new Product(4L, "Water",20),
                new Product(5L, "Salt",5)
        ));
    }


   
    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }
    
    public String [] getAllProducts () {
        int number = 0;
        String [] arrayOfProducts = new String[products.size()];

        ListIterator iterator = products.listIterator();
        while (iterator.hasNext()) {
            Product curProduct  = (Product) iterator.next();
            arrayOfProducts[number] = curProduct.getTitle();
            number++;
        }
        System.out.println(Arrays.toString(arrayOfProducts));
        System.out.println("__________________");

        return arrayOfProducts;
    }
    
    
}
