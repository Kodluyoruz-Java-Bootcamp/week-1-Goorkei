import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class OrderManager {
    private List<Product> _products;
    private List<Customer> _customers;
    private List<Order> _orders;


    public OrderManager() {
        _products = new ArrayList<Product>();
        _customers = new ArrayList<Customer>();
        _orders = new ArrayList<Order>();
    }

    public void add(Customer customer, List<Product> products) {
        Order order = new Order();
        addCustomer(customer);
        order.customer = customer;
        order.products = products;
        _orders.add(order);
        sendInvoice(order);
    }

    public void addCustomer(Customer customer) {
        if (_customers.stream().filter(p -> p.name == customer.name).count() == 0) {
            _customers.add(customer);
        }
    }


    public void sendInvoice(Order order) {
        System.out.println("--------------------------------------");
        System.out.println("Firma Adı:" + order.customer.companyName);
        System.out.println("Müşteri Adı:" + order.customer.name);
        System.out.println("--------------------------------------");
        for (Product p : order.products) {
            System.out.println("Ürün Adı:" + p.productName);
            System.out.println("Ürün Fiyatı:" + p.unitPrice);
            System.out.println("-------------------");
        }
        System.out.println("--------------------------------------");
        System.out.println("Hizmet Tutarı : " + sumOfProduct(order));
        System.out.println("KDV : " + sumOfProduct(order) * 18 / 100);
        System.out.println("Toplam Tutarı : " + (sumOfProduct(order) + (sumOfProduct(order) * 18 / 100)));
        System.out.println("--------------------------------------");
    }

    //Sistemdeki bütün müşterisi sayısını bulan,
    public long customerLenght() {
        return _customers.stream().count();
    }

    // İsmi Cem olan müşterilerin aldıkları ürün sayısını bulan,
    public long customerOfProduct(String name) {
        long toplam = 0;
        for (Order order : _orders.stream().filter(p -> p.customer.name == name).toList()) {
            toplam += order.products.size();
        }
        return toplam;
    }


    //Verilen siparişin Toplam fiyatını bulur
    public float sumOfProduct(Order order) {
        float toplam = 0;
        for (Product product : order.products) {
            toplam += product.unitPrice;
        }
        return toplam;
    }


    //İsmi Cem olup yaşı 30’dan küçük 25’ten büyük müşterilerin toplam alışveriş tutarını hesaplayın,
    public float getAgeofName(String name) {
        float toplam = 0;
        for (Order order : _orders.stream()
                .filter(p -> p.customer.name == name && p.customer.age > 25 && p.customer.age < 30).toList()) {
            for (Product product : order.products.stream().toList()) {
                toplam += product.unitPrice;
            }
        }
        return toplam;
    }

    //Sistemdeki 1500 TL üzerindeki faturaları listeleyin

    public void getPrice(float price){

        for (Order order : _orders) {
            float toplam = 0;
            for (Product product : order.products.stream().toList()) {
                toplam += product.unitPrice;
            }
            if(toplam>price){
                sendInvoice(order);
            }
        }
    }


}