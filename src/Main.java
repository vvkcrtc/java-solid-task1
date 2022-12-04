/*
Применение принципа SOLID - каждый класс отвечает за определенную функциональность:
Product - описание товара
Stock - реализует функциональность склада - хранение, учет, поиск
Buyer - покупатель,
Buyers - покупатели,
Market - реализует взаимодействие между покупателями и складом
Main - создание объектов
 */
public class Main {
    public static void main(String[] args) {
        ProductGroup group = new ProductGroup();
        Stock stock = new Stock(group);
        stock.addProduct("SIEMENS", "Стиральная машина", Category.HOME_APPLIANCES, 18000, 10);
        stock.addProduct("BOSCH", "", Category.HOME_APPLIANCES, 0, 12);
        //System.out.println(stock.toString());
        Buyers buyers = new Buyers();
        buyers.addBuyer(new Buyer("Покупатель 1", 100000));
        buyers.addBuyer(new Buyer("Покупатель 2", 80000));
        buyers.addBuyer(new Buyer("Покупатель 3", 150000));

        Market market = new Market(stock, buyers, group);
        market.run();
        System.out.println(buyers.toString());
    }
}
