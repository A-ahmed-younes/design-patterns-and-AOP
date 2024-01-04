package org.example.business;

import java.util.ArrayList;
import java.util.List;

class HistoryStrategy implements NotificationStrategy {   private List<Transaction> historique = new ArrayList<>();

    public HistoryStrategy() {
    }

    @Override
    public void traiterNotification(String nomAgent, Transaction transaction) {

        historique.add(transaction);
        System.out.println("Notification reçue avec succès. L'historique des transactions actuellement est : " + historique);
    }
}
