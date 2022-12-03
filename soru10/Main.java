import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<Product>();

        Product product1 = new Product();
        product1.id = 1;
        product1.productName = "Masa";
        product1.unitsInStock = 15;
        product1.unitPrice = 50;
        products.add(product1);

        Product product2 = new Product();
        product2.id = 2;
        product2.productName = "Sandalye";
        product2.unitsInStock = 500;
        product2.unitPrice = 21;
        products.add(product2);

        Product product3 = new Product();
        product2.id = 3;
        product2.productName = "Sandalye";
        product2.unitsInStock = 500;
        product2.unitPrice = 21;
        products.add(product3);


        Customer customer1 = new Customer();
        customer1.id = 1;
        customer1.name = "Görkem";
        customer1.companyName = "Goorkei Inc";
        customer1.age=26;

        Customer customer2 = new Customer();
        customer2.id = 2;
        customer2.name = "Arslan";
        customer2.companyName = "Goorkei Inc";
        customer2.age=21;




        OrderManager order = new OrderManager();
        order.addCustomer(customer1);
        order.addCustomer(customer2);
        order.add(customer1, products);
        order.add(customer1, products);


        System.out.println("XXXXXXXXXXXXXXXXXXXXXXxx");

        order.getPrice(50);


    }
}








