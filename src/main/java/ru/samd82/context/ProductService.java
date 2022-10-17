package ru.samd82.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class ProductService {

    private ProductRepository repository;
    private Cart cart;

    @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    //получаем имя продукта по его id
    public String getTitleById(Long id){
        String title = repository.findById(id).getTitle();
        System.out.println(title);
        System.out.println("____________________");
        return title;
    }

    //получаем список продуктов в репозитории
    public String [] getAllProduct () {return repository.getAllProducts();}

    //добавляем продукты в корзину
    public void addProductToCart (Long id) {
        Product productToCart = repository.findById(id);
        cart.addProduct(productToCart);

    }
    //удаляем продукты из корзины
    public void removeProductFromCart (Long id) {
        Product productRemoveFromCart = repository.findById(id);
        cart.removeProduct(productRemoveFromCart);

    }


}
