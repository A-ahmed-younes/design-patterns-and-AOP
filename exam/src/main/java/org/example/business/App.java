package org.example.business;

import org.example.aspects.SecurityContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Date;


public class App {
    public static void main(String[] args) {

        // Créer un agent
        Agent agent = new Agent("Agent1", new ScoringStrategy(6500.0));

        // Créer une transaction en utilisant le pattern builder
        Transaction transaction = TransactionBuilder.newInstance("123", new Date(),100.0, TransactionType.Achat)
                .setId("456")
                .setDate(new Date())
                .setMontant(200.0)
                .setType(TransactionType.Vente)
                .build();

        agent.ajouterTransaction(transaction);

        agent.afficherTransactions();

        // Créer un conteneur d'agents
        AgentContainer conteneurAgent = new AgentContainer();

        conteneurAgent.ajouterAgent(agent);

        // Recherche de l'agent dans le conteneur
        Agent agentRecherche = conteneurAgent.rechercherAgent("Agent1");

        conteneurAgent.afficherAgents();

        // Définition d'une stratégie d'affichage pour l'agent
        conteneurAgent.setAfficheur(new HDMIAfficheur());

        // Notification de l'agent d'une transaction
        agentRecherche.traiterNotification("Agent1", transaction);

        // Créer un agent avec HistoryStrategy
        Agent agent1 = new Agent("Agent1", new HistoryStrategy());

        // Créer un deuxième agent avec ScoringStrategy
        Agent agent2 = new Agent("Agent2", new ScoringStrategy(1000.0));

        // Souscription de agent2 en tant qu'observateur d'agent1
        agent1.ajouterObservateur(agent2);

        agent1.ajouterTransaction(transaction);

        // Affichage des transactions d'agent1
        System.out.println("Transactions de " + agent1.getNom() + ":");
        agent1.afficherTransactions();

        // Affichage des transactions d'agent2
        System.out.println("Transactions de " + agent2.getNom() + ":");

        agent2.afficherTransactions();

        // Utilisation de scoringStrategy pour agent2
        NotificationStrategy scoringStrategy = new ScoringStrategy(500.0);
        agent2.setStrategie(scoringStrategy);

        // Ajout d'une autre transaction à agent1
        Transaction nouvelleTransaction = TransactionBuilder.newInstance("100", new Date(), 1600.0, TransactionType.Achat)
                .build();

        agent1.ajouterTransaction(nouvelleTransaction);

        // Affichage des transactions de agent2 après la nouvelle transaction
        System.out.println("Transactions de " + agent2.getNom() + " après la nouvelle transaction:");
        agent2.afficherTransactions();

        try {
            SecurityContext.authenticate("root", "root", new String[]{"USER", "ADMIN"});
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
            AgentAfficheur metier = applicationContext.getBean(AgentAfficheur.class);
            System.out.println("------------------------");
            System.out.println(metier.getClass().getName());
            System.out.println("------------------------");
            metier.process();
            System.out.println(metier.compute());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

@Configuration
@ComponentScan("org.example")
class MyConfig {
}
