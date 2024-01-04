package org.example.business;

import org.example.aspects.Log;
import org.example.aspects.SecuredByAspect;

import java.util.Date;

public class Transaction {
    private String id;
    private double montant;
    private Date date;
    private TransactionType type;

    Transaction(String id, Date date, double montant, TransactionType type) {
        this.id = id;
        this.date = date;
        this.montant = montant;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public double getMontant() {
        return montant;
    }

    public TransactionType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", montant=" + montant +
                ", type=" + type +
                '}';
    }


    @Override
    @Log
    @SecuredByAspect(roles = {"USER", "ADMIN"}) // both USER and ADMIN have access to this method
    public void process() {
        System.out.println("Business Process ...");

    }

    @Override
    @Log
    @SecuredByAspect(roles = {"ADMIN"}) // ADMIN is the only one who can access this method
    public double compute() {
        double x = 56;
        System.out.println("Business Compute ...");
        return x;
    }
}
