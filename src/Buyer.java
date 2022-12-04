import java.util.ArrayList;
import java.util.List;

public class Buyer {
    String name;
    int amount;
    List<Product> basket = new ArrayList<>();

    public Buyer(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public void basketAdd(Product pr, int count) {
        boolean isPresent = false;

        int summBuy = pr.getPrice() * count;
        if (summBuy < amount) {
            amount -= summBuy;

            for (int i = 0; i < basket.size(); i++) {
                if (basket.get(i).getName() == pr.getName() && basket.get(i).getCategory() == pr.getCategory()) {
                    isPresent = true;
                    basket.get(i).addProduct(count);
                }
            }

            if (isPresent == false) {
                pr.setQuantity(0);
                pr.addProduct(count);
                basket.add(pr);
            }
        } else {
            System.out.println("Недостаточно средств для покупки");
        }
    }

    @Override
    public String toString() {
        String str = "\n" + name + "\n";
        for (Product pr : basket) {
            str += pr.toString();
        }
        return str;
    }

}
