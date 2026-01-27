import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.FakerUtils;
import ru.netology.PosterItem;
import ru.netology.PosterRepository;

import java.util.Arrays;
import java.util.Comparator;

public class PosterRepositoryTest {

    private PosterRepository repo;
    private PosterItem item1;
    private PosterItem item2;
    private PosterItem item3;

    @BeforeEach
    public void setup() {

        item1 = FakerUtils.generatePosterItem();
        item2 = FakerUtils.generatePosterItem();
        item3 = FakerUtils.generatePosterItem();

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

        PosterItem[] sorted = repo.findAllAscId();
        PosterItem[] expected = {item1, item2, item3};
        Arrays.sort(expected, Comparator.comparingInt(PosterItem::getId));
        Assertions.assertArrayEquals(expected, sorted);
    }
}
