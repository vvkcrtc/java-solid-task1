import java.util.List;
import java.util.Scanner;

public class Market {
    Stock stock;
    Buyers buyers;
    Category cat;
    ProductGroup group;
    Scanner scanner;

    public Market(Stock stock, Buyers buyers, ProductGroup group) {
        this.stock = stock;
        this.buyers = buyers;
        this.group = group;
        scanner = new Scanner(System.in);
    }

    void showProductGroups() {
        System.out.println("Выберите группу товаров: ");
        int i = 0;
        for (Category c : cat.values()) {
            System.out.println(i + 1 + ". " + group.getGroupName(c) + " ");
            i++;
        }
    }

    int selectBuyer() {
        System.out.println("Выберите обслуживаемого покупателя, 0 - выход:");
        for (int i = 0; i < buyers.getCountBuyers(); i++) {
            System.out.println(i + 1 + " " + buyers.getBuyer(i).getName());
        }
        return scanIntValue(scanner);
    }

    void showFindMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1. Поиск товаров по категориям");
        System.out.println("2. Поиск товаров по ключевым словам");
        System.out.println("3. Список всех товаров");
        System.out.println("0. Выход");

    }

    //Применение DRY
    int scanIntValue(Scanner sc) {
        return Integer.parseInt(sc.nextLine());
    }

    int selectProductFromList(List<Product> lst) {
        for (int i = 0; i < lst.size(); i++) {
            System.out.println(i + 1 + " " + lst.get(i).toString());
        }
        System.out.println("Введите номер приобретаемого товара, 0 - выход");
        return scanIntValue(scanner);
    }

    /*
        Применение DRY
     */
    void buyProduct(Buyer buyer, int indexBuyer, List<Product> lstProd) {

        boolean flagBreak = false;

        while (flagBreak == false) {

            int selProduct = selectProductFromList(lstProd);

            if (selProduct > 0) {
                Product tmp = lstProd.get(selProduct - 1);
                Product buyProduct = stock.createProduct(tmp.getName(), tmp.getDescription(), tmp.getCategory(), tmp.getPrice(), tmp.getQuantity());
                System.out.println("Введите количество, 0 - выход :");
                int count = scanIntValue(scanner);
                buyer.basketAdd(buyProduct, count);
                stock.releaseProduct(buyProduct.getName(), buyProduct.getCategory(), count);
                buyers.setBuyers(buyer, indexBuyer);
            } else {
                flagBreak = true;
            }
        }

    }

    public void run() {

        boolean flagBreakFirst = false;
        int selBuyer = -1;

        while (flagBreakFirst == false) {
            selBuyer = selectBuyer();
            Buyer buyer = buyers.getBuyer(selBuyer - 1);
            if (selBuyer == 0) {
                flagBreakFirst = true;
            }
            boolean flagBreakSecond = false;
            while (flagBreakSecond == false && flagBreakFirst == false) {

                showFindMenu();

                switch (scanIntValue(scanner)) {
                    case 0:
                        flagBreakSecond = true;
                        break;
                    case 1:
                        showProductGroups();
                        int selGroup = scanIntValue(scanner);
                        if (selGroup == 0) {
                            break;
                        }
                        if (selGroup != 0 && selGroup < Category.values().length) {
                            List<Product> lst = stock.getProductsByCat(Category.values()[selGroup - 1]);
                            buyProduct(buyer, selBuyer - 1, lst);

                        } else {
                            System.out.println("Введено неверное значение");

                        }
                        break;
                    case 2:
                        System.out.println("Введите строку для поиска : ");
                        String keyStr = scanner.nextLine();
                        List<Product> lst = stock.findProductsByKeyword(keyStr);
                        buyProduct(buyer, selBuyer - 1, lst);
                        break;

                    case 3:
                        List<Product> lstAll = stock.getProductsAll();
                        buyProduct(buyer, selBuyer - 1, lstAll);
                        break;

                    default:
                        break;
                }


            }


        }
    }
}
