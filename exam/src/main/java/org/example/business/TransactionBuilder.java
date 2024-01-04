package org.example.business;

import java.util.Date;

public class TransactionBuilder {
    private String id;
    private Date date;
    private double montant;
    private TransactionType type;

    private TransactionBuilder(String id, Date date, double montant, TransactionType type) {
        this.id = id;
        this.date = date;
        this.montant = montant;
        this.type = type;
    }

    public static TransactionBuilder newInstance(String id, Date date, double montant, TransactionType type) {
        return new TransactionBuilder(id, date, montant, type);
    }

    public TransactionBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public TransactionBuilder setDate(Date date) {
        this.date = date;
        return this;
    }

    public TransactionBuilder setMontant(double montant) {
        this.montant = montant;
        return this;
    }

    public TransactionBuilder setType(TransactionType type) {
        this.type = type;
        return this;
    }

    public Transaction build() {
        return new Transaction(id, date, montant, type);
    }

}

