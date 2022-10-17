package ru.samd82.context;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype") // singleton : prototype : session
public class Cart {

    public Cart() {
    }

    private List<Product> cartList;

    @PostConstruct
    public void init() {
        cartList = new ArrayList<>();
    }

    public void addProduct (Product product) {
        cartList.add(product);
        for (int i =0; i<cartList.size(); i++) {
            System.out.println(cartList.get(i).getTitle());
        }
        System.out.println("_____________________________");

    }

    public void removeProduct (Product product) {
        cartList.remove(product);
        for (int i =0; i<cartList.size(); i++) {
            System.out.println(cartList.get(i).getTitle());
        }
        System.out.println("_____________________________");
    }


}
