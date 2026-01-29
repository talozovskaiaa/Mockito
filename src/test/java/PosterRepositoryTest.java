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
    private PosterItem item1, item2, item3, item4, item5, item6, item7, item8;

    @BeforeEach
    public void setup() {

        item1 = FakerUtils.generatePosterItem();
        item2 = FakerUtils.generatePosterItem();
        item3 = FakerUtils.generatePosterItem();
        item4 = FakerUtils.generatePosterItem();
        item5 = FakerUtils.generatePosterItem();
        item6 = FakerUtils.generatePosterItem();
        item7 = FakerUtils.generatePosterItem();
        item8 = FakerUtils.generatePosterItem();
    }

    @Test
    public void removingIdTest() {

        PosterRepository repo = new PosterRepository(8);
        PosterItem[] items = {item1, item2, item3, item4, item5, item6, item7, item8};
        for (PosterItem item : items) {
            repo.addition(item);
        }

        repo.removeById(item2.getId());

        PosterItem[] expected = {item1, item3, item4, item5, item6, item7, item8};
        PosterItem[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addingNewMovieTest() {
        PosterRepository repo = new PosterRepository(3);
        repo.addition(item1);
        repo.addition(item2);
        repo.addition(item3);

        PosterItem[] expected = {item1, item2, item3};
        PosterItem[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void getAllMoviesInAscendingOrder() {
        PosterRepository repo = new PosterRepository(3);
        repo.addition(item1);
        repo.addition(item2);
        repo.addition(item3);

        PosterItem[] sorted = repo.findAllAscId();
        PosterItem[] expected = {item1, item2, item3};
        Arrays.sort(expected, Comparator.comparingInt(PosterItem::getId));
        Assertions.assertArrayEquals(expected, sorted);
    }

    @Test
    public void getRevertOrder3() {

        PosterRepository repo = new PosterRepository(3);
        repo.addition(item1);
        repo.addition(item2);
        repo.addition(item3);

        PosterItem[] actual = repo.findLast();
        PosterItem[] expected = {item3, item2, item1};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void getRevertOrder5() {

        PosterRepository repo = new PosterRepository(5);
        repo.addition(item1);
        repo.addition(item2);
        repo.addition(item3);
        repo.addition(item4);
        repo.addition(item5);


        PosterItem[] actual = repo.findLast();
        PosterItem[] expected = {item5, item4, item3, item2, item1};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void getRevertOrder7() {

        PosterRepository repo = new PosterRepository(7);
        repo.addition(item1);
        repo.addition(item2);
        repo.addition(item3);
        repo.addition(item4);
        repo.addition(item5);
        repo.addition(item6);
        repo.addition(item7);

        PosterItem[] actual = repo.findLast();
        PosterItem[] expected = {item7, item6, item5, item4, item3, item2, item1};
        Assertions.assertArrayEquals(expected, actual);
    }
}
