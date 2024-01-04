package org.example.business;

public class ScoringStrategy implements NotificationStrategy {
    private double solde;

    public ScoringStrategy(double solde) {
        this.solde = solde;
    }

    @Override
    public void traiterNotification(String nomAgent, Transaction transaction) {

        if (transaction.getType() == TransactionType.Achat) {
            this.solde -= transaction.getMontant();
        } else {
            this.solde += transaction.getMontant();
        }
        System.out.println("Notification reçue avec succès. Le solde actuellement est : " + this.solde);
    }
}
