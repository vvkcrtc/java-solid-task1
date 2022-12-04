public interface ProductBuilder {
    public ProductBuilder setName(String nane);

    public ProductBuilder setDescription(String description);

    public ProductBuilder setCategory(Category cat);

    public ProductBuilder setPrice(int price);

    public Product build();
}
