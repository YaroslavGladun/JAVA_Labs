package com.company;

import java.util.Arrays;
import java.util.Iterator;

interface IStringList {

    void add(String string);

    void clear();

    boolean remove(String string);

    Object[] toArray();

    int size();

    boolean contains(String string);

    boolean containsAll(IStringList stringList);
}

public class StringList implements IStringList, Iterator<String>, Iterable<String> {

    private String array[];
    private int counter;

    @Override
    public String toString() {
        return array.toString();
    }

    public StringList() {
        array = new String[0];
        counter = 0;
    }

    @Override
    public void add(String string) {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = string;
    }

    @Override
    public void clear() {
        array = new String[0];
    }

    @Override
    public boolean remove(String string) {
        int index;

        for (index = 0; index < this.array.length; index++) {
            if (array[index] == string) break;
            if (index == this.array.length - 1) return false;
        }
        for (; index < this.array.length - 1; index++) {
            array[index] = array[index + 1];
        }

        array = Arrays.copyOf(array, array.length - 1);
        return false;
    }

    @Override
    public Object[] toArray() {
        return array.clone();
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean contains(String string) {
        for (String stringFromArray :
                array) {
            if (stringFromArray.equals(string)) return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(IStringList stringList) { //----------------------------------------
        return false;
    }

    @Override
    public boolean hasNext() {
        if (counter >= this.array.length) {
            counter = 0;
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String next() {
        counter++;
        return array[counter - 1];
    }

    @Override
    public Iterator<String> iterator() {
        return this;
    }
}
