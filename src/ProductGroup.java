import java.util.HashMap;
import java.util.Map;

public class ProductGroup {
    Map<Category, String> group = new HashMap<Category, String>();

    ProductGroup() {
        group.put(Category.AUDIO_VIDEO, "Аудио, видео, ТВ");
        group.put(Category.COMPUTERS, "Компьюютеры и комплектующие");
        group.put(Category.HOME_APPLIANCES, "Бытовая техчника");
        group.put(Category.OTHER, "Другие товары");
    }

    public String getGroupName(Category cat) {
        return group.get(cat);
    }
}
