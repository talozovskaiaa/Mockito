import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.PosterItem;
import ru.netology.PosterRepository;

public class PosterRepositoryTest {

    private PosterRepository repo;

    PosterItem item1 = new PosterItem(1, "Screem", 4, "horror");
    PosterItem item2 = new PosterItem(2, "Avatar", 5, "fantasy");
    PosterItem item3 = new PosterItem(3, "Shutter Island", 5, "thriller");

    @BeforeEach
    public void setup() {
        repo = new PosterRepository();
        repo.addition(item1);
        repo.addition(item2);
        repo.addition(item3);
    }

    @Test
    public void removingIdTest() {
        repo.removeById(item2.getId());

        PosterItem[] expected = {item1, item3};
        PosterItem[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addingNewMovieTest() {
        PosterItem[] expected = {item1, item2, item3};
        PosterItem[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void getAllMoviesInAscendingOrder() {
        PosterRepository repo = new PosterRepository();
        repo.addition(item3);
        repo.addition(item1);
        repo.addition(item2);

        PosterItem[] sorted = repo.findAllAscId();

        PosterItem[] expected = {item1, item2, item3};
        Assertions.assertArrayEquals(expected, sorted);
    }
}
