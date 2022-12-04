public class ProductBuilderImpl implements ProductBuilder {
    protected String name;
    protected String description;
    protected Category cat;
    protected int price;

    @Override
    public ProductBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public ProductBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public ProductBuilder setCategory(Category cat) {
        this.cat = cat;
        return this;
    }

    @Override
    public ProductBuilder setPrice(int price) {
        this.price = price;
        return this;
    }

    @Override
    public Product build() {
        if (price <= 0) {
            throw new IllegalArgumentException("Не указана цена товара ");
        } else if (name.isEmpty()) {
            throw new IllegalArgumentException("Не указано наименование товара ");
        }
        Product product = new Product(name, description, price, cat);
        return product;
    }
}
