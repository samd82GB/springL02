package ru.samd82.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.samd82.context");

        ProductService service = context.getBean(ProductService.class);

        //инициализируем две разные корзины
        Cart cart = context.getBean(Cart.class);
        Cart cart2 = context.getBean(Cart.class);


        System.out.println("Получаем имя продукта по его id из репозитория");
        service.getTitleById(2L);

        System.out.println("Получаем список всех продуктов из репозитория");
        service.getAllProduct();

        service.setCart(cart);
        System.out.println("Добавляем первый продукт в корзину");
        service.addProductToCart(1L); //после каждого метода идёт распечатка состояния корзины
        System.out.println("Добавляем второй продукт в корину");
        service.addProductToCart(3L);
        System.out.println("Добавляем третий продукт в корзину");
        service.addProductToCart(5L);

        System.out.println("Удаляем продукт из корзины по его id");
        service.removeProductFromCart(3L);

        service.setCart(cart2);
        System.out.println("Добавляем первый продукт в корзину2");
        service.addProductToCart(2L); //после каждого метода идёт распечатка состояния корзины
        System.out.println("Добавляем второй продукт в корину2");
        service.addProductToCart(4L);

        System.out.println("Удаляем продукт из корзины 2 по его id");
        service.removeProductFromCart(2L);





    }

}
