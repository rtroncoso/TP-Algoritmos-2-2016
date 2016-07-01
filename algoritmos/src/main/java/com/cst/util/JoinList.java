package com.cst.util;

import java.util.AbstractList;
import java.util.List;

/**
 * Created with IntelliJ IDEA by: alejandro
 * Date: 27/06/16
 * Time: 20:26
 */
public class JoinList<E> extends AbstractList<E> {

    private final List<? extends E> list1;
    private final List<? extends E> list2;

    public JoinList(List<? extends E> list1, List<? extends E> list2) {
        this.list1 = list1;
        this.list2 = list2;
    }

    @Override
    public E get(int index) {
        if (index < list1.size()) {
            return list1.get(index);
        }
        return list2.get(index-list1.size());
    }

    @Override
    public int size() {
        return list1.size() + list2.size();
    }
}
