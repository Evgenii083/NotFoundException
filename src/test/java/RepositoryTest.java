import org.example.Exception.project.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {
    Product item1 = new Product("Product1", 1, 1);
    Product item2 = new Product("Product2", 2, 2);
    Product item3 = new Product("Product3", 3, 3);
    Product item4 = new Product("Product4", 3, 3);


    @Test
    public void saveTest() {
        Repository repo = new Repository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);

        Product[] expected = {item1, item2, item3};
        Product[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotSaveItemWithTheSameId() {
        Repository repo = new Repository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.save(item4);
        });
    }

    @Test
    public void deleteItemById() {
        Repository repo = new Repository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);

        repo.removeById(3);
        Product[] expected = {item1, item2};
        Product[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotDeleteByNegativeId() {
        Repository repo = new Repository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);

        Assertions.assertThrows(NegativeIdException.class, () -> {
            repo.removeById(-6);
        });
    }

    @Test
    public void shouldNotDeleteByWrongID() {
        Repository repo = new Repository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);


        Assertions.assertThrows(NegativeIdException.class, () -> {
            repo.removeById(6);
        });
    }
}
