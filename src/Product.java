
enum Category {HOME_APPLIANCES, AUDIO_VIDEO, COMPUTERS, OTHER};

public class Product {
    protected String name;
    protected String description;
    protected Category cat;
    protected int price;
    protected int quantity;
    String groupName;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
        this.cat = Category.OTHER;
        quantity = 0;
        groupName = "Не определена";
    }

    public Product(String name, String description, int price, Category cat) {
        this.name = name;
        this.price = price;
        this.cat = cat;
        this.description = description;
        quantity = 0;
        groupName = "Не определена";
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(Category cat) {
        this.cat = cat;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void addProduct(int count) {
        quantity += count;
    }

    public void decProduct(int count) {
        if (count > quantity) {
            System.out.println("Доступно для продажи только " + quantity);
            quantity = 0;
        } else {
            quantity -= count;
        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return cat;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "\n Товар: " + name +
                "\n Описание : " + description +
                "\n Группа : " + groupName +
                "\n Цена : " + price +
                "\n Количество = " + quantity;
    }
}
