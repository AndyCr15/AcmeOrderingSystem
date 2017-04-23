package com.Acme.domain;

import java.util.*;

/**
 * Created by AndyCr15 on 18/03/2017.
 */
public abstract class Good implements Product {
    public enum UnitOfMeasureType {LITER, GALLON, CUBIC_METER, CUBIC_FEET}

    private String name;
    private int modelNumber;
    private double height;
    private UnitOfMeasureType unitOfMeasure;
    private boolean flammable = true;
    private double weightPerUofM;
    private static List<Good> catalog;

    static {
        Liquid glue = new Liquid("Acme Glue", 2334, 4, UnitOfMeasureType.LITER, false, 15, 6);
        Liquid paint = new Liquid("Acme Invisible Paint", 2490, 0.65, UnitOfMeasureType.GALLON, true, 0.70, 12);
        Solid anvil = new Solid("Acme Anvil", 1668, 0.3, UnitOfMeasureType.CUBIC_METER, false, 500, 0.25, 0.3);
        Solid safe = new Solid("Acme Safe", 1672, 1.0, UnitOfMeasureType.CUBIC_METER, false, 300, 0.5, 0.5);
        Solid balloon = new Solid("Acme Balloon", 1401, 15, UnitOfMeasureType.CUBIC_FEET, false, 10, 5, 5);
        Solid pistol = new Solid("Acme Disintegrating Pistol", 1587, 0.1, UnitOfMeasureType.CUBIC_FEET, false, 1, 0.5, 2);
        Liquid nitro = new Liquid("Acme Nitroglycerin", 4289, 1.0, UnitOfMeasureType.CUBIC_METER, true, 1.5, 0.25);
        Liquid oil = new Liquid("Acme Oil", 4275, 1.0, UnitOfMeasureType.CUBIC_METER, true, 1.5, 0.25);
        catalog = new ArrayList<Good>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Good> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Good good) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Good> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Good> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Good get(int index) {
                return null;
            }

            @Override
            public Good set(int index, Good element) {
                return null;
            }

            @Override
            public void add(int index, Good element) {

            }

            @Override
            public Good remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Good> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Good> listIterator(int index) {
                return null;
            }

            @Override
            public List<Good> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        catalog.add(glue);
        catalog.add(paint);
        catalog.add(anvil);
        catalog.add(safe);
        catalog.add(balloon);
        catalog.add(pistol);
        catalog.add(nitro);
        catalog.add(oil);
    }

    public Good(String name, int modelNumber, double height, UnitOfMeasureType unitOfMeasure, boolean flammable, double weightPerUofM) {
        this.name = name;
        this.modelNumber = modelNumber;
        this.height = height;
        this.unitOfMeasure = unitOfMeasure;
        this.flammable = flammable;
        this.weightPerUofM = weightPerUofM;
    }


    public Good() {
        this("null", 0, 0, UnitOfMeasureType.LITER, false, 0);
    }

    public final boolean canShipViaPostOffice() {
        boolean canPost = true;
        if (this.weight() >= 200 || this.flammable) {
            canPost = false;
        }
        return canPost;
    }

    public static List<Good> getCatalog() {
        return catalog;
    }

    public String toString() {
        return name + "-" + modelNumber;
    }

    public abstract double volume();


    public double weight() {
        return volume() * weightPerUofM;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Set<Good> flammablesList() {
        Set<Good> flammables = new HashSet<Good>();
        Iterator<Good> i = Good.getCatalog().iterator();
        while (i.hasNext()) {
            Good x = i.next();
            if (x.isFlammable()) {
                flammables.add(x);
            }
        }
        return flammables;
    }


    public int getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(int modelNumber) {
        this.modelNumber = modelNumber;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public UnitOfMeasureType getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasureType unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public boolean isFlammable() {
        return flammable;
    }

    public void setFlammable(boolean flammable) {
        this.flammable = flammable;
    }

    public double getWeightPerUofM() {
        return weightPerUofM;
    }

    public void setWeightPerUofM(double weightPerUofM) {
        this.weightPerUofM = weightPerUofM;
    }
}
