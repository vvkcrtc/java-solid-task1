import java.util.ArrayList;
import java.util.List;

public class Stock {
    List<Product> productList = new ArrayList<>();
    Category cat;
    ProductGroup group;

    Stock(ProductGroup group) {
        this.group = group;
        addProduct("BOSCH", "Щетки стеклоочистителя", Category.OTHER, 5000, 0);
        addProduct("Аквафор", "Фильтр для воды", Category.OTHER, 4000, 5);
        addProduct("SAMSUNG", "Телевизор", Category.AUDIO_VIDEO, 35000, 8);
        addProduct("LG", "Телевизор", Category.AUDIO_VIDEO, 32000, 4);
        addProduct("LENOVO", "Ноутбук", Category.COMPUTERS, 17000, 5);
        addProduct("SAMSUNG", "Планшетный компьютер", Category.COMPUTERS, 20000, 3);
        addProduct("BOSCH", "Пылесос", Category.HOME_APPLIANCES, 22000, 0);
    }


    public Product getProduct(String name, Category cat) {
        for (Product pr : productList) {
            if (name.equals(pr.getName()) && cat == pr.getCategory()) {
                return pr;
            }
        }
        return null;
    }

    ;

    /*
        public void addProduct(String name, String description, Category cat, int price, int count) {
            Product pr = getProduct(name, cat);
            if( pr == null) {
                productList.add(new ProductBuilderImpl()
                        .setName(name)
                        .setDescription(description)
                        .setCategory(cat)
                        .setPrice(price)
                        .build());
                productList.get(productList.size()-1).addProduct(count);
                productList.get(productList.size()-1).setGroupName(group.getGroupName(cat));
            } else {
                productList.get(productList.indexOf(pr)).addProduct(count);
            }
        }

     */
    //Применение принципа DRY
    public Product createProduct(String name, String description, Category cat, int price, int count) {
        Product pr = new ProductBuilderImpl()
                .setName(name)
                .setDescription(description)
                .setCategory(cat)
                .setPrice(price)
                .build();
        pr.addProduct(count);
        pr.setGroupName(group.getGroupName(cat));
        return pr;
    }

    public void addProduct(String name, String description, Category cat, int price, int count) {
        Product pr = getProduct(name, cat);
        if (pr == null) {
            productList.add(createProduct(name, description, cat, price, count));
        } else {
            productList.get(productList.indexOf(pr)).addProduct(count);
        }
    }

    public void releaseProduct(String name, Category cat, int count) {
        Product pr = getProduct(name, cat);
        if (pr != null) {
            productList.get(productList.indexOf(pr)).decProduct(count);
        } else {
            System.out.println("Товар " + name + "не найден");
        }
    }

    public List<Product> getProductsByCat(Category cat) {
        List<Product> productCatList = new ArrayList<>();
        for (Product pr : productList) {
            if (cat == pr.getCategory()) {
                productCatList.add(pr);
            }
        }
        return productCatList;
    }

    public List<Product> getProductsAll() {
        List<Product> productAllList = new ArrayList<>();
        for (Product pr : productList) {
            productAllList.add(pr);
        }
        return productAllList;
    }

    public List<Product> findProductsByKeyword(String keyStr) {
        List<Product> producCattList = new ArrayList<>();
        String tmpStr = "";
        for (Product pr : productList) {
            tmpStr = pr.getName().toUpperCase() + pr.getDescription().toUpperCase();
            if (tmpStr.contains(keyStr.toUpperCase())) {
                producCattList.add(pr);
            }
        }
        return producCattList;
    }

    @Override
    public String toString() {
        String str = "";
        for (Category c : cat.values()) {
            for (Product pr : productList) {
                if (pr.getCategory() == c) {
                    str += pr.toString();
                }
            }
        }
        return str;
    }
}
