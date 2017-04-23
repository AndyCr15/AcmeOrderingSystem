package com.Acme.domain;

import com.Acme.utils.HolidayOrdersNotAllowedException;
import com.Acme.utils.MyDate;

import java.time.LocalDate;

public class Order {
    private LocalDate orderDate;
    private double orderAmount = 0.00;
    private String customer;
    private Product product;
    private char orderSize;
    private int quantity;
    private static double taxRate;
    private static Rushable rushable;

    public Order(LocalDate d, double amt, String c, Product p, int q) {
        try {
            setOrderDate(d);
        } catch (HolidayOrdersNotAllowedException e) {
            System.out.println("The order date for an order cannot be a        holiday!  Application closing.");
            System.exit(0);
        }
        orderAmount = amt;
        customer = c;
        product = p;
        quantity = q;
    }

    public static Rushable getRushable() {
        return rushable;
    }

    private boolean isHoliday(LocalDate proposedDate) {
        boolean result = false;
        for (LocalDate holiday : MyDate.getHolidays()) {
            if (holiday.equals(proposedDate)) {
                result = true;
            }
        }
        return result;
    }

    public boolean isPriorityOrder() {
        boolean priorityOrder = false;
        if (rushable != null) {
            priorityOrder = rushable.isRushable(orderDate, orderAmount);
        }
        return priorityOrder;
    }

    public static void setRushable(Rushable rushable) {
        Order.rushable = rushable;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) throws HolidayOrdersNotAllowedException {
        if (isHoliday(orderDate)) {
            System.out.println("Order date, " + orderDate + ", cannot be set to a holiday!");
            throw new HolidayOrdersNotAllowedException(orderDate);
        } else {
            this.orderDate = orderDate;
        }
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        if (orderAmount > 0) {
            this.orderAmount = orderAmount;
        } else System.out.println("Invalid Order amount");
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public char getOrderSize() {
        return orderSize;
    }

    public void setOrderSize(char orderSize) {
        this.orderSize = orderSize;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        } else System.out.println("Invalid Quantity amount");
    }

    public static double getTaxRate() {
        return taxRate;
    }

    {
        taxRate = 0.05;
    }

//    public Order(MyDate d, double amt, String c) {
//        this(d, amt, c, "Anvil", 1);
//    }


    public String toString() {
        return quantity + " ea. " + product + " for " + customer;
    }

    static public void setTaxRate(double newRate) {
        taxRate = newRate;
    }

    public static void computeTaxOn(double anAmount) {
        System.out.println("The TAX payable on " + anAmount + " is " + anAmount * Order.taxRate);
    }

    public double computeTax() {
        System.out.println("The TAX for this order is " + orderAmount * Order.taxRate);
        return orderAmount * Order.taxRate;
    }

    public char jobSize() {
        if (quantity <= 25) {
            return 'S';
        }
        if (quantity > 25 && quantity < 76) {
            return 'M';
        }
        if (quantity > 75 && quantity <= 150) {
            return 'L';
        }
        return 'X';
    }

    public double computeTotal() {
        double total = orderAmount;
        switch (jobSize()) {
            case 'M':
                total = total - (orderAmount * 0.01);
                break;
            case 'L':
                total = total - (orderAmount * 0.02);
                break;
            case 'X':
                total = total - (orderAmount * 0.03);
                break;
        }
        if (orderAmount <= 1500) {
            total = total + computeTax();
        }
        return total;
    }
}

