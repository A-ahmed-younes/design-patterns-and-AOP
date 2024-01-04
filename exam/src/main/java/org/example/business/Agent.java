package org.example.business;

import org.example.aspects.Cachable;
import org.example.aspects.SecuredByAspect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

class Agent {
    private String nom;
    private List<Transaction> transactions;
    private List<Observer> observateurs;
    private NotificationStrategy strategie;


    public Agent(String nom, NotificationStrategy strategie) {
        this.nom = nom;
        this.transactions = new ArrayList<>();
        this.observateurs = new ArrayList<>();
        this.strategie = strategie;
    }

    public void ajouterTransaction(Transaction transaction) {
        this.transactions.add(transaction);
        notifierObservateurs(transaction);
    }

    public String getNom() {
        return this.nom;
    }

    public void ajouterObservateur(Observer observateur) {
        this.observateurs.add(observateur);
    }

    private void notifierObservateurs(Transaction transaction) {
        for (Observer observateur : observateurs) {
            observateur.notifier(nom, transaction);
        }
    }

    public void traiterNotification(String nomAgent, Transaction transaction) {
        this.strategie.traiterNotification(nomAgent, transaction);
    }

    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    public void afficherTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }


    public Transaction getTransactionMontantMax() {
        Transaction transactionMontantMax = null;
        double montantMax = Double.MIN_VALUE;
        for (Transaction transaction : transactions) {
            if (transaction.getMontant() > montantMax) {
                montantMax = transaction.getMontant();
                transactionMontantMax = transaction;
            }
        }
        return transactionMontantMax;
    }
    public NotificationStrategy getStrategie() {
        return strategie;
    }

    public void setStrategie(NotificationStrategy scoringStrategy) {
        this.strategie = scoringStrategy;
    }

    @Cachable
    public Transaction getTransactionMontantMax1() {
        Transaction transactionMontantMax = null;
        double montantMax = Double.MIN_VALUE;
        for (Transaction transaction : transactions) {
            if (transaction.getMontant() > montantMax) {
                montantMax = transaction.getMontant();
                transactionMontantMax = transaction;
            }
        }
        return transactionMontantMax;
    }

    @SecuredByAspect(roles = {"admin", "supervisor"})
    public void performSensitiveOperation() {
        System.out.println("Opération sensible effectuée avec succès");
    }

}
}