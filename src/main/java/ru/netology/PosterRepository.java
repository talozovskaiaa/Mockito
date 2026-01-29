package ru.netology;

import java.util.Arrays;
import java.util.Comparator;

public class PosterRepository {
    private PosterItem[] items = new PosterItem[0];
    private int item;

    public PosterRepository(int item) {
        this.item = item;
    }

//    /**
//     * метод для добавления нового элемента
//     */
//    public void addition(PosterItem item) {
//        PosterItem[] tmp = new PosterItem[items.length + 1];
//        for (int i = 0; i < items.length; i++) {
//            tmp[i] = items[i];
//        }
//        tmp[tmp.length - 1] = item;
//        items = tmp;
//    }

    /**
     * метод для добавления нового элемента
     */
    public void addition(PosterItem item) {
        PosterItem[] tmp = new PosterItem[items.length + 1];
        System.arraycopy(items, 0, tmp, 0, items.length); // копируем элементы
        tmp[tmp.length - 1] = item;                       // добавляем новый элемент
        items = tmp;                                      // заменяем старый массив новым
    }

    /**
     * метод для получения всех элементов массива
     */
    public PosterItem[] getItems() {
        return items;
    }

    /**
     * метод для удаления одного из элементов массива
     */
    public void removeById(int id) {
        PosterItem[] tmp = new PosterItem[items.length - 1];
        int copyToIndex = 0;
        for (PosterItem item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
    }

    /**
     * Выводит все фильмы в порядке возрастания их id
     */
    public PosterItem[] findAllAscId() {
        PosterItem[] sortedItems = Arrays.copyOf(items, items.length);
        Arrays.sort(sortedItems, Comparator.comparingInt(PosterItem::getId));
        return sortedItems;
    }

    /**
     * Метод findLast выводит последние добавленные фильмы в обратном порядке
     */
    public PosterItem[] findLast() {
        int resultSize = Math.min(items.length, item);

        PosterItem[] result = new PosterItem[resultSize];
        for (int i = 0; i < resultSize; i++) {
            result[i] = items[items.length - 1 - i];
        }
        return result;
    }
}
