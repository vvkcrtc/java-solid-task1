import java.util.ArrayList;
import java.util.List;

public class Buyers {
    List<Buyer> buyers = new ArrayList<>();

    public void addBuyer(Buyer buyer) {
        buyers.add(buyer);
    }

    //Применение DRY
    boolean correctIndex(int index) {
        if (index >= 0 && index < buyers.size()) {
            return true;
        } else {
            return false;
        }
    }

    public Buyer getBuyer(int index) {
        if (correctIndex(index)) {
            return buyers.get(index);
        } else {
            return null;
        }
    }

    public void setBuyers(Buyer buyer, int index) {
        if (correctIndex(index)) {
            buyers.set(index, buyer);
        }
    }

    public int getCountBuyers() {
        return buyers.size();
    }

    @Override
    public String toString() {
        String str = "";
        for (Buyer b : buyers) {
            str += b.toString();
        }
        return str;
    }
}
