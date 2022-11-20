import org.example.Exception.project.*;

public class Repository {
    Product[] items = new Product[0];

    public void save(Product item) {
        Product[] tmp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public void removeById(int id) {
        if (id < 0) {
            throw new NegativeIdException("Id не может быть отрицательным" + id);
        }
        if(findById(id)==null){
            throw new NegativeIdException("Нет такого id"+id);
        }
        Product[] tmp = new Product[items.length - 1];
        int copyToIndex = 0;
        for (Product items : items) {
            if (items.getId() != id) {
                tmp[copyToIndex] = items;
                copyToIndex++;
            }
        }
        items = tmp;
    }

    public Product findById(int id){
        for(Product items : items){
            if(items.getProductId()==id){
                return items;
            }
        }
        return null;
    }
    public Product[] getItems() {
        return items;
    }
}
