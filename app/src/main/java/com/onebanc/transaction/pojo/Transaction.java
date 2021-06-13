package com.onebanc.transaction.pojo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import static com.onebanc.transaction.constants.TransactionConstants.DEVICE_TIME_FORMAT;
import static com.onebanc.transaction.constants.TransactionConstants.GMT_TIMEZONE;
import static com.onebanc.transaction.constants.TransactionConstants.SERVER_TIME_FORMAT;

public class Transaction implements Comparable{
    private int id;
    private int direction;
    private int type;
    private int status;
    private String startDate;
    private String endDate;
    private double amount;
    private String description;
    private User customer;
    private User partner;
    private DateFormat df1 = new SimpleDateFormat(SERVER_TIME_FORMAT, Locale.ENGLISH);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getAmount() {
        return (int)amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public User getPartner() {
        return partner;
    }

    public void setPartner(User partner) {
        this.partner = partner;
    }

    @Override
    public int compareTo(Object o) {
        Transaction transaction = (Transaction) o;
        if (getStartDate() == null || transaction.getStartDate() == null)
            return 0;

        try {
            Date d1 = df1.parse(getStartDate());
            Date d2 = df1.parse(transaction.getStartDate());
            return d1.compareTo(d2);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public String getReadableDate(){
        String readableDate = getStartDate();
        try {
            Date date = df1.parse(getStartDate());
            SimpleDateFormat sdf = new SimpleDateFormat(DEVICE_TIME_FORMAT, Locale.ENGLISH);
            sdf.setTimeZone(TimeZone.getTimeZone(GMT_TIMEZONE));
            readableDate = sdf.format(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return readableDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", direction=" + direction +
                ", type=" + type +
                ", status=" + status +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", customer=" + customer +
                ", partner=" + partner +
                '}';
    }
}
