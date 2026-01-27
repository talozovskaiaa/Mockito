package ru.netology;

import java.util.Arrays;
import java.util.Comparator;

public class PosterRepository {
    private PosterItem[] items = new PosterItem[0];

    /**
     * метод для добавления нового элемента
     */
    public void addition(PosterItem item) {
        PosterItem[] tmp = new PosterItem[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
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

//    public PosterItem[] findLast() {
//        int resultLength;
//        if (items.length >= items) {
//            resultLength = items;
//        } else {
//            resultLength = items.length;
//        }
//    }

    /**
     * Выводит все фильмы в порядке возрастания их id
     */
    public PosterItem[] findAllAscId() {
        PosterItem[] sortedItems = Arrays.copyOf(items, items.length);
        Arrays.sort(sortedItems, Comparator.comparingInt(PosterItem::getId));
        return sortedItems;
    }
}
