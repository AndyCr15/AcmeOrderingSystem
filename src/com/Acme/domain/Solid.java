package com.Acme.domain;

/**
 * Created by AndyCr15 on 18/03/2017.
 */
public class Solid extends Good {
    private double width;
    private double length;

    public Solid(String name, int modelNumber, double height, UnitOfMeasureType unitOfMeasure, boolean flammable, double weightPerUofM, double width, double length) {
        super(name, modelNumber, height, unitOfMeasure, flammable, weightPerUofM);
        this.width = width;
        this.length = length;
    }

    public double volume() {
        return width * length * getHeight();
    }

    public String toString() {
        return super.toString() + " that is " + volume() + " " + getUnitOfMeasure() + " in size";
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
